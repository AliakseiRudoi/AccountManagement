package com.epam.rudoi.accountManagementSystem.dao.impl.extractors.role;

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

public class SingleRoleExtractor implements ResultSetExtractor{

	private Long roleId;
	
	public SingleRoleExtractor() {
		super();
	}
	
	public SingleRoleExtractor(Long roleId) {
		super();
		this.roleId = roleId;
	}
	
	@Override
	public Role extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Long, Role> map = new HashMap<Long, Role>();
		while (rs.next()) {
			Role role = map.get(roleId);
			if(role==null){
				role = new Role();
				role.setRoleId(roleId);
				role.setRoleName(rs.getString("ROLE_NAME"));
				map.put(roleId, role);
			}
			
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
			}
				  role.setPermissionGroupList(permissionGroups);
			}
		}
		return map.get(roleId);
	}
	
}
