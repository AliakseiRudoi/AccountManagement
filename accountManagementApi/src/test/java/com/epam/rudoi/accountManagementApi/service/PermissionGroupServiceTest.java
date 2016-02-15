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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.rudoi.accountManagementApi.dao.IPermissionGroupDAO;
import com.epam.rudoi.accountManagementApi.entity.Permission;
import com.epam.rudoi.accountManagementApi.entity.PermissionGroup;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
public class PermissionGroupServiceTest {

	@Mock
	private IPermissionGroupDAO permissionGroupDAOMock;
	@Mock
	private PermissionGroup permissionGroupMock;
	@Mock
	private List<PermissionGroup> permissionGroupsMock;
	@InjectMocks
	@Autowired
	IPermissionGroupService permissionGroupService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		assertNotNull(permissionGroupDAOMock);
		assertNotNull(permissionGroupService);
		assertNotNull(permissionGroupMock);
		assertNotNull(permissionGroupsMock);
	}
	
	@Test
	public void createPermissionGroupTest() throws ServiceException, DAOException {
		Long expectedPermissionGroupId = anyLong();
		Long resultPermissionGroupId = null;
		when(permissionGroupDAOMock.create(permissionGroupMock)).thenReturn(anyLong());
		
		resultPermissionGroupId = permissionGroupService.createPermissionGroup(permissionGroupMock);
		verify(permissionGroupDAOMock, times(1)).create(permissionGroupMock);
		assertEquals(expectedPermissionGroupId, resultPermissionGroupId);
		
	}
	
	@Test
	public void readPermissionGroupTest() throws ServiceException, DAOException {
		PermissionGroup expectedPermissionGroup = permissionGroupMock;
		PermissionGroup resultPermissionGroup = null;
		when(permissionGroupDAOMock.read(anyLong())).thenReturn(expectedPermissionGroup);
		
		resultPermissionGroup = permissionGroupService.readPermissionGroup(anyLong());
		verify(permissionGroupDAOMock, times(1)).read(anyLong());
		assertEquals(expectedPermissionGroup, resultPermissionGroup);
		
	}
	
	@Test
	public void updatePermissionGroupTest() throws ServiceException, DAOException {
		permissionGroupService.updatePermissionGroup(permissionGroupMock);
		verify(permissionGroupDAOMock, times(1)).update(permissionGroupMock);
	}
	
	@Test
	public void deletePermissionGroupTest() throws ServiceException, DAOException {
		permissionGroupService.deletePermissionGroup(anyLong());
		verify(permissionGroupDAOMock, times(1)).delete(anyLong());
	}
	
	@Test
	public void getAllPermissionGroupsTest() throws ServiceException, DAOException {
		List<PermissionGroup> expectedPermissionGroups = permissionGroupsMock;
		List<PermissionGroup> resultPermissionGroups = null;
		when(permissionGroupDAOMock.getAllPermissionGroups()).thenReturn(expectedPermissionGroups);
		
		resultPermissionGroups = permissionGroupService.getAllPermissionGroups();
		verify(permissionGroupDAOMock, times(1)).getAllPermissionGroups();
		assertEquals(expectedPermissionGroups, resultPermissionGroups);
	}
	
	@Test
	public void linkWithPermissionsTest() throws ServiceException, DAOException {
		Long permissionGroupId = 1L;
		List<Permission> permissions = new ArrayList<Permission>();
		
		permissionGroupService.linkWithPermissions(permissionGroupId, permissions);
		verify(permissionGroupDAOMock, times(1)).linkWithItems(permissionGroupId, permissions);
	}
	
	@Test
	public void readExistPermissionsTest() throws ServiceException, DAOException {
		permissionGroupService.readExistPermissions(anyLong());
		verify(permissionGroupDAOMock, times(1)).readExistItems(anyLong());
	}
	
	@Test
	public void unlinkWithPermissionsTest() throws ServiceException, DAOException {
		Long permissionGroupId = 1L;
		List<Permission> permissions = new ArrayList<Permission>();
		
		permissionGroupService.unlinkWithPermissions(permissionGroupId, permissions);
		verify(permissionGroupDAOMock, times(1)).unlinkWithItems(permissionGroupId, permissions);
	}
	
}
