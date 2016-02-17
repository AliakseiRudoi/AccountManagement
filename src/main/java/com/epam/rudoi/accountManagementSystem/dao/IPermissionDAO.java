package com.epam.rudoi.accountManagementSystem.dao;

import java.util.List;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;

/**
 * The Interface IPermissionDAO.
 */
public interface IPermissionDAO extends ICrudDAO<Permission>{

	/**
	 * Read all permissions that are exist.
	 * This method Read all permissions that are exist.
	 * @return List<Permission> list of permissions  
	 * @throws DAOException the DAO exception
	 */
	List<Permission> getAllPermissions() throws DAOException;
	
}
