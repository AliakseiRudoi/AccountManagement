package com.epam.rudoi.accountManagementSystem.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.rudoi.accountManagementSystem.dao.IPermissionDAO;
import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;

public class PermissionDAOImpl extends JdbcDaoSupport implements IPermissionDAO{

	 public static final String SQL_CREATE_PERMISSION = "INSERT INTO PERMISSIONS (PERMISSION_NAME) VALUES (?)";
	 public static final String SQL_READ_PERMISSION= "SELECT * FROM PERMISSIONS WHERE PERMISSION_ID = ?";
	 public static final String SQL_UPDATE_PERMISSION= "UPDATE PERMISSIONS SET PERMISSION_NAME=? WHERE PERMISSION_ID= ?";
	 public static final String SQL_DELETE_PERMISSION= "DELETE FROM PERMISSIONS WHERE PERMISSION_ID = ?";
	 public static final String SQL_SELECT_ALL_PERMISSIONS = "SELECT * FROM PERMISSIONS";
	
	public Long create(Permission permission) throws DAOException {
		Long permissionId= (long)getJdbcTemplate().update(SQL_CREATE_PERMISSION,
				new Object[] { permission.getPermissionName() });
		return permissionId;
	}

	public Permission read(Long permissionId) throws DAOException {
		Permission permission = (Permission)getJdbcTemplate().queryForObject(
				SQL_READ_PERMISSION, new Object[] { permissionId }, 
				new BeanPropertyRowMapper(Permission.class));
		return permission;
	}

	public void update(Permission permission) throws DAOException {
		getJdbcTemplate().update(SQL_UPDATE_PERMISSION,
				new Object[] { permission.getPermissionName(), permission.getPermissionId() });		
	}

	public void delete(Long permissionId) throws DAOException {
		getJdbcTemplate().update(SQL_DELETE_PERMISSION, Long.valueOf(permissionId));
	}

	public List<Permission> getAllPermissions() throws DAOException {
		List<Permission> permissions = getJdbcTemplate().query(SQL_SELECT_ALL_PERMISSIONS,
				new BeanPropertyRowMapper(Permission.class));
		return permissions;
	}

}
