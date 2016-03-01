package com.epam.rudoi.accountManagementSystem.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;

import com.epam.rudoi.accountManagementSystem.dao.IContentDAO;
import com.epam.rudoi.accountManagementSystem.entity.Content;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;
import com.epam.rudoi.accountManagementSystem.exceptions.ServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
public class ContentServiceTest {

	@Mock
	IContentDAO contentDaoMock;
	@Mock
	Content contentMock;
	
	@InjectMocks
	@Autowired
	IContentService contentService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		assertNotNull(contentService);
		assertNotNull(contentDaoMock);
	}
	
	@Test
	public void createContentTest() throws ServiceException, DAOException{
		Long expectedContentId = anyLong();
		Long resultContentId = null;
		when(contentDaoMock.create(contentMock)).thenReturn(anyLong());
		
		resultContentId = contentService.createContent(contentMock);
		verify(contentDaoMock, times(1)).create(contentMock);
		assertEquals(expectedContentId, resultContentId);
	}
	
	@Test
	public void readContentTest() throws ServiceException, DAOException {
		Content expectedContent = new Content(1L, "mkyong", "mkyong");
		Content resultContent = null;
		when(contentDaoMock.read(anyLong())).thenReturn(expectedContent);
		
		resultContent = contentService.readContent(anyLong());
		verify(contentDaoMock,  times(1)).read(anyLong());
		assertEquals(expectedContent, resultContent);
		
	}
	
	@Test
	public void updateContentTest() throws ServiceException, DAOException {
		contentService.updateContent(contentMock);
		verify(contentDaoMock, times(1)).update(contentMock);
	}
	
	@Test
	public void deleteContentTest()  throws ServiceException, DAOException {
		contentService.deleteContent(anyLong());
		verify(contentDaoMock, times(1)).delete(anyLong());
	}
	
}
