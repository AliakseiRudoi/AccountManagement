package com.epam.rudoi.accountManagementSystem.dao.impl.extractors.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.epam.rudoi.accountManagementSystem.entity.Permission;

public class SingleUserSeparateExtractor implements ResultSetExtractor{

	@Override
	public ArrayList<Permission> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Long, Permission> map = new HashMap<Long, Permission>();
		while(rs.next()) {
			Long permissionId = rs.getLong("PERMISSION_ID");
			Permission permission = map.get(permissionId);
			if (permission==null) {
				permission = new Permission();
				permission.setPermissionId(permissionId);
				permission.setPermissionName(rs.getString("PERMISSION_NAME"));
				map.put(permissionId, permission);
			}
		}
		
		return new ArrayList<Permission>(map.values());
	}
	
}
