package com.epam.rudoi.accountManagementSystem.dao;

import java.util.List;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroupWithRestLinks;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;

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
	List<PermissionGroupWithRestLinks> getAllPermissionGroups () throws DAOException;
	
}
