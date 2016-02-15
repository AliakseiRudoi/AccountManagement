package com.epam.rudoi.accountManagementApi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.epam.rudoi.accountManagementApi.dao.IPermissionDAO;
import com.epam.rudoi.accountManagementApi.entity.Permission;
import com.epam.rudoi.accountManagementApi.exceptions.DAOException;
import com.epam.rudoi.accountManagementApi.exceptions.ServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
public class PermissionServiceTest {

	@Mock
	private IPermissionDAO permissionDAOMock;
	@Mock
	Permission permissionMock;
	@Mock
	List<Permission> permissionsListMock;
	
	@InjectMocks
	@Autowired
	IPermissionService permissionService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		assertNotNull(permissionService);
		assertNotNull(permissionDAOMock);
		assertNotNull(permissionsListMock);
	}
	
	@Test
	public void createPermissionTest() throws ServiceException, DAOException{
		Long expectedPermissionId = anyLong();
		Long resultPermissionId = null;
		when(permissionDAOMock.create(permissionMock)).thenReturn(anyLong());
		
		resultPermissionId = permissionService.createPermission(permissionMock);
		verify(permissionDAOMock, times(1)).create(permissionMock);
		assertEquals(expectedPermissionId, resultPermissionId);
	}
	
	@Test
	public void readPermissionTest() throws ServiceException, DAOException {
		Permission expectedPermission = permissionMock;
		Permission resultPermission = null;
		when(permissionDAOMock.read(anyLong())).thenReturn(expectedPermission);
		
		resultPermission = permissionService.readPermission(anyLong());
		verify(permissionDAOMock,  times(1)).read(anyLong());
		assertEquals(expectedPermission, resultPermission);
	}
	
	@Test
	public void updatePermissionTest() throws ServiceException, DAOException {
		permissionService.updatePermission(permissionMock);
		verify(permissionDAOMock, times(1)).update(permissionMock);
	}
	
	@Test
	public void deletePermissionTest()  throws ServiceException, DAOException {
		permissionService.deletePermission(anyLong());
		verify(permissionDAOMock, times(1)).delete(anyLong());
	}
	
	@Test
	public void getAllPermissionsTest() throws ServiceException, DAOException {
		List<Permission> expectedPermissionsList = permissionsListMock;
		List<Permission> resultPermissionList = null;
		when(permissionDAOMock.getAllPermissions()).thenReturn(expectedPermissionsList);

		resultPermissionList = permissionService.getAllPermissions();
		verify(permissionDAOMock, times(1)).getAllPermissions();
		assertEquals(expectedPermissionsList, resultPermissionList);
	}
	
}
