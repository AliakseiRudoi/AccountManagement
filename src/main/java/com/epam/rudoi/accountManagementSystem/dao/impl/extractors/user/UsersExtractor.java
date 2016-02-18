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

public class UsersExtractor implements ResultSetExtractor{

	@Override
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Long, User> map = new HashMap<Long, User>();
		
		/*for (int i = 0; i < 20; i++) {
			rs.next();
			System.out.println(rs.getRow());
			
		}*/
		Long userId = null;
		User user = null;
		
		Role role = null;
		List<Role> roles = null;
		
		while (rs.next()) {
			System.out.println(rs.getRow());
			
			if (user!=null && userId.equals(rs.getLong("USER_ID"))) {
				Long roleId = rs.getLong("ROLE_ID");
				
				if(roleId > 0 && !role.getRoleId().equals(rs.getLong("ROLE_ID"))) {
					role = new Role();
					role.setRoleId(roleId);
					role.setRoleName(rs.getString("ROLE_NAME"));
					roles.add(role);
					user.setRolesList(roles);
					System.out.println("&&& "+role.getRoleId());
					System.out.println(user.getRolesList());
					/*Long permissionGroupId = rs.getLong("PERMISSION_GROUP_ID");
					  if(permissionGroupId > 0) {
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
						  }
						  role.setPermissionGroupList(permissionGroups);
				} */
				} else {
					continue;
				}
			}
			
			userId = rs.getLong("USER_ID");
		    user = map.get(userId);
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
			
			if(roleId > 0) {
				role = new Role();
				role.setRoleId(roleId);
				role.setRoleName(rs.getString("ROLE_NAME"));
				roles = new ArrayList<Role>();
				roles.add(role);
				System.out.println("!!! "+role.getRoleId());
			}
				 Long permissionGroupId = rs.getLong("PERMISSION_GROUP_ID");
				  if(permissionGroupId > 0) {
					  PermissionGroup permissionGroup = new PermissionGroup();
					  permissionGroup.setPermissionGroupId(permissionGroupId);
					  permissionGroup.setPermissionGroupName(rs.getString("PERMISSION_GROUP_NAME"));
					  List<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>();
					  permissionGroups.add(permissionGroup);
					  /*
					  Long permissionId = rs.getLong("PERMISSION_ID");
					  if (permissionId > 0) {
						  Permission permission = new Permission();
						  permission.setPermissionId(permissionId);
						  permission.setPermissionName(rs.getString("PERMISSION_NAME"));
						  List<Permission> permissions = new ArrayList<Permission>();
						  permissions.add(permission);
						  permissionGroup.setPermissionsList(permissions);
					  }
					  role.setPermissionGroupList(permissionGroups);*/
			} 
		}
		
		
		return new ArrayList<User>(map.values());
	}
	
	
}
