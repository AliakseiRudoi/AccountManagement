package com.epam.rudoi.accountManagementApi.service;

import java.util.List;

import com.epam.rudoi.accountManagementApi.entity.Permission;
import com.epam.rudoi.accountManagementApi.entity.PermissionGroup;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;

public interface IPermissionGroupService {

	/**
	 * Create permission group
	 * This method create the permission group
	 * @param PermissionGroup entity
	 * @return the long PermissionGroup id
	 * @throws ServiceException the service exception
	 */
	Long createPermissionGroup(PermissionGroup permissionGroup) throws ServiceException;
	
	/**
	 * Read permission group
	 * This method read permission
	 * @param permission groupId the permission group id
	 * @return PermissionGroup 
	 * @throws ServiceException the service exception
	 */
	PermissionGroup readPermissionGroup(Long permissionGroupId) throws ServiceException;
	
	/**
	 * Update the permission group
	 * This method update permission group
	 * @param PermissionGroup entity
	 * @throws ServiceException the service exception
	 */
	void updatePermissionGroup(PermissionGroup permissionGroup) throws ServiceException;
	
	/**
	 * Delete permission group
	 * This method delete permission group
	 * @param PermissionGroupId the permission id
	 * @throws ServiceException the service exception
	 */
	void deletePermissionGroup(Long permissionGroupId) throws ServiceException;
	
	/**
	 * Read all permission group that are exist
	 * This method read all permission group that are exist
	 * @return List<PermissionGroup> list of permission group  
	 * @throws ServiceException the service exception
	 */
	List<PermissionGroup> getAllPermissionGroups() throws ServiceException;
	
	/**
	 * Associate current permission group with permissions
	 * This method associate current permission group with permissions.   
	 * @param permissionGroupId the permission group id 
	 * @param permissionsList the list of permissions
	 * @throws ServiceException the service exception
	 */
	void linkWithPermissions(Long permissionGroupId, List<Permission> permissionsToLinking) throws ServiceException;
	
	/**
	 * Read all permissions that have been associated with current permission group yet and that are exist
	 * This method read all permissions that have been associated with current permission group yet and that are exist 
	 * @return List<Permission> list of permissions that associate with the group 
	 * @param permissionGroupId the permission group id
	 * @throws ServiceException the service exception
	 */
	List<Permission> readExistPermissions(Long permissionGroupId) throws ServiceException;

	/**
	 * Disassociate permissions this current permission group
	 * This method disassociate permissions this current permission group
	 * @param permissionGroupId the permission group entity
	 * @param permissionsList the list of permissions
	 * @throws ServiceException the service exception
	 */
	void unlinkWithPermissions(Long permissionGroupId, List<Permission> permissionsToUnlinking) throws ServiceException;
	
}
