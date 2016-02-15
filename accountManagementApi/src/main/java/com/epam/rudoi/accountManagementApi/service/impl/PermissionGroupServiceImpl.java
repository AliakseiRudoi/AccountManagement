package com.epam.rudoi.accountManagementApi.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.epam.rudoi.accountManagementApi.dao.IPermissionGroupDAO;
import com.epam.rudoi.accountManagementApi.entity.Permission;
import com.epam.rudoi.accountManagementApi.entity.PermissionGroup;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;
import com.epam.rudoi.accountManagementApi.service.IPermissionGroupService;

public class PermissionGroupServiceImpl implements IPermissionGroupService{

	private static final Logger LOGGER = Logger.getLogger(PermissionGroupServiceImpl.class);
	
	@Autowired
	private IPermissionGroupDAO permissionGroupDAO;
	
	public Long createPermissionGroup(PermissionGroup permissionGroup) throws ServiceException {
		Long permissionGroupId = null;
		try {
			permissionGroupId = permissionGroupDAO.create(permissionGroup);
		} catch (DAOException e) {
			LOGGER.error("Create permission group exeption", e);
		    throw new ServiceException(e);
		}
		return permissionGroupId;
	}

	public PermissionGroup readPermissionGroup(Long permissionGroupId) throws ServiceException {
		PermissionGroup permissionGroup = null;
		try {
			permissionGroup = permissionGroupDAO.read(permissionGroupId);
		} catch (DAOException e) {
			LOGGER.error("Read permission group exeption", e);
		    throw new ServiceException(e);
		}
		return permissionGroup;
	}

	public void updatePermissionGroup(PermissionGroup permissionGroup) throws ServiceException {
		try {
			permissionGroupDAO.update(permissionGroup);
		} catch (DAOException e) {
			LOGGER.error("Update permission group exeption", e);
		    throw new ServiceException(e);
		}
	}

	public void deletePermissionGroup(Long permissionGroupId) throws ServiceException {
		try {
			permissionGroupDAO.delete(permissionGroupId);
		} catch (DAOException e) {
			LOGGER.error("Delete permission group exeption", e);
		    throw new ServiceException(e);
		}
	}

	public List<PermissionGroup> getAllPermissionGroups() throws ServiceException {
		List<PermissionGroup> permissionGroups = null;
		try {
			permissionGroups = permissionGroupDAO.getAllPermissionGroups();
		} catch (DAOException e) {
			LOGGER.error("Get all permission groups exeption", e);
		    throw new ServiceException(e);
		}
		return permissionGroups;
	}

	public void linkWithPermissions(Long permissionGroupId, List<Permission> permissionsToLinking) throws ServiceException {
		try {
			permissionGroupDAO.linkWithItems(permissionGroupId, permissionsToLinking);
		} catch (DAOException e) {
			LOGGER.error("Linking permissions with permission group "+permissionGroupId+" exeption", e);
		    throw new ServiceException(e);
		}
		
	}

	public List<Permission> readExistPermissions(Long permissionGroupId) throws ServiceException {
		List<Permission> existPermissions = null;
		try {
			existPermissions = permissionGroupDAO.readExistItems(permissionGroupId);
		} catch (DAOException e) {
			LOGGER.error("Reading exist permissions for permission group "+ permissionGroupId +" exeption", e);
		    throw new ServiceException(e);
		}
		return existPermissions;
	}

	public void unlinkWithPermissions(Long permissionGroupId, List<Permission> permissionsToUnlinking)
			throws ServiceException {
		try {
			permissionGroupDAO.unlinkWithItems(permissionGroupId, permissionsToUnlinking);
		} catch (DAOException e) {
			LOGGER.error("Unlinking permissions with permission group "+ permissionGroupId +" exeption", e);
		    throw new ServiceException(e);
		}
	}
	
}
