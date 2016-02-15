package com.epam.rudoi.accountManagementApi.dao;

import java.util.List;

import com.epam.rudoi.accountManagementApi.entity.Role;
import com.epam.rudoi.accountManagementApi.entity.User;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;

public interface IUserDAO extends ICrudDAO<User>, IManageDAO<Role>{

	/**
	 * Read all users that are exist.
	 * This method Read all users that are exist.
	 * @return List<User> list of users  
	 * @throws DAOException the DAO exception
	 */
	List<User> getAllUsers() throws DAOException;
	
}
