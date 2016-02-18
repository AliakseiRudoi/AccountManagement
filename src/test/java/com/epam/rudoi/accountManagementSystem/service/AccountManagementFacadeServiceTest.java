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

import com.epam.rudoi.accountManagementSystem.entity.Content;
import com.epam.rudoi.accountManagementSystem.entity.Permission;
import com.epam.rudoi.accountManagementSystem.entity.PermissionGroup;
import com.epam.rudoi.accountManagementSystem.entity.Role;
import com.epam.rudoi.accountManagementSystem.entity.User;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
public class AccountManagementFacadeServiceTest {

	@Mock
	private IContentService contentServiceMock;
	@Mock
	private IPermissionService permissionServiceMock;
	@Mock
	private IPermissionGroupService permissionGroupServiceMock;
	@Mock
	private IRoleService roleServiceMock;
	@Mock
	private IUserService userServiceMock;
	
	@Mock
	private Content contentMock;
	@Mock
	private Permission permissionMock;
	@Mock
	private PermissionGroup permissionGroupMock;
	@Mock
	private Role roleMock;
	@Mock
	private User userMock;
	
	@Mock
	List<Permission> permissionsListMock;
	@Mock
	private List<PermissionGroup> permissionGroupsMock;
	@Mock
	private List<Role> rolesMock;
	@Mock
	private List<User> usersMock;
	
