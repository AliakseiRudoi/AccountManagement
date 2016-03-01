package com.epam.rudoi.accountManagementSystem.service;

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

import com.epam.rudoi.accountManagementSystem.dao.IUserDAO;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;
import com.epam.rudoi.accountManagementSystem.entity.UserWithRestLinks;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
public class UserServiceTest {

	@Mock
	private IUserDAO userDAOMock;
	@Mock
	private User userMock;
	@Mock
	private List<User> usersMock;
	@Mock
	private List<UserWithRestLinks> usersWithLinkMock;
	
	@InjectMocks
	@Autowired
	IUserService userService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		assertNotNull(userDAOMock);
		assertNotNull(userMock);
		assertNotNull(usersMock);
		assertNotNull(userService);
	}
	
	@Test
	public void createUserTest()  throws ServiceException, DAOException {
		Long expectedRoleId = anyLong();
		Long resultRoleId = null;
		when(userDAOMock.create(userMock)).thenReturn(anyLong());
		
		resultRoleId = userService.createUser(userMock);
		verify(userDAOMock, times(1)).create(userMock);
		assertEquals(expectedRoleId, resultRoleId);
	}
	
	@Test
	public void readUserTest() throws ServiceException, DAOException {
		User expectedUser = userMock;
		User resultUser = null;
		when(userDAOMock.read(anyLong())).thenReturn(expectedUser);
		
		resultUser = userService.readUser(anyLong());
		verify(userDAOMock, times(1)).read(anyLong());
		assertEquals(expectedUser, resultUser);
		
	} 
	
	@Test
	public void updateUserTest() throws ServiceException, DAOException {
		userService.updateUser(userMock);
		verify(userDAOMock, times(1)).update(userMock);
	}
	
	@Test
	public void deleteUserTest() throws ServiceException, DAOException {
		userService.deleteUser(anyLong());
		verify(userDAOMock, times(1)).delete(anyLong());
	}
	
	@Test
	public void getAllUsersTest() throws ServiceException, DAOException {
		List<UserWithRestLinks> expectedUsers = usersWithLinkMock;
		List<UserWithRestLinks> resultUsers = null;
		when(userDAOMock.getAllUsers()).thenReturn(expectedUsers);
		
		resultUsers = userService.getAllUsers();
		verify(userDAOMock, times(1)).getAllUsers();
		assertEquals(expectedUsers, resultUsers);
	}
	
	@Test
	public void linkWithRolesTest()  throws ServiceException, DAOException {
		Long userId = 1L;
		List<Role> roles = new ArrayList<Role>();
		
		userService.linkWithRoles(userId, roles);
		verify(userDAOMock, times(1)).linkWithItems(userId, roles);
	}
	
	@Test
	public void readExistRolesTest() throws ServiceException, DAOException {
		userService.readExistRoles(anyLong());
		verify(userDAOMock, times(1)).readExistItems(anyLong());
	}
	
	@Test
	public void unlinkWithRolesTest() throws ServiceException, DAOException {
		Long userId = 1L;
		List<Role> roles = new ArrayList<Role>();
		
		userService.unlinkWithRoles(userId, roles);
		verify(userDAOMock, times(1)).unlinkWithItems(userId, roles);
	}
	
}
