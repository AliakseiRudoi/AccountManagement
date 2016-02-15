package com.epam.rudoi.accountManagementApi.dao;

import java.util.List;

import com.epam.rudoi.accountManagementApi.exceptions.DAOException;

public interface IManageDAO<E> {

	
	/**
	 * Associate current entity with some items group.
	 * This method associate entity with some items group. For example associate Role entity with one or more permission group (permissionGroupsList)   
	 * @param permissionGroupId the permission group id 
	 * @param permissionsList the list of permissions
	 * @throws DAOException the DAO exception
	 */
	void linkWithItems (Long entityId, List<E> itemsToLinking) throws DAOException;
	
	/**
	 * Read all items that have been associated yet and that are exist. 
	 * This method read all items that have been associated yet and that are exist. 
	 * @return List<Permission> list of permissions that associate with the group 
	 * @param permissionGroupId the permission group id
	 * @throws DAOException the DAO exception
	 */
	List<E> readExistItems (Long entityId) throws DAOException;

	/**
	 * Disassociate entity this items group
	 * This method disassociate entity this items group.
	 * @param permissionGroup the permission group entity
	 * @throws DAOException the DAO exception
	 */
	void unlinkWithItems (Long entityId, List<E> itemsToUnlinking) throws DAOException;
	
	
	
}
