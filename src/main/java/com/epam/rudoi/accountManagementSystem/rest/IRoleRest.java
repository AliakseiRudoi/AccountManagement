package com.epam.rudoi.accountManagementSystem.rest;

import java.util.List;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;

public interface IRoleRest {

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
	void linkWithPermissionGroups(Role role) throws ServiceException;
	
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
	void unlinkWithPermissionGroups(Role role) throws ServiceException;
	
}
