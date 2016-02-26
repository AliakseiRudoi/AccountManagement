package com.epam.rudoi.accountManagementSystem.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
public class PermissionDAOTest {

	@Autowired
	private IPermissionDAO permissionDAO;
	
	@Test
	public void createPermissionTest() throws DAOException {
		Long expectedPermissionId = 1L;
		Long resultPermissionId = null;
		
		Permission permission = new Permission(1L, "test");
		
		resultPermissionId = permissionDAO.create(permission);
		assertEquals(expectedPermissionId, resultPermissionId);
	}
	
	@Test
	public void readPermissionTest() throws DAOException {
		Permission expectedPermission= new Permission(3L, "permission-update-user");
		Permission resultPermission = null;
		
		resultPermission = permissionDAO.read(3L);
		assertEquals(expectedPermission, resultPermission);
	}
	
	@Test
	public void updatePermissionTest() throws DAOException {
		Permission expectedPermission = new Permission(2L, "adminUpdated");
		Permission resultPermission = null;
		
		permissionDAO.update(expectedPermission);
		resultPermission = permissionDAO.read(2L); 
		assertEquals(expectedPermission, resultPermission);
	}
	
	@Test (expected=EmptyResultDataAccessException.class)
	public void deletePermissionTest() throws DAOException {
		Permission resultPermission = null; 
		
		permissionDAO.delete(4L);
		resultPermission = permissionDAO.read(4L);
		assertNull(resultPermission);
	}
	
	@Test
	public void getAllPermissionsTest() throws DAOException {
		List<Permission> permissionsList = null;
		permissionsList = permissionDAO.getAllPermissions();

		assertNotNull(permissionsList);
	}
}
