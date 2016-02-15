package com.epam.rudoi.accountManagementWeb.rest.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.rudoi.accountManagementApi.entity.Role;
import com.epam.rudoi.accountManagementApi.entity.User;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;
import com.epam.rudoi.accountManagementApi.service.IAccountManagerFacadeService;
import com.epam.rudoi.accountManagementWeb.rest.IUserRest;

@Component
@Path("/user")
public class UserRestImpl implements IUserRest{

	@Autowired
	private IAccountManagerFacadeService accManagerFacadeService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Long createUser(User user) throws ServiceException {
		return accManagerFacadeService.createUser(user);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User readUser(Long userId) throws ServiceException {
		return accManagerFacadeService.readUser(userId);
	}

	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User user) throws ServiceException {
		accManagerFacadeService.updateUser(user);
	}

	@DELETE
	@Path("/{id}") 
	public void deleteUser(Long userId) throws ServiceException {
		accManagerFacadeService.deleteUser(userId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() throws ServiceException {
		return accManagerFacadeService.getAllUsers();
	}

	@POST
	@Path("/{id}/roles/link")
	@Consumes(MediaType.APPLICATION_JSON)
	public void linkWithRoles(User user) throws ServiceException {
		accManagerFacadeService.linkUserWithRoles(user);
	}

	@POST
	@Path("/{id}/roles")
	public List<Role> readExistRoles(Long userId) throws ServiceException {
		return accManagerFacadeService.readExistRolesOfUser(userId);
	}

	@POST
	@Path("/{id}/roles/unlink")
	@Consumes(MediaType.APPLICATION_JSON)
	public void unlinkWithRoles(User user) throws ServiceException {
		accManagerFacadeService.unlinkRolesFromUser(user);
	}

}
