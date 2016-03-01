package com.epam.rudoi.accountManagementSystem.entity;

import java.util.List;

public class UserWithRestLinks {

	private Long userId;
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String userEmail;
	
	private String linkToGetRoleList;

	private String linkToGetSeparatePermissionsList;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getLinkToGetRoleList() {
		return linkToGetRoleList;
	}

	public void setLinkToGetRoleList(String linkToGetRoleList) {
		this.linkToGetRoleList = linkToGetRoleList;
	}

	public String getLinkToGetSeparatePermissionsList() {
		return linkToGetSeparatePermissionsList;
	}

	public void setLinkToGetSeparatePermissionsList(String linkToGetSeparatePermissionsList) {
		this.linkToGetSeparatePermissionsList = linkToGetSeparatePermissionsList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((linkToGetRoleList == null) ? 0 : linkToGetRoleList.hashCode());
		result = prime * result
				+ ((linkToGetSeparatePermissionsList == null) ? 0 : linkToGetSeparatePermissionsList.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		UserWithRestLinks other = (UserWithRestLinks) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (linkToGetRoleList == null) {
			if (other.linkToGetRoleList != null)
				return false;
		} else if (!linkToGetRoleList.equals(other.linkToGetRoleList))
			return false;
		if (linkToGetSeparatePermissionsList == null) {
			if (other.linkToGetSeparatePermissionsList != null)
				return false;
		} else if (!linkToGetSeparatePermissionsList.equals(other.linkToGetSeparatePermissionsList))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserWithRestLinks [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", userEmail=" + userEmail + ", linkToGetRoleList=" + linkToGetRoleList
				+ ", linkToGetSeparatePermissionsList=" + linkToGetSeparatePermissionsList + "]";
	}
	
}
