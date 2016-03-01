package com.epam.rudoi.accountManagementSystem.dao.impl.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.rudoi.accountManagementSystem.entity.RoleWithRestLinks;

public class RoleRowMapper implements RowMapper<RoleWithRestLinks>{

	@Override
	public RoleWithRestLinks mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoleWithRestLinks role = new RoleWithRestLinks();
		role.setRoleId(rs.getLong("ROLE_ID"));
		role.setRoleName(rs.getString("ROLE_NAME"));
		role.setLinkToGetPermissionGroupList("accountManagementSystem/rest/role/"+role.getRoleId()+"/permissiongroups");
		return role;
	}

}
