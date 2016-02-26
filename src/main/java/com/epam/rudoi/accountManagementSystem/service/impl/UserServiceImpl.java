package com.epam.rudoi.accountManagementSystem.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.rudoi.accountManagementSystem.dao.IUserDAO;
import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;
import com.epam.rudoi.accountManagementSystem.service.IUserService;

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

	@Override
	public void linkWithSeparatePermissions(Long userId, List<Permission> permissionsToLinking) throws ServiceException {
		try {
			userDAO.linkWithSeparatePermissions(userId, permissionsToLinking);
		} catch (DAOException e) {
			LOGGER.error("Linking separate permissions with user "+userId+" exeption", e);
		    throw new ServiceException(e);
		}
	}

	@Override
	public List<Permission> readExistSeparatePermissions(Long userId) throws ServiceException {
		List<Permission> permissions = null;
		try {
			permissions = userDAO.readExistSeparatePermissions(userId);
		} catch (DAOException e) {
			LOGGER.error("Reading exist separate permissions for user "+ userId +" exeption", e);
		    throw new ServiceException(e);
		}
		return permissions;
	}

	@Override
	public void unlinkWithSeparatePermissions(Long userId, List<Permission> permissionsToUnlinking)
			throws ServiceException {
		try {
			userDAO.unlinkWithSeparatePermissions(userId, permissionsToUnlinking);
		} catch (DAOException e) {
			LOGGER.error("Unlinking separate permissions with user "+ userId +" exeption", e);
		    throw new ServiceException(e);
		}
	}

}
