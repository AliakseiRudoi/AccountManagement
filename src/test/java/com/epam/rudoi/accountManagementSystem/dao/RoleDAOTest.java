package com.epam.rudoi.accountManagementSystem.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
public class RoleDAOTest {
	
	@Autowired
	private IRoleDAO roleDAO;
	
	@Test
	public void createRoleTest() throws DAOException {
		Long expectedRoleId = 1L;
		Long resultRoleId = null;
		List<PermissionGroup> permissionsList = null;		
		
		Role role = new Role(1L, "test", permissionsList);
		
		resultRoleId = roleDAO.create(role);
		assertEquals(expectedRoleId, resultRoleId);
	}
	
	@Test
	public void readRoleTest() throws DAOException {
		List<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>();
		List<Permission> permissions = new ArrayList<Permission>();
		
		Role expectedRole = new Role(3L, "content-manager", permissionGroups, permissions);
		Role resultRole = null;
		
		resultRole = roleDAO.read(3L);
		assertEquals(expectedRole, resultRole);
	}
	
	@Test
	public void updateRoleTest() throws DAOException {
		List<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>();
		List<Permission> permissions = new ArrayList<Permission>();
		
		Role expectedRole = new Role(2L, "adminUpdated", permissionGroups, permissions);
		Role resultRole = null;
		
		roleDAO.update(expectedRole);
		resultRole = roleDAO.read(2L);
		assertEquals(expectedRole, resultRole);
	}
	
	@Test (expected=EmptyResultDataAccessException.class)
	public void deleteRoleTest() throws DAOException {
		Role resultRole = null; 
		
		roleDAO.delete(4L);
		resultRole = roleDAO.read(4L);
		assertNull(resultRole);
	}

	@Test
	public void linkWithItemsTest() throws DAOException {
		List<PermissionGroup> expectedPermissionGroupList = new ArrayList<PermissionGroup>();
		List<PermissionGroup> resultPermissionGroupList = null;
		PermissionGroup permissionGroup = new PermissionGroup(3L, "permGroup-content-manage");
		expectedPermissionGroupList.add(permissionGroup);
		
		roleDAO.linkWithItems(3L, expectedPermissionGroupList);
		resultPermissionGroupList = roleDAO.readExistItems(3L);
		assertEquals(expectedPermissionGroupList, resultPermissionGroupList);
	}
	
	@Test
	public void readExistItemsTest() throws DAOException {
		List<PermissionGroup> expectedPermissionGroupsList = new ArrayList<PermissionGroup>();
		expectedPermissionGroupsList = roleDAO.readExistItems(1L);
		assertFalse(expectedPermissionGroupsList.isEmpty());
	}
	
	@Test
	public void unlinkWithItemsTest() throws DAOException {
		List<PermissionGroup> permissionGroupsList = new ArrayList<PermissionGroup>();
		List<PermissionGroup> resultPermissionGroupsList = null;
		PermissionGroup permissionGroup = new PermissionGroup(1L, "createRole");
		PermissionGroup permissionGroup2 = new PermissionGroup(2L, "readRole");
		permissionGroupsList.add(permissionGroup);
		permissionGroupsList.add(permissionGroup2);
		
		roleDAO.unlinkWithItems(2L, permissionGroupsList);
		resultPermissionGroupsList = roleDAO.readExistItems(2L);
		assertTrue(resultPermissionGroupsList.isEmpty());
	}
	
	@Test
	public void getAllRolesTest() throws DAOException{
		List<Role> resultRolesList = null;
		resultRolesList = roleDAO.getAllRoles();
		
		assertNotNull(resultRolesList);
	}
	
	@Test
	public void linkWithSeparatePermissionsTest() throws DAOException {
		List<Permission> expectedPermissionList = new ArrayList<Permission>();
		List<Permission> resultPermissionList = null;
		Permission permission = new Permission(3L, "updateRole");
		expectedPermissionList.add(permission);
		
		roleDAO.linkWithSeparatePermissions(3L, expectedPermissionList);
		resultPermissionList = roleDAO.readExistSeparatePermissions(3L);
		assertEquals(expectedPermissionList, resultPermissionList);
	}
	
	@Test
	public void readExistSeparatePermissionsTest() throws DAOException {
		List<Permission> expectedPermissionList = new ArrayList<Permission>();
		expectedPermissionList = roleDAO.readExistSeparatePermissions(1L);
		assertFalse(expectedPermissionList.isEmpty());
	}
	
	@Test
	public void unlinkWithSeparatePermissionsTest() throws DAOException {
		List<Permission> permissionsList = new ArrayList<Permission>();
		List<Permission> resultPermissionsList = null;
		Permission permission = new Permission(1L, "createRole");
		Permission permission2 = new Permission(2L, "readRole");
		permissionsList.add(permission);
		permissionsList.add(permission2);
		
		roleDAO.unlinkWithSeparatePermissions(2L, permissionsList);
		resultPermissionsList = roleDAO.readExistSeparatePermissions(2L);
		assertTrue(resultPermissionsList.isEmpty());
	}
}
