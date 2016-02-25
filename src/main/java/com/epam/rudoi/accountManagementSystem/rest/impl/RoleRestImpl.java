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
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;
import com.epam.rudoi.accountManagementSystem.service.IAccountManagerFacadeService;
import com.epam.rudoi.accountManagementSystem.rest.IRoleRest;

@Component
@Path("/role")
public class RoleRestImpl implements IRoleRest{

	@Autowired
	private IAccountManagerFacadeService accManagerFacadeService;
	
	@POST
	@RolesAllowed({"ROLE_ROLE_MANAGER"})
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Long createRole(Role role) throws ServiceException {
		return accManagerFacadeService.createRole(role);
	}

	@GET
	@RolesAllowed({"ROLE_ROLE_MANAGER"})
	@Secured("role-manager")
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Role readRole(@PathParam("id") Long roleId) throws ServiceException {
		return accManagerFacadeService.readRole(roleId);
	}

	@POST
	@RolesAllowed({"ROLE_ROLE_MANAGER"})
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateRole(Role role) throws ServiceException {
		accManagerFacadeService.updateRole(role);
	}

	@DELETE
	@RolesAllowed({"ROLE_ROLE_MANAGER"})
	@Path("/{id}") 
	public void deleteRole(@PathParam("id") Long roleId) throws ServiceException {
		accManagerFacadeService.deleteRole(roleId);
	}

	@GET
	@RolesAllowed({"ROLE_ROLE_MANAGER"})
	@Produces(MediaType.APPLICATION_JSON)
	public List<Role> getAllRoles() throws ServiceException {
		return accManagerFacadeService.getAllRoles();
	}

	@POST
	@RolesAllowed({"ROLE_ROLE_MANAGER"})
	@Path("/{id}/permissiongroups/link")
	@Consumes(MediaType.APPLICATION_JSON)
	public void linkWithPermissionGroups(Role role) throws ServiceException {
		accManagerFacadeService.linkRoleWithPermissionGroups(role);
	}

	@GET
	@RolesAllowed({"ROLE_ROLE_MANAGER"})
	@Path("/{id}/permissiongroups")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PermissionGroup> readExistPermissiongroups(@PathParam("id") Long roleId) throws ServiceException {
		return accManagerFacadeService.readExistPermissiongroupsOfRole(roleId);
	}

	@POST
	@RolesAllowed({"ROLE_ROLE_MANAGER"})
	@Path("/{id}/permissiongroups/unlink")
	@Consumes(MediaType.APPLICATION_JSON)
	public void unlinkWithPermissionGroups(Role role) throws ServiceException {
		accManagerFacadeService.unlinkPermissionGroupsFromRole(role);
	}

}
