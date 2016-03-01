package com.epam.rudoi.accountManagementSystem.rest;

import com.epam.rudoi.accountManagementSystem.entity.Content;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;

public interface IContentRest {

	/**
	 * Create content
	 * This method create the content
	 * @param entity the entity
	 * @return the long content id
	 * @throws ServiceException the service exception
	 */
	Long createContent (Content content) throws ServiceException;
	
	/**
	 * Read content
	 * This method read content
	 * @param contentId the item id
	 * @return the Content 
	 * @throws ServiceException the DAO exception
	 */
	Content readContent (Long contentId) throws ServiceException;
	
	/**
	 * Update the content.
	 * This method update content
	 * @param entity the content
	 * @throws ServiceException the DAO exception
	 */
	void updateContent (Content content) throws ServiceException;
	
	/**
	 * Delete content.
	 * This method delete content
	 * @param contentId the item id
	 * @throws ServiceException the DAO exception
	 */
	void deleteContent (Long contentId) throws ServiceException;	
	
}
