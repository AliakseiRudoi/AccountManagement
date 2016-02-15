package com.epam.rudoi.accountManagementApi.service;

import java.util.List;

import com.epam.rudoi.accountManagementApi.entity.Permission;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;

public interface IPermissionService {

	/**
	 * Create permission
	 * This method create the permission
	 * @param permission entity
	 * @return the long permission id
	 * @throws ServiceException the service exception
	 */
	Long createPermission(Permission permission) throws ServiceException;
	
	/**
	 * Read permission
	 * This method read permission
	 * @param permissionId the permission id
	 * @return Permission 
	 * @throws ServiceException the service exception
	 */
	Permission readPermission (Long permissionId) throws ServiceException;
	
	/**
	 * Update the permission.
	 * This method update permission
	 * @param Permission entity
	 * @throws ServiceException the service exception
	 */
	void updatePermission (Permission permission) throws ServiceException;
	
	/**
	 * Delete permission.
	 * This method delete permission
	 * @param permissionId the permission id
	 * @throws ServiceException the service exception
	 */
	void deletePermission (Long permissionId) throws ServiceException;
	
	/**
	 * Read all permissions that are exist.
	 * This method Read all permissions that are exist.
	 * @return List<Permission> list of permissions  
	 * @throws ServiceException the service exception
	 */
	List<Permission> getAllPermissions() throws ServiceException;
	
}
