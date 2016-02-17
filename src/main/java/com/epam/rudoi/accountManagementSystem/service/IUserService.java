package com.epam.rudoi.accountManagementSystem.service;

import java.util.List;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;

public interface IUserService {

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
	 * @param userId the user id
	 * @return User
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
	 * @param userId the user id
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
	 * @param userId the user id 
	 * @param rolesList the list of roles
	 * @throws ServiceException the service exception
	 */
	void linkWithRoles(Long userId, List<Role> rolesToLinking) throws ServiceException;
	
	/**
	 * Read all roles that have been associated with current user yet and that are exist
	 * This method read all roles that have been associated with current user yet and that are exist 
	 * @return List<Role> list of roles that associate with the user
	 * @param userId the user id
	 * @throws ServiceException the service exception
	 */
	List<Role> readExistRoles(Long userId) throws ServiceException;

	/**
	 * Disassociate roles with current user
	 * This method disassociate roles with current user
	 * @param userId the user id
	 * @param rolesList the list of roles
	 * @throws ServiceException the service exception
	 */
	void unlinkWithRoles(Long userId, List<Role> rolesToUnlinking) throws ServiceException;
	
	/**
	 * Associate current user with some separate permissions
	 * This method associate user with some separate permissions. For example associate Role entity with one or more permissions   
	 * @param entityId the entity id 
	 * @param permissionsList the list of permissions
	 * @throws ServiceException the service exception
	 */
	void linkWithSeparatePermissions (Long userId, List<Permission> permissionsToLinking) throws ServiceException;
	
	/**
	 * Read all separate permissions that have been associated yet and that are exist.
	 * This method read all separate permissions that have been associated yet and that are exist
	 * @return List<Permission> list of permissions that associate with the group 
	 * @param entityId the entity id
	 * @throws ServiceException the service exception
	 */
	List<Permission> readExistSeparatePermissions (Long userId) throws ServiceException;

	/**
	 * Disassociate user this separate permissions
	 * This method disassociate user with separate permissions
	 * @param entityId the entity id 
	 * @param permissionsList the list of permissions
	 * @throws ServiceException the service exception
	 */
	void unlinkWithSeparatePermissions (Long userId, List<Permission> permissionsToUnlinking) throws ServiceException;
}
