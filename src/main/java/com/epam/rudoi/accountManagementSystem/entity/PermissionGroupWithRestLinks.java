package com.epam.rudoi.accountManagementSystem.entity;

import java.util.List;

public class PermissionGroupWithRestLinks {

private Long permissionGroupId;
	
	private String permissionGroupName;
	
	private String linkToGetPermissionsList;

	public Long getPermissionGroupId() {
		return permissionGroupId;
	}

	public void setPermissionGroupId(Long permissionGroupId) {
		this.permissionGroupId = permissionGroupId;
	}

	public String getPermissionGroupName() {
		return permissionGroupName;
	}

	public void setPermissionGroupName(String permissionGroupName) {
		this.permissionGroupName = permissionGroupName;
	}

	public String getLinkToGetPermissionsList() {
		return linkToGetPermissionsList;
	}

	public void setLinkToGetPermissionsList(String linkToGetPermissionsList) {
		this.linkToGetPermissionsList = linkToGetPermissionsList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linkToGetPermissionsList == null) ? 0 : linkToGetPermissionsList.hashCode());
		result = prime * result + ((permissionGroupId == null) ? 0 : permissionGroupId.hashCode());
		result = prime * result + ((permissionGroupName == null) ? 0 : permissionGroupName.hashCode());
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
		PermissionGroupWithRestLinks other = (PermissionGroupWithRestLinks) obj;
		if (linkToGetPermissionsList == null) {
			if (other.linkToGetPermissionsList != null)
				return false;
		} else if (!linkToGetPermissionsList.equals(other.linkToGetPermissionsList))
			return false;
		if (permissionGroupId == null) {
			if (other.permissionGroupId != null)
				return false;
		} else if (!permissionGroupId.equals(other.permissionGroupId))
			return false;
		if (permissionGroupName == null) {
			if (other.permissionGroupName != null)
				return false;
		} else if (!permissionGroupName.equals(other.permissionGroupName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PermissionGroupWithRestLinks [permissionGroupId=" + permissionGroupId + ", permissionGroupName="
				+ permissionGroupName + ", linkToGetPermissionsList=" + linkToGetPermissionsList + "]";
	}
	
}
