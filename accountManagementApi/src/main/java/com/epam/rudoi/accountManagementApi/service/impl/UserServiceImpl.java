package com.epam.rudoi.accountManagementApi.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.rudoi.accountManagementApi.dao.IUserDAO;
import com.epam.rudoi.accountManagementApi.entity.Role;
import com.epam.rudoi.accountManagementApi.entity.User;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;
import com.epam.rudoi.accountManagementApi.service.IUserService;

public class UserServiceImpl implements IUserService{

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private IUserDAO userDAO;
	
	public Long createUser(User user) throws ServiceException {
		Long userId = null;
		try {
			userId = userDAO.create(user);
		} catch (DAOException e) {
			LOGGER.error("Create user exeption", e);
		    throw new ServiceException(e);
		}
		return userId;
	}

	public User readUser(Long userId) throws ServiceException {
		User user = null;
		try {
			user = userDAO.read(userId);
		} catch (DAOException e) {
			LOGGER.error("Read user exeption", e);
		    throw new ServiceException(e);
		}
		return user;
	}

	public void updateUser(User user) throws ServiceException {
		try {
			userDAO.update(user);
		} catch (DAOException e) {
			LOGGER.error("Update user exeption", e);
		    throw new ServiceException(e);
		}
	}

	public void deleteUser(Long userId) throws ServiceException {
		try {
			userDAO.delete(userId);
		} catch (DAOException e) {
			LOGGER.error("Delete user exeption", e);
		    throw new ServiceException(e);
		}
	}

	public List<User> getAllUsers() throws ServiceException {
		List<User> users = null;
		try {
			users = userDAO.getAllUsers();
		} catch (DAOException e) {
			LOGGER.error("Get all users exeption", e);
		    throw new ServiceException(e);
		}
		return users;
	}

	public void linkWithRoles(Long userId, List<Role> rolesToLinking) throws ServiceException {
		try {
			userDAO.linkWithItems(userId, rolesToLinking);
		} catch (DAOException e) {
			LOGGER.error("Linking roles with user "+userId+" exeption", e);
		    throw new ServiceException(e);
		}
		
	}

	public List<Role> readExistRoles(Long userId) throws ServiceException {
		List<Role> roles = null;
		try {
			roles = userDAO.readExistItems(userId);
		} catch (DAOException e) {
			LOGGER.error("Reading exist roles for user "+ userId +" exeption", e);
		    throw new ServiceException(e);
		}
		return roles;
	}

	public void unlinkWithRoles(Long userId, List<Role> rolesToUnlinking) throws ServiceException {
		try {
			userDAO.unlinkWithItems(userId, rolesToUnlinking);
		} catch (DAOException e) {
			LOGGER.error("Unlinking roles with user "+ userId +" exeption", e);
		    throw new ServiceException(e);
		}
	}

}
