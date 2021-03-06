package com.epam.rudoi.accountManagementSystem.rest.impl;

import java.util.List;

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

import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.annotation.security.RolesAllowed;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;
import com.epam.rudoi.accountManagementSystem.entity.UserWithRestLinks;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;
import com.epam.rudoi.accountManagementSystem.service.IAccountManagerFacadeService;
import com.epam.rudoi.accountManagementSystem.rest.IUserRest;

@Component
@Path("/user")
public class UserRestImpl implements IUserRest{

	@Autowired
	private IAccountManagerFacadeService accManagerFacadeService;
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String test5(@Context SecurityContext sc) throws ServiceException {
		return sc.getUserPrincipal().toString();
	}
	
	@POST
	@RolesAllowed({"create-user"})
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Long createUser(User user) throws ServiceException {
		return accManagerFacadeService.createUser(user);
	}

	@GET
	@RolesAllowed({"read-user"})
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User readUser(@PathParam("id") Long userId) throws ServiceException {
		return accManagerFacadeService.readUser(userId);
	}

	@POST
	@RolesAllowed({"update-user"})
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User user) throws ServiceException {
		accManagerFacadeService.updateUser(user);
	}

	@DELETE
	@RolesAllowed({"delete-user"})
	@Path("/{id}") 
	public void deleteUser(@PathParam("id") Long userId) throws ServiceException {
		accManagerFacadeService.deleteUser(userId);
	}
	
	@GET
	@RolesAllowed({"read-all-users"})
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserWithRestLinks> getAllUsers() throws ServiceException {
		return accManagerFacadeService.getAllUsers();
	}

	@POST
	@RolesAllowed({"link-user-with-roles"})
	@Path("/{id}/roles/link")
	@Consumes(MediaType.APPLICATION_JSON)
	public void linkWithRoles(User user) throws ServiceException {
		accManagerFacadeService.linkUserWithRoles(user);
	}

	@GET
	@RolesAllowed({"read-exist-roles-of-user"})
	@Path("/{id}/roles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Role> readExistRoles(@PathParam("id") Long userId) throws ServiceException {
		return accManagerFacadeService.readExistRolesOfUser(userId);
	}

	@POST
	@RolesAllowed({"unlink-user-with-roles"})
	@Path("/{id}/roles/unlink")
	@Consumes(MediaType.APPLICATION_JSON)
	public void unlinkWithRoles(User user) throws ServiceException {
		accManagerFacadeService.unlinkRolesFromUser(user);
	}

	@POST
	@RolesAllowed({"link-user-with-separate-permissions"})
	@Path("/{id}/separatepermissions/link")
	@Consumes(MediaType.APPLICATION_JSON)
	public void linkWithSeparatePermissions(User user) throws ServiceException {
		accManagerFacadeService.linkUserWithSeparatePermissions(user);
	}

	@GET
	@RolesAllowed({"read-exist-separate-permissions-of-user"})
	@Path("/{id}/separatepermissions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Permission> readExistSeparatePermissions(@PathParam("id") Long userId) throws ServiceException {
		return accManagerFacadeService.readExistSeparatePermissionsOfUser(userId);
	}

	@POST
	@RolesAllowed({"unlink-user-with-separate-permissions"})
	@Path("/{id}/separatepermissions/unlink")
	@Consumes(MediaType.APPLICATION_JSON)
	public void unlinkWithSeparatePermissions(User user) throws ServiceException {
		accManagerFacadeService.unlinkSeparatePermissionsFromUser(user);
	}

}
