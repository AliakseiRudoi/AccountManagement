package com.epam.rudoi.accountManagementSystem.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.rudoi.accountManagementSystem.dao.IPermissionGroupDAO;
import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;

public class PermissionGroupDAOImpl extends JdbcDaoSupport implements IPermissionGroupDAO {

	public static final String SQL_CREATE_PERMISSION_GROUPS = "INSERT INTO PERMISSION_GROUPS (PERMISSION_GROUP_NAME) VALUES (?)";
	public static final String SQL_READ_PERMISSION_GROUPS = "SELECT * FROM PERMISSION_GROUPS WHERE PERMISSION_GROUP_ID= ?";
	public static final String SQL_UPDATE_PERMISSION_GROUPS = "UPDATE PERMISSION_GROUPS SET PERMISSION_GROUP_NAME=? WHERE PERMISSION_GROUP_ID= ?";
	
	
	public static final String SQL_DELETE_PERMISSION_GROUP_FROM_PERMISSIONS_PERMISSION_GROUPS = "DELETE FROM PERMISSIONS_PERMISSION_GROUPS WHERE PERMISSION_GROUP_ID = ?";
	public static final String SQL_DELETE_PERMISSION_GROUP_FROM_ROLES_PERMISSION_GROUPS = "DELETE FROM ROLES_PERMISSION_GROUPS WHERE PERMISSION_GROUP_ID = ?";
	public static final String SQL_DELETE_PERMISSION_GROUP = "DELETE FROM PERMISSION_GROUPS WHERE PERMISSION_GROUP_ID = ?";
	
	public static final String SQL_SELECT_ALL_PERMISSION_GROUPS = "SELECT * FROM PERMISSION_GROUPS";
	
	public static final String SQL_BATCH_LINK_PERMISSIONS_WITH_PERMISSION_GROUP = "INSERT INTO PERMISSIONS_PERMISSION_GROUPS(PERMISSION_ID, PERMISSION_GROUP_ID) VALUES (?,?)";
	public static final String SQL_READ_PERMISSIONS_OF_PERMISSION_GROUP = "SELECT p.PERMISSION_ID, p.PERMISSION_NAME FROM PERMISSIONS_PERMISSION_GROUPS pg "
			+ "INNER JOIN PERMISSIONS p ON pg.PERMISSION_ID = p.PERMISSION_ID WHERE pg.PERMISSION_GROUP_ID=?";
	public static final String SQL_BATCH_DELETE_PERMISSION_GROUPS = "DELETE FROM PERMISSIONS_PERMISSION_GROUPS WHERE PERMISSION_ID = ? AND PERMISSION_GROUP_ID=?";
	
	
	@Autowired
	private DataSource dataSource;

	public Long create(PermissionGroup permissionGroup) throws DAOException {
		Long permissionGroupId = (long) getJdbcTemplate().update(SQL_CREATE_PERMISSION_GROUPS,
				new Object[] { permissionGroup.getPermissionGroupName() });
		return permissionGroupId;
	}

	public PermissionGroup read(Long permissionGroupId) throws DAOException {
		PermissionGroup permissionGroup = (PermissionGroup) getJdbcTemplate().queryForObject(SQL_READ_PERMISSION_GROUPS,
				new Object[] { permissionGroupId }, new BeanPropertyRowMapper(PermissionGroup.class));
		return permissionGroup;
	}

	public void update(PermissionGroup permissionGroup) throws DAOException {
		getJdbcTemplate().update(SQL_UPDATE_PERMISSION_GROUPS,
				new Object[] { permissionGroup.getPermissionGroupName(), permissionGroup.getPermissionGroupId() });
	}

	public void delete(Long permissionGroupId) throws DAOException {
		getJdbcTemplate().update(SQL_DELETE_PERMISSION_GROUP_FROM_PERMISSIONS_PERMISSION_GROUPS, Long.valueOf(permissionGroupId));
		getJdbcTemplate().update(SQL_DELETE_PERMISSION_GROUP_FROM_ROLES_PERMISSION_GROUPS, Long.valueOf(permissionGroupId));
		getJdbcTemplate().update(SQL_DELETE_PERMISSION_GROUP, Long.valueOf(permissionGroupId));
	}

	public void linkWithItems(final Long permissionGroupId, final List<Permission> permissionsList) throws DAOException {

		getJdbcTemplate().batchUpdate(SQL_BATCH_LINK_PERMISSIONS_WITH_PERMISSION_GROUP, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Permission permission = permissionsList.get(i);
				ps.setLong(1, permission.getPermissionId());
				ps.setLong(2, permissionGroupId);
			}

			public int getBatchSize() {
				return permissionsList.size();
			}
		});
	}

	public List<Permission> readExistItems(Long permissionGroupId) throws DAOException {
		List<Permission> permissions = getJdbcTemplate().query(SQL_READ_PERMISSIONS_OF_PERMISSION_GROUP,
				new Object[] { permissionGroupId }, new BeanPropertyRowMapper(Permission.class));
		return permissions;
	}

	public void unlinkWithItems(final Long permissionGroupId, final List<Permission> permissionsList) throws DAOException {
		getJdbcTemplate().batchUpdate(SQL_BATCH_DELETE_PERMISSION_GROUPS, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Permission permission = permissionsList.get(i);
				ps.setLong(1, permission.getPermissionId());
				ps.setLong(2, permissionGroupId);
			}
			public int getBatchSize() {
				return permissionsList.size();
			}
		});
	}

	public List<PermissionGroup> getAllPermissionGroups() throws DAOException {
		List<PermissionGroup> permissionGroups = getJdbcTemplate().query(SQL_SELECT_ALL_PERMISSION_GROUPS,
				new BeanPropertyRowMapper(PermissionGroup.class));
		return permissionGroups;
	}
	
}
