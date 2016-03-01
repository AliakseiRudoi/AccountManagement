package com.epam.rudoi.accountManagementSystem.dao.impl.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.rudoi.accountManagementSystem.entity.PermissionGroupWithRestLinks;

public class PermissionGroupRowMapper implements RowMapper<PermissionGroupWithRestLinks>{

	@Override
	public PermissionGroupWithRestLinks mapRow(ResultSet rs, int rowNum) throws SQLException {
		PermissionGroupWithRestLinks permissionGroupWithRestLinks = new PermissionGroupWithRestLinks();
		permissionGroupWithRestLinks.setPermissionGroupId(rs.getLong("PERMISSION_GROUP_ID"));
		permissionGroupWithRestLinks.setPermissionGroupName(rs.getString("PERMISSION_GROUP_NAME"));
		permissionGroupWithRestLinks.setLinkToGetPermissionsList("accountManagementSystem/rest/permissiongroup/"+permissionGroupWithRestLinks.getPermissionGroupId()+"/permissions");
		return permissionGroupWithRestLinks;
	}

}
