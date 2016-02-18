package com.epam.rudoi.accountManagementSystem.dao.impl.extractors.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.User;

public class UsersSeparatePermsExtractor implements ResultSetExtractor{

	@Override
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Long, User> map = new HashMap<Long, User>();
	
		while (rs.next()) {
			Long userId = rs.getLong("USER_ID");
			User user = map.get(userId);
			if(user==null){
				user = new User();
				user.setUserId(userId);
				 map.put(userId, user);
			}
			
			Long permissionId = rs.getLong("PERMISSION_ID");
			  if (permissionId > 0) {
				  Permission permission = new Permission();
				  permission.setPermissionId(permissionId);
				  permission.setPermissionName(rs.getString("PERMISSION_NAME"));
				  List<Permission> permissions = new ArrayList<Permission>();
				  permissions.add(permission);
				  user.setSeparatePermissionsList(permissions);
			  }
		}
		return new ArrayList<User>(map.values());
	}
}
