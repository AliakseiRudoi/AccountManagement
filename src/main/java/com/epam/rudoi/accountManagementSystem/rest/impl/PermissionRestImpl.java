package com.epam.rudoi.accountManagementSystem.rest.impl;

import java.util.List;

import javax.annotation.security.RolesAllowed;
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

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;
import com.epam.rudoi.accountManagementSystem.service.IAccountManagerFacadeService;
import com.epam.rudoi.accountManagementSystem.rest.IPermissionRest;

@Component
@Path("/permission")
public class PermissionRestImpl implements IPermissionRest{
	
	@Autowired
	private IAccountManagerFacadeService accManagerFacadeService;

	@POST
	@RolesAllowed({"permission-create-permission"})
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Long createPermission(Permission permission) throws ServiceException {
		return accManagerFacadeService.createPermission(permission);
	}

	@GET
	@RolesAllowed({"permission-read-permission"})
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Permission readPermission(@PathParam("id") Long permissionId) throws ServiceException {
		return accManagerFacadeService.readPermission(permissionId);
	}

	@POST
	@RolesAllowed({"permission-update-permission"})
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePermission(Permission permission) throws ServiceException {
		accManagerFacadeService.updatePermission(permission);
	}

	@DELETE
	@RolesAllowed({"permission-delete-permission"})
	@Path("/{id}") 
	public void deletePermission(@PathParam("id") Long permissionId) throws ServiceException {
		accManagerFacadeService.deletePermission(permissionId);
	}

	@GET
	@RolesAllowed({"permission-read-all-permissions"})
	@Produces(MediaType.APPLICATION_JSON)
	public List<Permission> getAllPermissions() throws ServiceException {
		return accManagerFacadeService.getAllPermissions();
	}

}
