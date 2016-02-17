package com.epam.rudoi.accountManagementSystem.service;

import java.util.List;

import com.epam.rudoi.accountManagementSystem.entity.Content;
import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;

public interface IAccountManagerFacadeService {

	/* Content */
	
	/**
	 * Create content
	 * This method create the content
	 * @param Content entity
	 * @return the long content id
	 * @throws ServiceException the service exception
	 */
	Long createContent (Content content) throws ServiceException;
	
	/**
	 * Read content
	 * This method read content
	 * @param Content entity
	 * @return the Content 
	 * @throws ServiceException the DAO exception
	 */
	Content readContent (Long  contentId) throws ServiceException;
	
	/**
	 * Update the content.
	 * This method update content
	 * @param Content entity
	 * @throws ServiceException the DAO exception
	 */
	void updateContent (Content content) throws ServiceException;
	
	/**
	 * Delete content.
	 * This method delete content
	 * @param Content entity
	 * @throws ServiceException the DAO exception
	 */
	void deleteContent (Long contentId) throws ServiceException;
	
	/* Permission */
	
	/**
	 * Create permission
	 * This method create the permission
	 * @param Permission entity 
	 * @return the long permission id
	 * @throws ServiceException the service exception
	 */
	Long createPermission(Permission permission) throws ServiceException;
	
	/**
	 * Read permission
	 * This method read permission
	 * @param Permission entity
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
	 * @param Permission entity
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
	
	/* PermissionGroup */
	
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
	 * @param PermissionGroup entity
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
	 * @param PermissionGroup entity
	 * @throws ServiceException the service exception
	 */
	void deletePermissionGroup(Long permissionGroupId) throws ServiceException;
	
	/**
	 * Read all permission group that are exist
	 * This method read all permission group that are exist
	 * @param PermissionGroup entity
	 * @throws ServiceException the service exception
	 */
	List<PermissionGroup> getAllPermissionGroups() throws ServiceException;
	
	/**
	 * Associate current permission group with permissions
	 * This method associate current permission group with permissions.   
	 * @param PermissionGroup entity
	 * @throws ServiceException the service exception
	 */
	void linkPermissionGroupWithPermissions(PermissionGroup permissionGroup) throws ServiceException;
	
	/**
	 * Read all permissions that have been associated with current permission group yet and that are exist
	 * This method read all permissions that have been associated with current permission group yet and that are exist 
	 * @return List<Permission> list of permissions that associate with the group 
	 * @param PermissionGroup entity
	 * @throws ServiceException the service exception
	 */
	List<Permission> readExistPermissionsOfPermissionGroup(Long permissionGroupId) throws ServiceException;

	/**
	 * Disassociate permissions this current permission group
	 * This method disassociate permissions this current permission group
	 * @param PermissionGroup entity
	 * @throws ServiceException the service exception
	 */
	void unlinkPermissionGroupFromPermissions(PermissionGroup permissionGroup) throws ServiceException;
	
	/* Role */
	
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
	 * @param Role entity
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
	 * @param Role entity
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
	 * @param Role entity
	 * @throws ServiceException the service exception
	 */
	void linkRoleWithPermissionGroups(Role role) throws ServiceException;
	
	/**
	 * Read all permission groups that have been associated with current role yet and that are exist
	 * This method read all permission groups that have been associated with current role yet and that are exist 
	 * @return List<Permissiongroup> list of permission groups that associate with the role
	 * @param Role entity
	 * @throws ServiceException the service exception
	 */
	List<PermissionGroup> readExistPermissiongroupsOfRole(Long roleId) throws ServiceException;

	/**
	 * Disassociate permission groups with current permission role
	 * This method disassociate permission groups with current permission role
	 * @param Role entity
	 * @throws ServiceException the service exception
	 */
	void unlinkPermissionGroupsFromRole(Role role) throws ServiceException;
	
	/**
	 * Associate current role with some separate permissions
	 * This method associate role with some separate permissions. For example associate Role entity with one or more permissions   
	 * @param Role the role entity
	 * @throws ServiceException the service exception
	 */
	void linkRoleWithSeparatePermissions (Role role) throws ServiceException;
	
	/**
	 * Read all separate permissions that have been associated yet and that are exist.
	 * This method read all separate permissions that have been associated yet and that are exist
	 * @return List<Permission> list of permissions that associate with the group 
	 * @param Role the role entity
	 * @throws ServiceException the service exception
	 */
	List<Permission> readExistSeparatePermissionsOfRole (Long roleId) throws ServiceException;

	/**
	 * Disassociate role this separate permissions
	 * This method disassociate role with separate permissions
	 * @param Role the role entity
	 * @throws ServiceException the service exception
	 */
	void unlinkSeparatePermissionsFromRole (Role role) throws ServiceException;
	
	/* User */
	
	/**
	 * Create user
	 * This method create the user
	 * @param User entity
	 * @return the long user id
	 * @throws ServiceException the service exception
	 */
	Long createUser(User user) throws ServiceException;
	
	/**
	 * Read user
	 * This method read the user
	 * @param User entity
	 * @return User user
	 * @throws ServiceException the service exception
	 */
	User readUser(Long userId) throws ServiceException;
	
	/**
	 * Update the user
	 * This method update the user
	 * @param User entity
	 * @throws ServiceException the service exception
	 */
	void updateUser(User user) throws ServiceException;
	
	/**
	 * Delete user
	 * This method delete the user
	 * @param User entity
	 * @throws ServiceException the service exception
	 */
	void deleteUser(Long userId) throws ServiceException;
	
	/**
	 * Read all users that are exist
	 * This method read all users that are exist
	 * @return List<User> list of users
	 * @throws ServiceException the service exception
	 */
	List<User> getAllUsers() throws ServiceException;
	
	/**
	 * Associate current user with roles
	 * This method associate current user with roles   
	 * @param User entity
	 * @throws ServiceException the service exception
	 */
	void linkUserWithRoles(User user) throws ServiceException;
	
	/**
	 * Read all roles that have been associated with current user yet and that are exist
	 * This method read all roles that have been associated with current user yet and that are exist 
	 * @return List<Role> list of roles that associate with the user
	 * @param User entity
	 * @throws ServiceException the service exception
	 */
	List<Role> readExistRolesOfUser(Long userId) throws ServiceException;

	/**
	 * Disassociate roles with current user
	 * This method disassociate roles with current user
	 * @param User entity
	 * @throws ServiceException the service exception
	 */
	void unlinkRolesFromUser(User user) throws ServiceException;
	
	/**
	 * Associate current entity with some separate permissions
	 * This method associate entity with some separate permissions. For example associate Role entity with one or more permissions   
	 * @param User the user entity
	 * @throws ServiceException the service exception
	 */
	void linkUserWithSeparatePermissions (User user) throws ServiceException;
	
	/**
	 * Read all separate permissions that have been associated yet and that are exist.
	 * This method read all separate permissions that have been associated yet and that are exist
	 * @return List<Permission> list of permissions that associate with the group 
	 * @param entityId the entity id
	 * @throws ServiceException the service exception
	 */
	List<Permission> readExistSeparatePermissionsOfUser (Long userId) throws ServiceException;

	/**
	 * Disassociate entity this separate permissions
	 * This method disassociate entity with separate permissions
	 * @param User the user entity  
	 * @throws ServiceException the service exception
	 */
	void unlinkSeparatePermissionsFromUser (User user) throws ServiceException;
	
}
