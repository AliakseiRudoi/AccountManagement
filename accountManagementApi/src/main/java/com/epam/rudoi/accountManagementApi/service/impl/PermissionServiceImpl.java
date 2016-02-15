package com.epam.rudoi.accountManagementApi.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.rudoi.accountManagementApi.dao.IPermissionDAO;
import com.epam.rudoi.accountManagementApi.entity.Permission;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;
import com.epam.rudoi.accountManagementApi.service.IPermissionService;

public class PermissionServiceImpl implements IPermissionService{
	
	private static final Logger LOGGER = Logger.getLogger(PermissionServiceImpl.class);
	
	@Autowired
	private IPermissionDAO permissionDAO;
	
	public Long createPermission(Permission permission) throws ServiceException {
		Long permissionId = null;
		try {
			permissionId = permissionDAO.create(permission);
		} catch (DAOException e) {
			LOGGER.error("Create permission exeption", e);
		    throw new ServiceException(e);
		}
		return permissionId;
	}
	
	public Permission readPermission(Long permissionId) throws ServiceException {
		Permission permission = null;
		try {
			permission = permissionDAO.read(permissionId);
		} catch (DAOException e) {
			LOGGER.error("Read permission exeption", e);
		    throw new ServiceException(e);
		}
		return permission;
	}

	public void updatePermission(Permission permission) throws ServiceException {
		try {
			permissionDAO.update(permission);
		} catch (DAOException e) {
			LOGGER.error("Update permission exeption", e);
		    throw new ServiceException(e);
		}
	}

	public void deletePermission(Long permissionId) throws ServiceException {
		try {
			permissionDAO.delete(permissionId);
		} catch (DAOException e) {
			LOGGER.error("Delete permission exeption", e);
		    throw new ServiceException(e);
		}
	}

	public List<Permission> getAllPermissions() throws ServiceException {
		List<Permission> permissions = null;
		try {
			permissions = permissionDAO.getAllPermissions();
		} catch (DAOException e) {
			LOGGER.error("Get all permissions exeption", e);
		    throw new ServiceException(e);
		}
		return permissions;
	}

}
