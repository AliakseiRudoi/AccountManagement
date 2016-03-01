package com.epam.rudoi.accountManagementSystem.dao;

import java.util.List;

import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;
import com.epam.rudoi.accountManagementSystem.entity.UserWithRestLinks;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;

public interface IUserDAO extends ICrudDAO<User>, IManageDAO<Role>, IManageSeparatePermissions{

	/**
	 * Read all users that are exist.
	 * This method Read all users that are exist.
	 * @return List<User> list of users  
	 * @throws DAOException the DAO exception
	 */
	List<UserWithRestLinks> getAllUsers() throws DAOException;
	
}
