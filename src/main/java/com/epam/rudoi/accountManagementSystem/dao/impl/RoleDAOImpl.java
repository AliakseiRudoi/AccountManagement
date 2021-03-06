package com.epam.rudoi.accountManagementSystem.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.epam.rudoi.accountManagementSystem.dao.IRoleDAO;
import com.epam.rudoi.accountManagementSystem.dao.impl.util.RoleRowMapper;
import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.RoleWithRestLinks;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;


public class RoleDAOImpl extends JdbcDaoSupport implements IRoleDAO{

	 public static final String SQL_CREATE_ROLES = "INSERT INTO ROLES (ROLE_NAME) VALUES (?)";

	 public static final String SQL_READ_ROLE= "SELECT R.ROLE_ID, R.ROLE_NAME FROM ROLES R WHERE ROLE_ID = ?";
		 		
	 public static final String SQL_UPDATE_ROLES= "UPDATE ROLES SET ROLE_NAME=? WHERE ROLE_ID= ?";
	 
	 public static final String SQL_DELETE_ROLES_FROM_ROLES_PERMISSION_GROUPS= "DELETE FROM ROLES_PERMISSION_GROUPS WHERE ROLE_ID = ?";
	 public static final String SQL_DELETE_ROLES_FROM_USERS_ROLES= "DELETE FROM USERS_ROLES WHERE ROLE_ID = ?";
	 public static final String SQL_DELETE_ROLES= "DELETE FROM ROLES WHERE ROLE_ID = ?";
	 
	 public static final String SQL_BATCH_LINK_PERMISSION_GROUPS_WITH_ROLES= "INSERT INTO ROLES_PERMISSION_GROUPS(PERMISSION_GROUP_ID, ROLE_ID) VALUES (?,?)";
	 
	 public static final String SQL_READ_PERMISSION_GROUPS_OF_ROLE = "SELECT r.PERMISSION_GROUP_ID, r.PERMISSION_GROUP_NAME FROM ROLES_PERMISSION_GROUPS pg "
				+ "INNER JOIN PERMISSION_GROUPS r ON pg.PERMISSION_GROUP_ID = r.PERMISSION_GROUP_ID WHERE ROLE_ID=?";
	 public static final String SQL_BATCH_DELETE_PERMISSION_GROUPS_OF_ROLE = "DELETE FROM ROLES_PERMISSION_GROUPS WHERE ROLE_ID = ? AND PERMISSION_GROUP_ID=?";
	 
	 public static final String SQL_BATCH_LINK_SEPARATE_PERMISSIONS_WITH_ROLES= "INSERT INTO ROLES_PERMISSION_GROUPS (PERMISSION_ID, ROLE_ID) VALUES (?,?)";
	 public static final String SQL_READ_SEPARATE_PERMISSIONS_OF_PERMISSION_GROUP = "SELECT r.PERMISSION_ID, r.PERMISSION_NAME FROM ROLES_PERMISSION_GROUPS pg "
				+ "INNER JOIN PERMISSIONS r ON pg.PERMISSION_ID = r.PERMISSION_ID WHERE ROLE_ID=?";
	 public static final String SQL_BATCH_DELETE_SEPARATE_PERMISSIONS_OF_ROLE = "DELETE FROM ROLES_PERMISSION_GROUPS WHERE ROLE_ID = ? AND PERMISSION_ID=?";
	 public static final String SQL_READ_PERMISSIONS_OF_ROLE_PERMISSION_GROUP = "SELECT r.PERMISSION_ID, r.PERMISSION_NAME FROM ROLES_PERMISSION_GROUPS pg "
				+ "INNER JOIN PERMISSIONS r ON pg.PERMISSION_ID = r.PERMISSION_ID WHERE ROLE_ID=?";

	 public static final String SQL_READ_ALL_ROLES = "SELECT ROLE_ID, ROLE_NAME FROM ROLES";
	 
	 public static final String SQL_READ_ALL_SEPARATE_PERMISSIONS_FOR_ROLES = "SELECT R.ROLE_ID, P.PERMISSION_ID, P.PERMISSION_NAME "
	 		+ "FROM ROLES_PERMISSION_GROUPS OG"
	 		+ " INNER JOIN PERMISSIONS P ON P.PERMISSION_ID = OG.PERMISSION_ID"
	 		+ " INNER JOIN ROLES R ON R.ROLE_ID = OG.ROLE_ID";
	 
	 @Autowired
	 private DataSource dataSource;
	 
	public Long create(Role role) throws DAOException {
		Long roleId= (long)getJdbcTemplate().update(SQL_CREATE_ROLES,
				new Object[] { role.getRoleName() });
		return roleId;
	}
	
	@Transactional
	public Role read(Long roleId) throws DAOException {
		Role role = (Role) getJdbcTemplate().queryForObject(SQL_READ_ROLE, new Object[] { roleId }, new BeanPropertyRowMapper(Role.class));
		List<PermissionGroup> permissionGroups = getJdbcTemplate().query(SQL_READ_PERMISSION_GROUPS_OF_ROLE,
				new Object[] { roleId }, new BeanPropertyRowMapper(PermissionGroup.class));
		role.setPermissionGroupList(permissionGroups);

		return role;
	}
	
	
	public void update(Role role) throws DAOException {
		getJdbcTemplate().update(SQL_UPDATE_ROLES,
				new Object[] { role.getRoleName(), role.getRoleId() });
	}

	@Transactional
	public void delete(Long roleId) throws DAOException {
		getJdbcTemplate().update(SQL_DELETE_ROLES_FROM_USERS_ROLES, Long.valueOf(roleId));
		getJdbcTemplate().update(SQL_DELETE_ROLES_FROM_ROLES_PERMISSION_GROUPS, Long.valueOf(roleId));
		getJdbcTemplate().update(SQL_DELETE_ROLES, Long.valueOf(roleId));		
	}

	public void linkWithItems(final Long roleId, final List<PermissionGroup> permissionGroupsList) throws DAOException {
		getJdbcTemplate().batchUpdate(SQL_BATCH_LINK_PERMISSION_GROUPS_WITH_ROLES, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				PermissionGroup permissionGroup = permissionGroupsList.get(i);
				ps.setLong(1, permissionGroup.getPermissionGroupId());
				ps.setLong(2, roleId);
			}
			public int getBatchSize() {
				return permissionGroupsList.size();
			}
		});
	}

	public List<PermissionGroup> readExistItems(Long roleId) throws DAOException {
		List<PermissionGroup> permissionGroups = getJdbcTemplate().query(SQL_READ_PERMISSION_GROUPS_OF_ROLE,
				new Object[] { roleId }, new BeanPropertyRowMapper(PermissionGroup.class));
		return permissionGroups;
	}

	public void unlinkWithItems(final Long roleId, final List<PermissionGroup> permissionGroupsList) throws DAOException {
		getJdbcTemplate().batchUpdate(SQL_BATCH_DELETE_PERMISSION_GROUPS_OF_ROLE, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				PermissionGroup permissionGroup = permissionGroupsList.get(i);
				ps.setLong(1, roleId);
				ps.setLong(2, permissionGroup.getPermissionGroupId());
			}
			public int getBatchSize() {
				return permissionGroupsList.size();
			}
		});
	}
	
	public List<RoleWithRestLinks> getAllRoles() throws DAOException {
		List<RoleWithRestLinks> roles = (List<RoleWithRestLinks>) getJdbcTemplate().query(SQL_READ_ALL_ROLES, new RoleRowMapper());
		return roles;
	}
}
