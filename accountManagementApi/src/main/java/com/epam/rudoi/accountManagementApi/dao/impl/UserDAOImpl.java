package com.epam.rudoi.accountManagementApi.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.rudoi.accountManagementApi.dao.IUserDAO;
import com.epam.rudoi.accountManagementApi.entity.Role;
import com.epam.rudoi.accountManagementApi.entity.User;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;

public class UserDAOImpl extends JdbcDaoSupport implements IUserDAO{

	 public static final String SQL_CREATE_USERS = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, USER_NAME, USER_EMAIL) VALUES (?,?,?,?)";
	 public static final String SQL_READ_USER= "SELECT * FROM USERS WHERE USER_ID = ?";
	 public static final String SQL_UPDATE_USERS= "UPDATE USERS SET FIRST_NAME=?, LAST_NAME=?, USER_NAME=?, USER_EMAIL=? WHERE USER_ID = ?";
	 public static final String SQL_DELETE_USERS= "DELETE FROM USERS WHERE USER_ID = ?";
	 public static final String SQL_BATCH_LINK_USERS_WITH_ROLES= "INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (?,?)";
	 public static final String SQL_READ_ROLES_OF_USER = "SELECT r.ROLE_ID, r.ROLE_NAME FROM USERS_ROLES pg "
				+ "INNER JOIN ROLES r ON pg.ROLE_ID = r.ROLE_ID WHERE USER_ID=?";
	 public static final String SQL_BATCH_DELETE_ROLES_OF_USER = "DELETE FROM USERS_ROLES WHERE USER_ID = ? AND ROLE_ID=?";
	 public static final String SQL_SELECT_ALL_USERS= "SELECT * FROM USERS";
	 
	 @Autowired
	 private DataSource dataSource;
	 
	public Long create(User user) throws DAOException {
		Long userId= (long)getJdbcTemplate().update(SQL_CREATE_USERS,
				new Object[] { user.getFirstName(), user.getLastName(), user.getUserName(), user.getUserEmail() });
		return userId;
	}

	public User read(Long userId) throws DAOException {
		User user = (User)getJdbcTemplate().queryForObject(
				SQL_READ_USER, new Object[] { userId }, 
				new BeanPropertyRowMapper(User.class));
		return user;
	}

	public void update(User user) throws DAOException {
		getJdbcTemplate().update(SQL_UPDATE_USERS,
				new Object[] { user.getFirstName(), user.getLastName(), user.getUserName(), user.getUserEmail(), user.getUserId() });
	}

	public void delete(Long userId) throws DAOException {
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

	public List<User> getAllUsers() throws DAOException {
		List<User> usersList = getJdbcTemplate().query(SQL_SELECT_ALL_USERS,
				new BeanPropertyRowMapper(User.class));
		return usersList;
	}


}