	@InjectMocks
	@Autowired
	private IAccountManagerFacadeService facadeService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		assertNotNull(contentServiceMock);
		assertNotNull(permissionServiceMock);
		assertNotNull(permissionGroupServiceMock);
		assertNotNull(roleServiceMock);
		assertNotNull(userServiceMock);
		assertNotNull(facadeService);
		assertNotNull(contentMock);
		assertNotNull(permissionMock);
		assertNotNull(permissionGroupMock);
		assertNotNull(roleMock);
		assertNotNull(userMock);
		assertNotNull(permissionsListMock);
		assertNotNull(permissionGroupsMock);
		assertNotNull(rolesMock);
		assertNotNull(usersMock);
	}

	@Test
	public void createContenTest1() throws DAOException, ServiceException {
		Long expectedContentId = anyLong();
		Long resultContentId = null;
		when(contentServiceMock.createContent(contentMock)).thenReturn(expectedContentId);
		
		resultContentId = facadeService.createContent(contentMock);
		verify(contentServiceMock, times(1)).createContent(contentMock);
		assertEquals(expectedContentId, resultContentId);
	}
	
	@Test
	public void readContentTest() throws ServiceException, DAOException {
		Content expectedContent = new Content(1L, "mkyong", "mkyong");
		Content resultContent = null;
		when(contentServiceMock.readContent(anyLong())).thenReturn(expectedContent);
		
		resultContent = facadeService.readContent(anyLong());
		verify(contentServiceMock,  times(1)).readContent(anyLong());
		assertEquals(expectedContent, resultContent);
		
	}
	
	@Test
	public void updateContentTest() throws ServiceException, DAOException {
		facadeService.updateContent(contentMock);
		verify(contentServiceMock, times(1)).updateContent(contentMock);
	}
	
	@Test
	public void deleteContentTest()  throws ServiceException, DAOException {
		facadeService.deleteContent(anyLong());
		verify(contentServiceMock, times(1)).deleteContent(anyLong());
	}
	
	@Test
	public void createPermissionTest() throws ServiceException, DAOException{
		Long expectedPermissionId = anyLong();
		Long resultPermissionId = null;
		when(permissionServiceMock.createPermission(permissionMock)).thenReturn(anyLong());
		
		resultPermissionId = facadeService.createPermission(permissionMock);
		verify(permissionServiceMock, times(1)).createPermission(permissionMock);
		assertEquals(expectedPermissionId, resultPermissionId);
	}
	
	@Test
	public void readPermissionTest() throws ServiceException, DAOException {
		Permission expectedPermission = permissionMock;
		Permission resultPermission = null;
		when(permissionServiceMock.readPermission(anyLong())).thenReturn(expectedPermission);
		
		resultPermission = facadeService.readPermission(anyLong());
		verify(permissionServiceMock,  times(1)).readPermission(anyLong());
		assertEquals(expectedPermission, resultPermission);
	}
	
	@Test
	public void updatePermissionTest() throws ServiceException, DAOException {
		facadeService.updatePermission(permissionMock);
		verify(permissionServiceMock, times(1)).updatePermission(permissionMock);
	}
	
	@Test
	public void deletePermissionTest()  throws ServiceException, DAOException {
		facadeService.deletePermission(anyLong());
		verify(permissionServiceMock, times(1)).deletePermission(anyLong());
	}
	
	@Test
	public void getAllPermissionsTest() throws ServiceException, DAOException {
		List<Permission> expectedPermissionsList = permissionsListMock;
		List<Permission> resultPermissionList = null;
		when(permissionServiceMock.getAllPermissions()).thenReturn(expectedPermissionsList);

		resultPermissionList = facadeService.getAllPermissions();
		verify(permissionServiceMock, times(1)).getAllPermissions();
		assertEquals(expectedPermissionsList, resultPermissionList);
		
	}
	
	@Test
	public void createPermissionGroupTest() throws ServiceException, DAOException {
		Long expectedPermissionGroupId = anyLong();
		Long resultPermissionGroupId = null;
		when(permissionGroupServiceMock.createPermissionGroup(permissionGroupMock)).thenReturn(anyLong());
		
		resultPermissionGroupId = facadeService.createPermissionGroup(permissionGroupMock);
		verify(permissionGroupServiceMock, times(1)).createPermissionGroup(permissionGroupMock);
		assertEquals(expectedPermissionGroupId, resultPermissionGroupId);
		
	}
	
	@Test
	public void readPermissionGroupTest() throws ServiceException, DAOException {
		PermissionGroup expectedPermissionGroup = permissionGroupMock;
		PermissionGroup resultPermissionGroup = null;
		when(permissionGroupServiceMock.readPermissionGroup(anyLong())).thenReturn(expectedPermissionGroup);
		
		resultPermissionGroup = facadeService.readPermissionGroup(anyLong());
		verify(permissionGroupServiceMock, times(1)).readPermissionGroup(anyLong());
		assertEquals(expectedPermissionGroup, resultPermissionGroup);
		
	}
	
	@Test
	public void updatePermissionGroupTest() throws ServiceException, DAOException {
		facadeService.updatePermissionGroup(permissionGroupMock);
		verify(permissionGroupServiceMock, times(1)).updatePermissionGroup(permissionGroupMock);
	}
	
	@Test
	public void deletePermissionGroupTest() throws ServiceException, DAOException {
		facadeService.deletePermissionGroup(anyLong());
		verify(permissionGroupServiceMock, times(1)).deletePermissionGroup(anyLong());
	}
	
	@Test
	public void getAllPermissionGroupsTest() throws ServiceException, DAOException {
		List<PermissionGroup> expectedPermissionGroups = permissionGroupsMock;
		List<PermissionGroup> resultPermissionGroups = null;
		when(permissionGroupServiceMock.getAllPermissionGroups()).thenReturn(expectedPermissionGroups);
		
		resultPermissionGroups = facadeService.getAllPermissionGroups();
		verify(permissionGroupServiceMock, times(1)).getAllPermissionGroups();
		assertEquals(expectedPermissionGroups, resultPermissionGroups);
	}
	
	@Test
	public void linkPermissionGroupWithPermissionsTest() throws ServiceException, DAOException {
		Long permissionGroupId = 1L;
		List<Permission> permissions = new ArrayList<Permission>();
		PermissionGroup permissionGroup = new PermissionGroup(1L, "test", permissions);
		
		facadeService.linkPermissionGroupWithPermissions(permissionGroup);
		verify(permissionGroupServiceMock, times(1)).linkWithPermissions(permissionGroupId, permissions);
	}
	
	@Test
	public void readExistPermissionsOfPermissionGroupTest() throws ServiceException, DAOException {
		facadeService.readExistPermissionsOfPermissionGroup(anyLong());
		verify(permissionGroupServiceMock, times(1)).readExistPermissions(anyLong());
	}
	
	@Test
	public void unlinkPermissionsFromPermissionGroupTest() throws ServiceException, DAOException {
		Long permissionGroupId = 1L;
		List<Permission> permissions = new ArrayList<Permission>();
		PermissionGroup permissionGroup = new PermissionGroup(1L, "test", permissions);
		
		facadeService.unlinkPermissionGroupFromPermissions(permissionGroup);
		verify(permissionGroupServiceMock, times(1)).unlinkWithPermissions(permissionGroupId, permissions);
	}
	
	@Test
	public void createRoleTest() throws ServiceException, DAOException {
		Long expectedRoleId = anyLong();
		Long resultRoleId = null;
		when(roleServiceMock.createRole(roleMock)).thenReturn(anyLong());
		
		resultRoleId = facadeService.createRole(roleMock);
		verify(roleServiceMock, times(1)).createRole(roleMock);
		assertEquals(expectedRoleId, resultRoleId);
	}
	
	@Test
	public void readRoleTest() throws ServiceException, DAOException {
		Role expectedRole = roleMock;
		Role resultRole = null;
		when(roleServiceMock.readRole(anyLong())).thenReturn(expectedRole);
		
		resultRole = facadeService.readRole(anyLong());
		verify(roleServiceMock, times(1)).readRole(anyLong());
		assertEquals(expectedRole, resultRole);
	}
	
	@Test
	public void updateRoleTest() throws ServiceException, DAOException {
		facadeService.updateRole(roleMock);
		verify(roleServiceMock, times(1)).updateRole(roleMock);
	}
	
	@Test
	public void deleteRoleTest() throws ServiceException, DAOException {
		facadeService.deleteRole(anyLong());
		verify(roleServiceMock, times(1)).deleteRole(anyLong());
	}

	@Test
	public void getAllRolesTest() throws ServiceException, DAOException {
		List<Role> expectedRoles = rolesMock;
		List<Role> resultRoles = null;
		when(roleServiceMock.getAllRoles()).thenReturn(expectedRoles);
		
		resultRoles = facadeService.getAllRoles();
		verify(roleServiceMock, times(1)).getAllRoles();
		assertEquals(expectedRoles, resultRoles);
	}
	
	@Test
	public void linkRoleWithPermissionGroupsTest() throws ServiceException, DAOException {
		Long roleId = 1L;
		List<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>();
		Role role = new Role(1L, "test", permissionGroups);
		
		facadeService.linkRoleWithPermissionGroups(role);
		verify(roleServiceMock, times(1)).linkWithPermissionGroups(roleId, permissionGroups);
	}
	

	@Test
	public void readExistPermissionGroupsOfRoleTest() throws ServiceException, DAOException {
		facadeService.readExistPermissiongroupsOfRole(anyLong());
		verify(roleServiceMock, times(1)).readExistPermissiongroups(anyLong());
	}
	
	@Test
	public void unlinkPermissionGroupsFromRoleTest() throws ServiceException, DAOException {
		Long roleId = 1L;
		List<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>();
		Role role = new Role(1L, "test", permissionGroups);
		
		facadeService.unlinkPermissionGroupsFromRole(role);
		verify(roleServiceMock, times(1)).unlinkWithPermissionGroups(roleId, permissionGroups);
	}
	
	@Test
	public void readUserTest() throws ServiceException, DAOException {
		User expectedUser = userMock;
		User resultUser = null;
		when(userServiceMock.readUser(anyLong())).thenReturn(expectedUser);
		
		resultUser = facadeService.readUser(anyLong());
		verify(userServiceMock, times(1)).readUser(anyLong());
		assertEquals(expectedUser, resultUser);
	} 
	
	@Test
	public void updateUserTest() throws ServiceException, DAOException {
		facadeService.updateUser(userMock);
		verify(userServiceMock, times(1)).updateUser(userMock);
	}
	
	@Test
	public void deleteUserTest() throws ServiceException, DAOException {
		facadeService.deleteUser(anyLong());
		verify(userServiceMock, times(1)).deleteUser(anyLong());
	}
	
	@Test
	public void getAllUsersTest() throws ServiceException, DAOException {
		List<User> expectedUsers = usersMock;
		List<User> resultUsers = null;
		when(userServiceMock.getAllUsers()).thenReturn(expectedUsers);
		
		resultUsers = facadeService.getAllUsers();
		verify(userServiceMock, times(1)).getAllUsers();
		assertEquals(expectedUsers, resultUsers);
	}
	
	@Test
	public void linkUserWithRolesTest()  throws ServiceException, DAOException {
		Long userId = 1L;
		List<Role> roles = new ArrayList<Role>();
		User user = new User(1L, "test", "test", "test", "test", roles);
		
		facadeService.linkUserWithRoles(user);
		verify(userServiceMock, times(1)).linkWithRoles(userId, roles);
	}
	
	@Test
	public void readExistRolesOfUserTest() throws ServiceException, DAOException {
		facadeService.readExistRolesOfUser(anyLong());
		verify(userServiceMock, times(1)).readExistRoles(anyLong());
	}
	
	@Test
	public void unlinkRolesFromUserTest() throws ServiceException, DAOException {
		Long userId = 1L;
		List<Role> roles = new ArrayList<Role>();
		User user = new User(1L, "test", "test", "test", "test", roles);
		
		facadeService.unlinkRolesFromUser(user);
		verify(userServiceMock, times(1)).unlinkWithRoles(userId, roles);
	}
	
	@Test
	public void linkUserWithSeparatePermissionsTest()  throws ServiceException, DAOException {
		Long userId = 1L;
		List<Role> roles = new ArrayList<Role>();
		List<Permission> permissions = new ArrayList<Permission>();
		User user = new User(1L, "test", "test", "test", "test", roles, permissions);
		
		facadeService.linkUserWithSeparatePermissions(user);
		verify(userServiceMock, times(1)).linkWithSeparatePermissions(userId, permissions);
	}
	
	@Test
	public void readExistSeparatePermissionsOfUserTest() throws ServiceException, DAOException {
		facadeService.readExistSeparatePermissionsOfUser(anyLong());
		verify(userServiceMock, times(1)).readExistSeparatePermissions(anyLong());
	}
	
	@Test
	public void unlinkSeparatePermissionsFromUserTest() throws ServiceException, DAOException {
		Long userId = 1L;
		List<Role> roles = new ArrayList<Role>();
		List<Permission> permissions = new ArrayList<Permission>();
		User user = new User(1L, "test", "test", "test", "test", roles, permissions);
		
		facadeService.unlinkSeparatePermissionsFromUser(user);
		verify(userServiceMock, times(1)).unlinkWithSeparatePermissions(userId, permissions);
	}
}
