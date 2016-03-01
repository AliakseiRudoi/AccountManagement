package com.epam.rudoi.accountManagementSystem.entity;

import java.util.List;

public class RoleWithRestLinks {

private Long roleId;
	
	private String roleName;
	
	private String linkToGetPermissionGroupList;

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

	public String getLinkToGetPermissionGroupList() {
		return linkToGetPermissionGroupList;
	}

	public void setLinkToGetPermissionGroupList(String linkToGetPermissionGroupList) {
		this.linkToGetPermissionGroupList = linkToGetPermissionGroupList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((linkToGetPermissionGroupList == null) ? 0 : linkToGetPermissionGroupList.hashCode());
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
		RoleWithRestLinks other = (RoleWithRestLinks) obj;
		if (linkToGetPermissionGroupList == null) {
			if (other.linkToGetPermissionGroupList != null)
				return false;
		} else if (!linkToGetPermissionGroupList.equals(other.linkToGetPermissionGroupList))
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
		return "RoleWithRestLinks [roleId=" + roleId + ", roleName=" + roleName + ", linkToGetPermissionGroupList="
				+ linkToGetPermissionGroupList + "]";
	}
	
}
