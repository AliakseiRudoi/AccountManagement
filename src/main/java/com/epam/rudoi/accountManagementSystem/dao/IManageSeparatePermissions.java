package com.epam.rudoi.accountManagementSystem.dao;

import java.util.List;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;

public interface IManageSeparatePermissions {

	/**
	 * Associate current entity with some separate permissions
	 * This method associate entity with some separate permissions. For example associate Role entity with one or more permissions   
	 * @param entityId the entity id 
	 * @param permissionsList the list of permissions
	 * @throws DAOException the DAO exception
	 */
	void linkWithSeparatePermissions (Long entityId, List<Permission> permissionsToLinking) throws DAOException;
	
	/**
	 * Read all separate permissions that have been associated yet and that are exist.
	 * This method read all separate permissions that have been associated yet and that are exist
	 * @return List<Permission> list of permissions that associate with the group 
	 * @param entityId the entity id
	 * @throws DAOException the DAO exception
	 */
	List<Permission> readExistSeparatePermissions (Long entityId) throws DAOException;

	/**
	 * Disassociate entity this separate permissions
	 * This method disassociate entity with separate permissions
	 * @param entityId the entity id 
	 * @param permissionsList the list of permissions
	 * @throws DAOException the DAO exception
	 */
	void unlinkWithSeparatePermissions (Long entityId, List<Permission> permissionsToUnlinking) throws DAOException;
	
}
