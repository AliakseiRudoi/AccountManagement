package com.epam.rudoi.accountManagementApi.dao;

import java.util.List;

import com.epam.rudoi.accountManagementApi.entity.Permission;
import com.epam.rudoi.accountManagementApi.entity.PermissionGroup;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;

/**
 * The Interface IPermissionGroupDAO.
 */
public interface IPermissionGroupDAO extends ICrudDAO<PermissionGroup>, IManageDAO<Permission>{

	/**
	 * Get list of all permission groups.
	 * This method get list of all permission groups.
	 * @return the permission groups list
	 * @throws DAOException the DAO exception
	 */
	List<PermissionGroup> getAllPermissionGroups () throws DAOException;
	
}
