package com.epam.rudoi.accountManagementApi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.rudoi.accountManagementApi.entity.Content;
import com.epam.rudoi.accountManagementApi.entity.Permission;
import com.epam.rudoi.accountManagementApi.entity.PermissionGroup;
import com.epam.rudoi.accountManagementApi.entity.Role;
import com.epam.rudoi.accountManagementApi.entity.User;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;
import com.epam.rudoi.accountManagementApi.service.IAccountManagerFacadeService;
import com.epam.rudoi.accountManagementApi.service.IContentService;
import com.epam.rudoi.accountManagementApi.service.IPermissionGroupService;
import com.epam.rudoi.accountManagementApi.service.IPermissionService;
import com.epam.rudoi.accountManagementApi.service.IRoleService;
import com.epam.rudoi.accountManagementApi.service.IUserService;

public class AccountManagerFacadeServiceImpl implements IAccountManagerFacadeService{

	@Autowired
	IContentService contentService;
	@Autowired
	IPermissionService permissionService;
	@Autowired
	IPermissionGroupService permissionGroupService;
	@Autowired
	IRoleService roleService;
	@Autowired
	IUserService userService;
	
	/* CONTENT */
	
	public Long createContent(Content content) throws ServiceException {
		return contentService.createContent(content);
	}
	public Content readContent(Long contentId) throws ServiceException {
		return contentService.readContent(contentId);
	}
	public void updateContent(Content content) throws ServiceException {
		contentService.updateContent(content);
	}
	public void deleteContent(Long contentId) throws ServiceException {
		contentService.deleteContent(contentId);
	}
	
	/* PERMISSION */
	
	public Long createPermission(Permission permission) throws ServiceException {
		return permissionService.createPermission(permission);
	}
	public Permission readPermission(Long permissionId) throws ServiceException {
		return permissionService.readPermission(permissionId);
	}
	public void updatePermission(Permission permission) throws ServiceException {
		permissionService.updatePermission(permission);
	}
	public void deletePermission(Long permissionId) throws ServiceException {
		permissionService.deletePermission(permissionId);
	}
	public List<Permission> getAllPermissions() throws ServiceException {
		return permissionService.getAllPermissions();
	}
	
	/* PERMISSION GROUP */
	
	public Long createPermissionGroup(PermissionGroup permissionGroup) throws ServiceException {
		return permissionGroupService.createPermissionGroup(permissionGroup);
	}
	public PermissionGroup readPermissionGroup(Long permissionGroupId) throws ServiceException {
		return permissionGroupService.readPermissionGroup(permissionGroupId);
	}
	public void updatePermissionGroup(PermissionGroup permissionGroup) throws ServiceException {
		permissionGroupService.updatePermissionGroup(permissionGroup);
	}
	public void deletePermissionGroup(Long permissionGroupId) throws ServiceException {
		permissionGroupService.deletePermissionGroup(permissionGroupId);
	}
	public List<PermissionGroup> getAllPermissionGroups() throws ServiceException {
		return permissionGroupService.getAllPermissionGroups();
	}
	public void linkPermissionGroupWithPermissions(PermissionGroup permissionGroup) throws ServiceException {
		permissionGroupService.linkWithPermissions(permissionGroup.getPermissionGroupId(), permissionGroup.getPermissionsList());
	}
	public List<Permission> readExistPermissionsOfPermissionGroup(Long permissionGroupId) throws ServiceException {
		return permissionGroupService.readExistPermissions(permissionGroupId);
	}
	public void unlinkPermissionGroupFromPermissions(PermissionGroup permissionGroup) throws ServiceException {
		permissionGroupService.unlinkWithPermissions(permissionGroup.getPermissionGroupId(), permissionGroup.getPermissionsList());
	}
	
	/* ROLE */
	
	public Long createRole(Role role) throws ServiceException {
		return roleService.createRole(role);
	}
	public Role readRole(Long roleId) throws ServiceException {
		return roleService.readRole(roleId);
	}
	public void updateRole(Role role) throws ServiceException {
		roleService.updateRole(role);
	}
	public void deleteRole(Long roleId) throws ServiceException {
		roleService.deleteRole(roleId);
	}
	public List<Role> getAllRoles() throws ServiceException {
		return roleService.getAllRoles();
	}
	public void linkRoleWithPermissionGroups(Role role) throws ServiceException {
		roleService.linkWithPermissionGroups(role.getRoleId(), role.getPermissionGroupList());
	}
	public List<PermissionGroup> readExistPermissiongroupsOfRole(Long roleId) throws ServiceException {
		return roleService.readExistPermissiongroups(roleId);
	}
	public void unlinkPermissionGroupsFromRole(Role role) throws ServiceException {
		roleService.unlinkWithPermissionGroups(role.getRoleId(), role.getPermissionGroupList());
	}
	
	/* USER */
	
	public Long createUser(User user) throws ServiceException {
		return userService.createUser(user);
	}
	public User readUser(Long userId) throws ServiceException {
		return userService.readUser(userId);
	}
	public void updateUser(User user) throws ServiceException {
		userService.updateUser(user);
	}
	public void deleteUser(Long userId) throws ServiceException {
		userService.deleteUser(userId);
	}
	public List<User> getAllUsers() throws ServiceException {
		return userService.getAllUsers();
	}
	public void linkUserWithRoles(User user) throws ServiceException {
		userService.linkWithRoles(user.getUserId(), user.getRolesList());
	}
	public List<Role> readExistRolesOfUser(Long userId) throws ServiceException {
		return userService.readExistRoles(userId);
	}
	public void unlinkRolesFromUser(User user) throws ServiceException {
		userService.unlinkWithRoles(user.getUserId(), user.getRolesList());
	}

}
