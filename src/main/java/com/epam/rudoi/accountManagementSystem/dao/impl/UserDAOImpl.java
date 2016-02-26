package com.epam.rudoi.accountManagementSystem.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.epam.rudoi.accountManagementSystem.dao.IUserDAO;
import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;

public class UserDAOImpl extends JdbcDaoSupport implements IUserDAO{

	 public static final String SQL_CREATE_USERS = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, USER_NAME, USER_EMAIL) VALUES (?,?,?,?)";
	
	 public static final String SQL_UPDATE_USERS= "UPDATE USERS SET FIRST_NAME=?, LAST_NAME=?, USER_NAME=?, USER_EMAIL=? WHERE USER_ID = ?";
	 
	 public static final String SQL_DELETE_USERS_FROM_USERS_ROLES= "DELETE FROM USERS_ROLES WHERE USER_ID = ?";
	 public static final String SQL_DELETE_USERS_FROM_USERS_PERMISSIONS= "DELETE FROM USERS_PERMISSIONS WHERE USER_ID = ?";
	 public static final String SQL_DELETE_USERS= "DELETE FROM USERS WHERE USER_ID = ?";
	 
	 public static final String SQL_BATCH_LINK_USERS_WITH_ROLES= "INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (?,?)";
	 public static final String SQL_READ_ROLES_OF_USER = "SELECT r.ROLE_ID, r.ROLE_NAME FROM USERS_ROLES pg "
				+ "INNER JOIN ROLES r ON pg.ROLE_ID = r.ROLE_ID WHERE USER_ID=?";
	 public static final String SQL_BATCH_DELETE_ROLES_OF_USER = "DELETE FROM USERS_ROLES WHERE USER_ID = ? AND ROLE_ID=?";

	 public static final String SQL_BATCH_LINK_USERS_WITH_SEPARATE_PERMISSIONS = "INSERT INTO USERS_PERMISSIONS(USER_ID, PERMISSION_ID) VALUES (?,?)";
	 
	 public static final String SQL_READ_SEPARATE_PERMISSIONS_OF_USER = "SELECT r.PERMISSION_ID, r.PERMISSION_NAME FROM USERS_PERMISSIONS pg "
				+ "INNER JOIN PERMISSIONS r ON pg.PERMISSION_ID = r.PERMISSION_ID WHERE USER_ID=?";
	 public static final String SQL_BATCH_DELETE_SEPARATE_PERMISSIONS_OF_USER = "DELETE FROM USERS_PERMISSIONS WHERE USER_ID = ? AND PERMISSION_ID=?";
	
	 public static final String SQL_READ_USER = "SELECT U.USER_ID, U.FIRST_NAME, U.LAST_NAME, U.USER_NAME, U.USER_EMAIL FROM USERS U WHERE U.USER_ID = ?";
	 
	 public static final String SQL_READ_ALL_USERS = "SELECT U.USER_ID, U.FIRST_NAME, U.LAST_NAME, U.USER_NAME, U.USER_EMAIL FROM USERS U";
	 
	 @Autowired
	 private DataSource dataSource;
	 
	 public List<User> getAllUsers() throws DAOException {
		 List<User> users = (List<User>) getJdbcTemplate().query(SQL_READ_ALL_USERS, new BeanPropertyRowMapper(User.class));
			return users;
		}
	 
	public Long create(User user) throws DAOException {
		Long userId= (long)getJdbcTemplate().update(SQL_CREATE_USERS,
				new Object[] { user.getFirstName(), user.getLastName(), user.getUserName(), user.getUserEmail() });
		return userId;
	}

	@Transactional
	public User read(Long userId) throws DAOException {
		User user = (User) getJdbcTemplate().queryForObject(SQL_READ_USER,
				new Object[] { userId }, new BeanPropertyRowMapper(User.class));
		List<Role> roles = getJdbcTemplate().query(SQL_READ_ROLES_OF_USER,
				new Object[] { userId }, new BeanPropertyRowMapper(Role.class));
		List<Permission> permissions = getJdbcTemplate().query(SQL_READ_SEPARATE_PERMISSIONS_OF_USER,
				new Object[] { userId }, new BeanPropertyRowMapper(Permission.class));
		user.setRolesList(roles);
		user.setSeparatePermissionsList(permissions);
		
		return user;
	}

	public void update(User user) throws DAOException {
		getJdbcTemplate().update(SQL_UPDATE_USERS,
				new Object[] { user.getFirstName(), user.getLastName(), user.getUserName(), user.getUserEmail(), user.getUserId() });
	}

	@Transactional
	public void delete(Long userId) throws DAOException {
		getJdbcTemplate().update(SQL_DELETE_USERS_FROM_USERS_PERMISSIONS, Long.valueOf(userId));
		getJdbcTemplate().update(SQL_DELETE_USERS_FROM_USERS_ROLES, Long.valueOf(userId));
		getJdbcTemplate().update(SQL_DELETE_USERS, Long.valueOf(userId));
	}

	public void linkWithItems(final Long userId,final List<Role> rolesList) throws DAOException {
		getJdbcTemplate().batchUpdate(SQL_BATCH_LINK_USERS_WITH_ROLES, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Role  role = rolesList.get(i);
				ps.setLong(1, userId);
				ps.setLong(2, role.getRoleId());
				
			}
			public int getBatchSize() {
				return rolesList.size();
			}
		});
	}

	public List<Role> readExistItems(Long userId) throws DAOException {
		List<Role> roles = getJdbcTemplate().query(SQL_READ_ROLES_OF_USER,
				new Object[] { userId }, new BeanPropertyRowMapper(Role.class));
		return roles;
	}

	public void unlinkWithItems(final Long userId, final List<Role> rolesList) throws DAOException {
		getJdbcTemplate().batchUpdate(SQL_BATCH_DELETE_ROLES_OF_USER, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Role role = rolesList.get(i);
				ps.setLong(1, userId);
				ps.setLong(2, role.getRoleId());
			}
			public int getBatchSize() {
				return rolesList.size();
			}
		});
	}

	@Override
	public void linkWithSeparatePermissions(Long userId, List<Permission> permissionsToLinking) throws DAOException {
		getJdbcTemplate().batchUpdate(SQL_BATCH_LINK_USERS_WITH_SEPARATE_PERMISSIONS, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Permission  permission = permissionsToLinking.get(i);
				ps.setLong(1, userId);
				ps.setLong(2, permission.getPermissionId());
				
			}
			public int getBatchSize() {
				return permissionsToLinking.size();
			}
		});
	}

	@Override
	public List<Permission> readExistSeparatePermissions(Long userId) throws DAOException {
		List<Permission> permissions = getJdbcTemplate().query(SQL_READ_SEPARATE_PERMISSIONS_OF_USER,
				new Object[] { userId }, new BeanPropertyRowMapper(Permission.class));
		return permissions;
	}

	@Override
	public void unlinkWithSeparatePermissions(Long userId, List<Permission> permissionsToUnlinking)
			throws DAOException {
		
		getJdbcTemplate().batchUpdate(SQL_BATCH_DELETE_SEPARATE_PERMISSIONS_OF_USER, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Permission permission = permissionsToUnlinking.get(i);
				ps.setLong(1, userId);
				ps.setLong(2, permission.getPermissionId());
			}
			public int getBatchSize() {
				return permissionsToUnlinking.size();
			}
		});
		
	}
	
}
