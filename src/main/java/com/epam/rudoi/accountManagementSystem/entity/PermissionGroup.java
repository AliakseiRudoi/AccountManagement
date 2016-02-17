package com.epam.rudoi.accountManagementSystem.entity;

import java.util.List;

public class PermissionGroup {

	private Long permissionGroupId;
	
	private String permissionGroupName;
	
	private List<Permission> permissionsList;

	public PermissionGroup() {
		super();
	}
	
	public PermissionGroup(Long permissionGroupId, String permissionGroupName) {
		super();
		this.permissionGroupId = permissionGroupId;
		this.permissionGroupName = permissionGroupName;
	}
	
	public PermissionGroup(Long permissionGroupId, String permissionGroupName, List<Permission> permissionsList) {
		super();
		this.permissionGroupId = permissionGroupId;
		this.permissionGroupName = permissionGroupName;
		this.permissionsList = permissionsList;
	}

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

	public List<Permission> getPermissionsList() {
		return permissionsList;
	}

	public void setPermissionsList(List<Permission> permissionsList) {
		this.permissionsList = permissionsList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permissionGroupId == null) ? 0 : permissionGroupId.hashCode());
		result = prime * result + ((permissionGroupName == null) ? 0 : permissionGroupName.hashCode());
		result = prime * result + ((permissionsList == null) ? 0 : permissionsList.hashCode());
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
		PermissionGroup other = (PermissionGroup) obj;
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
		if (permissionsList == null) {
			if (other.permissionsList != null)
				return false;
		} else if (!permissionsList.equals(other.permissionsList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PermissionGroup [permissionGroupId=" + permissionGroupId + ", permissionGroupName="
				+ permissionGroupName + ", permissionsList=" + permissionsList + "]";
	}

}
