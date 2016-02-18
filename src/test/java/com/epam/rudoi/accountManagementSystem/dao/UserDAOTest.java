package com.epam.rudoi.accountManagementSystem.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
public class UserDAOTest {

	@Autowired
	private IUserDAO userDAO;
	
	@Test
	public void createUserTest() throws DAOException {
		Long expectedUserId = 1L;
		Long resultUserId = null;
		List<Role> rolesList = null;		
		User user = new User(1L, "user1", "user1", "user1", "user1@user.com", rolesList);
		
		resultUserId = userDAO.create(user);
		assertEquals(expectedUserId, resultUserId);
	}
	
	@Test
	public void getAllUsersTest() throws DAOException{
		List<User> resultUsersList = null;
		resultUsersList = userDAO.getAllUsers();
		assertNotNull(resultUsersList);
	}
	
	@Test
	public void readUserTest() throws DAOException {
		List<Role> roles = new ArrayList<Role>();
		List<Permission> permissions = new ArrayList<Permission>();
		User expectedUser = new User(1L, "user2", "user2", "user2", "user2@user.com", roles, permissions);
		User resultUser = null;
		
		resultUser = userDAO.read(1L);
		assertEquals(expectedUser.getUserId(), resultUser.getUserId());
	}
	
	@Test
	public void updateUserTest() throws DAOException {
		List<Role> roles = new ArrayList<Role>();
		List<Permission> permissions = new ArrayList<Permission>();
		User expectedUser = new User(1L, "user1Update", "user1Update", "user1Update", "user1Update@user.com", roles, permissions);
		User resultUser = null;
		
		userDAO.update(expectedUser);
		resultUser = userDAO.read(1L);
		assertEquals(expectedUser.getFirstName(), resultUser.getFirstName());
	}
	
	@Test (expected=EmptyResultDataAccessException.class)
	public void deleteUserTest() throws DAOException {
		User resultUser = null; 
		
		userDAO.delete(4L);
		resultUser = userDAO.read(4L);
		assertNull(resultUser);
	}
	
	@Test
	public void linkWithItemsTest() throws DAOException {
		
		List<Role> expectedRolesList = new ArrayList<Role>();
		List<Role> resultRolesList = null;
		Role role = new Role(3L, "content-manager");
		expectedRolesList.add(role);
		userDAO.linkWithItems(4L, expectedRolesList);
		
		resultRolesList = userDAO.readExistItems(4L);
		assertEquals(expectedRolesList, resultRolesList);
	}
	
	@Test
	public void readExistItemsTest() throws DAOException {
		List<Role> resultRolesList = new ArrayList<Role>();
		resultRolesList = userDAO.readExistItems(1L);

		assertFalse(resultRolesList.isEmpty());
	}
	
	@Test
	public void unlinkWithItemsTestTest() throws DAOException {
		List<Role> rolesList = new ArrayList<Role>();
		List<Role> resultRolesList = null;
		Role role = new Role(1L, "createRole");
		Role role2 = new Role(2L, "readRole");
		rolesList.add(role);
		rolesList.add(role2);
		
		userDAO.unlinkWithItems(2L, rolesList);
		resultRolesList = userDAO.readExistItems(2L);
		assertTrue(resultRolesList.isEmpty());
	}
	
	@Test
	public void linkWithSeparatePermissionsTest() throws DAOException {
		List<Permission> expectedPermissionsList = new ArrayList<Permission>();
		List<Permission> resultPermissionsList = null;
		Permission permission = new Permission(3L, "updateRole");
		expectedPermissionsList.add(permission);
		
		userDAO.linkWithSeparatePermissions(4L, expectedPermissionsList);
		resultPermissionsList = userDAO.readExistSeparatePermissions(4L);
		assertEquals(expectedPermissionsList, resultPermissionsList);
	}
	
	@Test
	public void readExistSeparatePermissionsTest() throws DAOException {
		List<Permission> resultPermissionsList = new ArrayList<Permission>();
		resultPermissionsList = userDAO.readExistSeparatePermissions(1L);

		assertFalse(resultPermissionsList.isEmpty());
	}

	@Test
	public void unlinkWithSeparatePermissionsTest() throws DAOException {
		List<Permission> permissionsList = new ArrayList<Permission>();
		List<Permission> resultPermissionsList = null;
		Permission permission = new Permission(3L, "content-manager");
		Permission permission2 = new Permission(3L, "content-manager");
		permissionsList.add(permission);
		permissionsList.add(permission2);
		
		userDAO.unlinkWithSeparatePermissions(3L, permissionsList);
		resultPermissionsList = userDAO.readExistSeparatePermissions(3L);
		assertTrue(resultPermissionsList.isEmpty());
	}
	
}
