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
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;
import com.epam.rudoi.accountManagementSystem.service.IAccountManagerFacadeService;
import com.epam.rudoi.accountManagementSystem.rest.IPermissionGroupRest;

@Component
@Path("/permissiongroup")
public class PermissionGroupRestImpl implements IPermissionGroupRest{

	@Autowired
	private IAccountManagerFacadeService accManagerFacadeService;
	
	@POST
	@RolesAllowed({"create-permission-group"})
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Long createPermissionGroup(PermissionGroup permissionGroup) throws ServiceException {
		return accManagerFacadeService.createPermissionGroup(permissionGroup);
	}

	@GET
	@RolesAllowed({"read-permission-group"})
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PermissionGroup readPermissionGroup(@PathParam("id") Long permissionGroupId) throws ServiceException {
		return accManagerFacadeService.readPermissionGroup(permissionGroupId);
	}

	@POST
	@RolesAllowed({"update-permission-group"})
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePermissionGroup(PermissionGroup permissionGroup) throws ServiceException {
		accManagerFacadeService.updatePermissionGroup(permissionGroup);
	}

	@DELETE
	@RolesAllowed({"delete-permission-group"})
	@Path("/{id}") 
	public void deletePermissionGroup(@PathParam("id") Long permissionGroupId) throws ServiceException {
		accManagerFacadeService.deletePermissionGroup(permissionGroupId);
	}

	@GET
	@RolesAllowed({"read-all-permission-groups"})
	@Produces(MediaType.APPLICATION_JSON)
	public List<PermissionGroup> getAllPermissionGroups() throws ServiceException {
		return accManagerFacadeService.getAllPermissionGroups();
	}

	@POST
	@RolesAllowed({"link-permission-group-with-permissions"})
	@Path("/{id}/permissions/link")
	@Consumes(MediaType.APPLICATION_JSON)
	public void linkWithPermissions(PermissionGroup permissionGroup)
			throws ServiceException {
		accManagerFacadeService.linkPermissionGroupWithPermissions(permissionGroup);
	}

	@GET
	@RolesAllowed({"read-exist-permissions-of-permission-group"})
	@Path("/{id}/permissions")
	public List<Permission> readExistPermissions(@PathParam("id") Long permissionGroupId) throws ServiceException {
		return accManagerFacadeService.readExistPermissionsOfPermissionGroup(permissionGroupId);
	}

	@DELETE
	@RolesAllowed({"unlink-permission-group-with-permissions"})
	@Path("/{id}/permissions/unlink")
	@Consumes(MediaType.APPLICATION_JSON)
	public void unlinkWithPermissions(PermissionGroup permissionGroup)
			throws ServiceException {
		accManagerFacadeService.unlinkPermissionGroupFromPermissions(permissionGroup);
	}

}
