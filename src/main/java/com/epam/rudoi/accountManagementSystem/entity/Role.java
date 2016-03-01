package com.epam.rudoi.accountManagementSystem.entity;

import java.util.List;

public class Role {

	private Long roleId;
	
	private String roleName;
	
	private List<PermissionGroup> permissionGroupList;

	public Role() {
		super();
	}
	
	public Role(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Role(Long roleId, String roleName, List<PermissionGroup> permissionGroupList) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.permissionGroupList = permissionGroupList;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<PermissionGroup> getPermissionGroupList() {
		return permissionGroupList;
	}

	public void setPermissionGroupList(List<PermissionGroup> permissionGroupList) {
		this.permissionGroupList = permissionGroupList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permissionGroupList == null) ? 0 : permissionGroupList.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (permissionGroupList == null) {
			if (other.permissionGroupList != null)
				return false;
		} else if (!permissionGroupList.equals(other.permissionGroupList))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", permissionGroupList=" + permissionGroupList
				+ "]";
	}

}
