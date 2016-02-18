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
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;

public class SingleUserExtractor implements ResultSetExtractor{

	private Long userId;
	
	public SingleUserExtractor(Long userId) {
		super();
		this.userId = userId;
	}

	@Override
	public User extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Long, User> map = new HashMap<Long, User>();
		while (rs.next()) {
			User user = map.get(userId);
			if(user==null){
				user = new User();
				user.setUserId(userId);
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setUserEmail(rs.getString("USER_EMAIL"));
				map.put(userId, user);
			}
			
			Long roleId = rs.getLong("ROLE_ID");
			if (roleId  > 0) {
				Role role = new Role();
				role.setRoleId(roleId);
				role.setRoleName(rs.getString("ROLE_NAME"));
				List<Role> roles = new ArrayList<Role>();
				roles.add(role);
				
				Long permissionGroupId = rs.getLong("PERMISSION_GROUP_ID");
				if (permissionGroupId  > 0) {
					PermissionGroup permissionGroup = new PermissionGroup();
					permissionGroup.setPermissionGroupId(permissionGroupId);
					permissionGroup.setPermissionGroupName(rs.getString("PERMISSION_GROUP_NAME"));
					List<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>();
					permissionGroups.add(permissionGroup);
				
					 Long permissionId = rs.getLong("PERMISSION_ID");
					  if (permissionId > 0) {
						  Permission permission = new Permission();
						  permission.setPermissionId(permissionId);
						  permission.setPermissionName(rs.getString("PERMISSION_NAME"));
						  List<Permission> permissions = new ArrayList<Permission>();
						  permissions.add(permission);
						  permissionGroup.setPermissionsList(permissions);
						  role.setPermissionGroupList(permissionGroups);
				}
					  user.setRolesList(roles); 
				}
			} 
		}				
		
		return map.get(userId);
	}
}
