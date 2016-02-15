package com.epam.rudoi.accountManagementApi.dao;

import java.util.List;

import com.epam.rudoi.accountManagementApi.entity.PermissionGroup;
import com.epam.rudoi.accountManagementApi.entity.Role;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;

/**
 * The Interface IRoleDAO.
 */
public interface IRoleDAO extends ICrudDAO<Role>, IManageDAO<PermissionGroup>{
	/**
	 * Get list of all roles.
	 * This method get list of all roles.
	 * @return the roles list
	 * @throws DAOException the DAO exception
	 */
	List<Role> getAllRoles () throws DAOException;
	
}
