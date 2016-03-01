package com.epam.rudoi.accountManagementSystem.rest;

import java.util.List;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;
import com.epam.rudoi.accountManagementSystem.entity.UserWithRestLinks;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;

public interface IUserRest {

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
	List<UserWithRestLinks> getAllUsers() throws ServiceException;
	
	/**
	 * Associate current user with roles
	 * This method associate current user with roles   
	 * @param User the user entity 
	 * @throws ServiceException the service exception
	 */
	void linkWithRoles(User user) throws ServiceException;
	
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
	 * @param User the user entity
	 * @throws ServiceException the service exception
	 */
	void unlinkWithRoles(User user) throws ServiceException;
	
	/**
	 * Associate current user with separate permissions
	 * This method associate current user with separate permissions   
	 * @param User the user entity
	 * @throws ServiceException the service exception
	 */
	void linkWithSeparatePermissions(User user) throws ServiceException;
	
	/**
	 * Read all separate permissions that have been associated with current user yet and that are exist
	 * This method read all separate permissions that have been associated with current user yet and that are exist 
	 * @return List<Permission> list of roles that associate with the user
	 * @param userId the user id
	 * @throws ServiceException the service exception
	 */
	List<Permission> readExistSeparatePermissions(Long userId) throws ServiceException;

	/**
	 * Disassociate separate permissions with current user
	 * This method disassociate separate permissions with current user
	 * @param User the user entity
	 * @throws ServiceException the service exception
	 */
	void unlinkWithSeparatePermissions(User user) throws ServiceException;
	
}
