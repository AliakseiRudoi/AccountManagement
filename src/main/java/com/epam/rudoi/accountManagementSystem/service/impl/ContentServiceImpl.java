package com.epam.rudoi.accountManagementSystem.service.impl;

import com.epam.rudoi.accountManagementSystem.dao.IContentDAO;
import com.epam.rudoi.accountManagementSystem.entity.Content;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;
import com.epam.rudoi.accountManagementSystem.service.IContentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class ContentServiceImpl implements IContentService{

	private static final Logger LOGGER = Logger.getLogger(ContentServiceImpl.class);
	
	@Autowired
	private IContentDAO contentDAO; 
	
	public Long createContent(Content content) throws ServiceException {

		Long contentId = null;
		
		try {
			contentId = contentDAO.create(content);
		} catch (DAOException e) {
			LOGGER.error("Create content exeption", e);
		    throw new ServiceException(e);
		}
		
		return contentId;
	}

	public Content readContent(Long contentId) throws ServiceException {
		Content content = null;
		
		try {
			content = contentDAO.read(contentId);
		} catch (DAOException e) {
			LOGGER.error("Read content exeption", e);
		    throw new ServiceException(e);
		}
		
		return content;
	}

	public void updateContent(Content content) throws ServiceException {
		
		try {
			contentDAO.update(content);
		} catch (DAOException e) {
			LOGGER.error("Update content exeption", e);
		    throw new ServiceException(e);
		}
		
	}

	public void deleteContent(Long contentId) throws ServiceException {
		
		try {
			contentDAO.delete(contentId);
		} catch (DAOException e) {
			LOGGER.error("Delete content exeption", e);
		    throw new ServiceException(e);
		}
		
	}

}
