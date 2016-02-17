package com.epam.rudoi.accountManagementSystem.service;

import java.util.List;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;

public interface IRoleService {

	/**
	 * Create role
	 * This method create the role
	 * @param Role entity
	 * @return the long role id
	 * @throws ServiceException the service exception
	 */
	Long createRole(Role role) throws ServiceException;
	
	/**
	 * Read role
	 * This method read the role
	 * @param permission roleId the role id
	 * @return Role 
	 * @throws ServiceException the service exception
	 */
	Role readRole(Long roleId) throws ServiceException;
	
	/**
	 * Update the role
	 * This method update the role
	 * @param Role entity
	 * @throws ServiceException the service exception
	 */
	void updateRole(Role role) throws ServiceException;
	
	/**
	 * Delete role
	 * This method delete the role
	 * @param roleId the role id
	 * @throws ServiceException the service exception
	 */
	void deleteRole(Long roleId) throws ServiceException;
	
	/**
	 * Read all roles that are exist
	 * This method read all roles that are exist
	 * @return List<Role> list of roles
	 * @throws ServiceException the service exception
	 */
	List<Role> getAllRoles() throws ServiceException;
	
	/**
	 * Associate current role with permission groups
	 * This method associate current role with permission group.   
	 * @param roleId the role id 
	 * @param permissionGroupsList the list of permission groups
	 * @throws ServiceException the service exception
	 */
	void linkWithPermissionGroups(Long roleId, List<PermissionGroup> permissionGroupsToLinking) throws ServiceException;
	
	/**
	 * Read all permission groups that have been associated with current role yet and that are exist
	 * This method read all permission groups that have been associated with current role yet and that are exist 
	 * @return List<Permissiongroup> list of permission groups that associate with the role
	 * @param roleId the role id
	 * @throws ServiceException the service exception
	 */
	List<PermissionGroup> readExistPermissiongroups(Long roleId) throws ServiceException;

	/**
	 * Disassociate permission groups with current permission role
	 * This method disassociate permission groups with current permission role
	 * @param roleId the role entity
	 * @param permissionGroupsList the list of permission groups
	 * @throws ServiceException the service exception
	 */
	void unlinkWithPermissionGroups(Long roleId, List<PermissionGroup> permissionGroupsToUnlinking) throws ServiceException;
	
	/**
	 * Associate current role with some separate permissions
	 * This method associate role with some separate permissions. For example associate Role entity with one or more permissions   
	 * @param entityId the entity id 
	 * @param permissionsList the list of permissions
	 * @throws ServiceException the service exception
	 */
	void linkWithSeparatePermissions (Long roleId, List<Permission> permissionsToLinking) throws ServiceException;
	
	/**
	 * Read all separate permissions that have been associated yet and that are exist.
	 * This method read all separate permissions that have been associated yet and that are exist
	 * @return List<Permission> list of permissions that associate with the group 
	 * @param entityId the entity id
	 * @throws ServiceException the service exception
	 */
	List<Permission> readExistSeparatePermissions (Long roleId) throws ServiceException;

	/**
	 * Disassociate role this separate permissions
	 * This method disassociate role with separate permissions
	 * @param entityId the entity id 
	 * @param permissionsList the list of permissions
	 * @throws ServiceException the service exception
	 */
	void unlinkWithSeparatePermissions (Long roleId, List<Permission> permissionsToUnlinking) throws ServiceException;
	
}
