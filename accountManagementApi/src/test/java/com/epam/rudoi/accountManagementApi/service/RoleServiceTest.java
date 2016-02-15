package com.epam.rudoi.accountManagementApi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.rudoi.accountManagementApi.dao.IRoleDAO;
import com.epam.rudoi.accountManagementApi.entity.PermissionGroup;
import com.epam.rudoi.accountManagementApi.entity.Role;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
public class RoleServiceTest {

	@Mock
	private IRoleDAO roleDAOMock;
	@Mock
	private Role roleMock;
	@Mock
	private List<Role> rolesMock;
	
	@InjectMocks
	@Autowired
	IRoleService roleService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		assertNotNull(roleDAOMock);
		assertNotNull(roleMock);
		assertNotNull(rolesMock);
		assertNotNull(roleService);
	}
	
	@Test
	public void createRoleTest() throws ServiceException, DAOException {
		Long expectedRoleId = anyLong();
		Long resultRoleId = null;
		when(roleDAOMock.create(roleMock)).thenReturn(anyLong());
		
		resultRoleId = roleService.createRole(roleMock);
		verify(roleDAOMock, times(1)).create(roleMock);
		assertEquals(expectedRoleId, resultRoleId);
	}
	
	@Test
	public void readRoleTest() throws ServiceException, DAOException {
		Role expectedRole = roleMock;
		Role resultRole = null;
		when(roleDAOMock.read(anyLong())).thenReturn(expectedRole);
		
		resultRole = roleService.readRole(anyLong());
		verify(roleDAOMock, times(1)).read(anyLong());
		assertEquals(expectedRole, resultRole);
	}
	
	@Test
	public void updateRoleTest() throws ServiceException, DAOException {
		roleService.updateRole(roleMock);
		verify(roleDAOMock, times(1)).update(roleMock);
	}
	
	@Test
	public void deleteRoleTest() throws ServiceException, DAOException {
		roleService.deleteRole(anyLong());
		verify(roleDAOMock, times(1)).delete(anyLong());
	}

	@Test
	public void getAllRolesTest() throws ServiceException, DAOException {
		List<Role> expectedRoles = rolesMock;
		List<Role> resultRoles = null;
		when(roleDAOMock.getAllRoles()).thenReturn(expectedRoles);
		
		resultRoles = roleService.getAllRoles();
		verify(roleDAOMock, times(1)).getAllRoles();
		assertEquals(expectedRoles, resultRoles);
	}
	
	@Test
	public void linkWithPermissionGroupsTest() throws ServiceException, DAOException {
		Long roleId = 1L;
		List<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>();
		
		roleService.linkWithPermissionGroups(roleId, permissionGroups);
		verify(roleDAOMock, times(1)).linkWithItems(roleId, permissionGroups);
	}
	

	@Test
	public void readExistPermissionGroupsTest() throws ServiceException, DAOException {
		roleService.readExistPermissiongroups(anyLong());
		verify(roleDAOMock, times(1)).readExistItems(anyLong());
	}
	
	@Test
	public void unlinkWithPermissionGroupsTest() throws ServiceException, DAOException {
		Long roleId = 1L;
		List<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>();
		
		roleService.unlinkWithPermissionGroups(roleId, permissionGroups);
		verify(roleDAOMock, times(1)).unlinkWithItems(roleId, permissionGroups);
	}
	
}
