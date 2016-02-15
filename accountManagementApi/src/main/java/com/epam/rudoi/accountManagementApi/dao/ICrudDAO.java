package com.epam.rudoi.accountManagementApi.dao;

import com.epam.rudoi.accountManagementApi.exceptions.DAOException;

/**
 * The Interface ICrudDAO.
 *
 * @param <E> the element type
 */
public interface ICrudDAO<E> {

	/**
	 * Create the entity.
	 * This method create entity
	 * @param entity the entity
	 * @return TODO
	 * @return the long
	 * @throws DAOException the DAO exception
	 */
	Long create (E entity) throws DAOException;
	
	/**
	 * Read entity.
	 * This method read entity
	 * @param entityId the item id
	 * @return the e
	 * @throws DAOException the DAO exception
	 */
	E read (Long entityId) throws DAOException;
	
	/**
	 * Update the item.
	 * This method update entity
	 * @param entity the entity
	 * @return TODO
	 * @throws DAOException the DAO exception
	 */
	void update (E entity) throws DAOException;
	
	/**
	 * Delete entity.
	 * This method delete entity
	 * @param entityId the item id
	 * @throws DAOException the DAO exception
	 */
	void delete (Long entityId) throws DAOException;
	
}
