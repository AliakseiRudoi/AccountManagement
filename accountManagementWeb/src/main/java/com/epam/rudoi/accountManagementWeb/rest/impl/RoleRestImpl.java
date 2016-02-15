package com.epam.rudoi.accountManagementWeb.rest.impl;

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

import com.epam.rudoi.accountManagementApi.entity.PermissionGroup;
import com.epam.rudoi.accountManagementApi.entity.Role;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;
import com.epam.rudoi.accountManagementApi.service.IAccountManagerFacadeService;
import com.epam.rudoi.accountManagementWeb.rest.IRoleRest;

@Component
@Path("/role")
public class RoleRestImpl implements IRoleRest{

	@Autowired
	private IAccountManagerFacadeService accManagerFacadeService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Long createRole(Role role) throws ServiceException {
		return accManagerFacadeService.createRole(role);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Role readRole(Long roleId) throws ServiceException {
		return accManagerFacadeService.readRole(roleId);
	}

	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateRole(Role role) throws ServiceException {
		accManagerFacadeService.updateRole(role);
	}

	@DELETE
	@Path("/{id}") 
	public void deleteRole(@PathParam("id") Long roleId) throws ServiceException {
		accManagerFacadeService.deleteRole(roleId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Role> getAllRoles() throws ServiceException {
		return accManagerFacadeService.getAllRoles();
	}

	@POST
	@Path("/{id}/permissiongroups/link")
	@Consumes(MediaType.APPLICATION_JSON)
	public void linkWithPermissionGroups(Role role) throws ServiceException {
		accManagerFacadeService.linkRoleWithPermissionGroups(role);
	}

	@GET
	@Path("/{id}/permissiongroups")
	public List<PermissionGroup> readExistPermissiongroups(Long roleId) throws ServiceException {
		return accManagerFacadeService.readExistPermissiongroupsOfRole(roleId);
	}

	@POST
	@Path("/{id}/permissiongroups/unlink")
	@Consumes(MediaType.APPLICATION_JSON)
	public void unlinkWithPermissionGroups(Role role) throws ServiceException {
		accManagerFacadeService.unlinkPermissionGroupsFromRole(role);
	}

}
