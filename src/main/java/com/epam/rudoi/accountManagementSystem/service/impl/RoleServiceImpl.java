package com.epam.rudoi.accountManagementSystem.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.rudoi.accountManagementSystem.dao.IRoleDAO;
import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;
import com.epam.rudoi.accountManagementSystem.service.IRoleService;

public class RoleServiceImpl implements IRoleService{

	private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private IRoleDAO roleDAO;
	
	public Long createRole(Role role) throws ServiceException {
		Long roleId = null;
		try {
			roleId = roleDAO.create(role);
		} catch (DAOException e) {
			LOGGER.error("Create role exeption", e);
		    throw new ServiceException(e);
		}
		return roleId;
	}

	public Role readRole(Long roleId) throws ServiceException {
		Role role = null;
		try {
			role = roleDAO.read(roleId);
		} catch (DAOException e) {
			LOGGER.error("Read role exeption", e);
		    throw new ServiceException(e);
		}
		return role;
	}

	public void updateRole(Role role) throws ServiceException {
		try {
			roleDAO.update(role);
		} catch (DAOException e) {
			LOGGER.error("Update role exeption", e);
		    throw new ServiceException(e);
		}		
	}
	
	public void deleteRole(Long roleId) throws ServiceException {
		try {
			roleDAO.delete(roleId);
		} catch (DAOException e) {
			LOGGER.error("Delete role exeption", e);
		    throw new ServiceException(e);
		}
	}

	public List<Role> getAllRoles() throws ServiceException {
		List<Role> roles = null;
		try {
			roles = roleDAO.getAllRoles();
		} catch (DAOException e) {
			LOGGER.error("Get all roles exeption", e);
		    throw new ServiceException(e);
		}
		return roles;
	}

	public void linkWithPermissionGroups(Long roleId, List<PermissionGroup> permissionGroupsToLinking)
			throws ServiceException {
		try {
			roleDAO.linkWithItems(roleId, permissionGroupsToLinking);
		} catch (DAOException e) {
			LOGGER.error("Linking permission groups with role "+roleId+" exeption", e);
		    throw new ServiceException(e);
		}
	}

	public List<PermissionGroup> readExistPermissiongroups(Long roleId) throws ServiceException {
		List<PermissionGroup> permissionGroups = null;
		try {
			roleDAO.readExistItems(roleId);
		} catch (DAOException e) {
			LOGGER.error("Reading exist permission groups for role "+ roleId +" exeption", e);
		    throw new ServiceException(e);
		}
		return permissionGroups;
	}

	public void unlinkWithPermissionGroups(Long roleId, List<PermissionGroup> permissionGroupsToUnlinking)
			throws ServiceException {
		try {
			roleDAO.unlinkWithItems(roleId, permissionGroupsToUnlinking);
		} catch (DAOException e) {
			LOGGER.error("Unlinking permission groups with role "+ roleId +" exeption", e);
		    throw new ServiceException(e);
		}
	}

}
