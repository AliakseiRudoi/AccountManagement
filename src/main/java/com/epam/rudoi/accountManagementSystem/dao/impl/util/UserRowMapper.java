package com.epam.rudoi.accountManagementSystem.dao.impl.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.rudoi.accountManagementSystem.entity.UserWithRestLinks;

public class UserRowMapper implements RowMapper<UserWithRestLinks>{
	
	@Override
	public UserWithRestLinks mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserWithRestLinks user = new UserWithRestLinks();
		user.setUserId(rs.getLong("USER_ID"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		user.setUserName(rs.getString("USER_NAME"));
		user.setUserEmail(rs.getString("USER_EMAIL"));
		user.setLinkToGetRoleList("accountManagementSystem/rest/user/"+user.getUserId()+"/roles");
		user.setLinkToGetSeparatePermissionsList("accountManagementSystem/rest/user/"+user.getUserId()+"/separatepermissions");
		return user;
	}

}
