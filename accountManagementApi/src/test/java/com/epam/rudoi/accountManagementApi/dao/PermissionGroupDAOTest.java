package com.epam.rudoi.accountManagementApi.dao;

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

import com.epam.rudoi.accountManagementApi.entity.Permission;
import com.epam.rudoi.accountManagementApi.entity.PermissionGroup;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
public class PermissionGroupDAOTest {

	@Autowired
	private IPermissionGroupDAO permissionGroupDAO;
	
	@Test
	public void createPermissionGroupTest() throws DAOException {
		List<Permission> permissionsList = new ArrayList<Permission>();
		Permission permission = new Permission(1L, "test");
		Permission permission2 = new Permission(2L, "test2");
		permissionsList.add(permission);
		permissionsList.add(permission2);
		
		Long expectedPermissionGroupId = 1L;
		Long resultPermissionGroupId = null;
		
		PermissionGroup permissionGroup = new PermissionGroup(1L, "test", permissionsList);
		
		resultPermissionGroupId = permissionGroupDAO.create(permissionGroup);
		assertEquals(expectedPermissionGroupId, resultPermissionGroupId);
	}
	
	@Test
	public void readPermissionGroupTest() throws DAOException {
		PermissionGroup expectedPermissionGroup = new PermissionGroup(1L, "permGroup-admin");
		PermissionGroup resultPermissionGroup = null;
		
		resultPermissionGroup = permissionGroupDAO.read(1L);
		assertEquals(expectedPermissionGroup, resultPermissionGroup);
	}
	
	@Test
	public void updatePermissionGroupTest() throws DAOException {
		PermissionGroup expectedPermissionGroup = new PermissionGroup(2L, "permGroup-role-managerUpdated");
		PermissionGroup resultPermissionGroup = null;
		
		permissionGroupDAO.update(expectedPermissionGroup);
		resultPermissionGroup = permissionGroupDAO.read(2L);
		assertEquals(expectedPermissionGroup, resultPermissionGroup);
	}
	
	@Test (expected=EmptyResultDataAccessException.class)
	public void deletePermissionGroupTest() throws DAOException {
		PermissionGroup resultPermissionGroup = null; 
		
		permissionGroupDAO.delete(4L);
		resultPermissionGroup = permissionGroupDAO.read(4L);
		assertNull(resultPermissionGroup);
	}
	
	@Test
	public void linkWithItemsTest() throws DAOException {
		List<Permission> expectedPermissionsList = new ArrayList<Permission>();
		List<Permission> resultPermissionsList = null;
		Permission permission = new Permission(1L, "createRole");
		Permission permission2 = new Permission(2L, "readRole");
		expectedPermissionsList.add(permission);
		expectedPermissionsList.add(permission2);
		
		permissionGroupDAO.linkWithItems(3L, expectedPermissionsList);
		resultPermissionsList = permissionGroupDAO.readExistItems(3L);
		assertEquals(expectedPermissionsList, resultPermissionsList);
	}
	
	@Test
	public void readExistItemsTest() throws DAOException {
		List<Permission> expectedPermissionsList = new ArrayList<Permission>();
		expectedPermissionsList = permissionGroupDAO.readExistItems(1L);
		assertFalse(expectedPermissionsList.isEmpty());
	}
	
	@Test
	public void unlinkWithItemsTestTest() throws DAOException {
		List<Permission> permissionsList = new ArrayList<Permission>();
		List<Permission> resultPermissionsList = null;
		Permission permission = new Permission(1L, "createRole");
		Permission permission2 = new Permission(2L, "readRole");
		permissionsList.add(permission);
		permissionsList.add(permission2);
		
		permissionGroupDAO.unlinkWithItems(2L, permissionsList);
		resultPermissionsList = permissionGroupDAO.readExistItems(2L);
		assertTrue(resultPermissionsList.isEmpty());
	}
	
	@Test
	public void getAllPermissionGroupsTest() throws DAOException {
		List<PermissionGroup> permissionGroupsList = null;
		permissionGroupsList = permissionGroupDAO.getAllPermissionGroups();
		
		assertNotNull(permissionGroupsList);
	}
}
