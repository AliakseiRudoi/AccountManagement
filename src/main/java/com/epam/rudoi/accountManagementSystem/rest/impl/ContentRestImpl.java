package com.epam.rudoi.accountManagementSystem.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.rudoi.accountManagementSystem.entity.Content;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;
import com.epam.rudoi.accountManagementSystem.service.IAccountManagerFacadeService;
import com.epam.rudoi.accountManagementSystem.rest.IContentRest;

@Component
@Path("/content")
public class ContentRestImpl implements IContentRest{

	@Autowired
	private IAccountManagerFacadeService accManagerFacadeService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Long createContent(Content content) throws ServiceException {
		return accManagerFacadeService.createContent(content);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Content readContent(@PathParam("id") Long contentId) throws ServiceException {
		return accManagerFacadeService.readContent(contentId);
	}

	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateContent(Content content) throws ServiceException {
		accManagerFacadeService.updateContent(content);
	}

	@DELETE
	@Path("/{id}") 
	public void deleteContent(@PathParam("id") Long contentId) throws ServiceException {
		accManagerFacadeService.deleteContent(contentId);
	}

}
