package com.epam.rudoi.accountManagementSystem.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.epam.rudoi.accountManagementSystem.entity.Content;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context_spring_test.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
public class ContentDAOTest {

	@Autowired
	private IContentDAO contentDAO;
	
	@Test
	public void createContentTest() throws DAOException {
		Long expectedContentId = 1L;
		Long resultContentId = null;
		Content content = new Content(1L, "test", "test");
		
		resultContentId = contentDAO.create(content);
		assertEquals(expectedContentId, resultContentId);
	}
	
	@Test
	public void readContentTest() throws DAOException {
		Content expectedContent = new Content(1L, "mkyong", "mkyong");
		Content resultContent = null;
		
		resultContent = contentDAO.read(1L);
		assertEquals(expectedContent, resultContent);
		
	}
	
	@Test
	public void updateContenTest() throws DAOException {
		Content expectedContent = new Content(2L, "testUpdated", "testUpdated");
		Content resultContent = null;
		
		contentDAO.update(expectedContent);
		resultContent = contentDAO.read(2L);
		assertEquals(expectedContent, resultContent);
		
	}
	
	@Test (expected=EmptyResultDataAccessException.class)
	public void deleteContenTest() throws DAOException {
		Content resultContent = null; 
		
		contentDAO.delete(3L);
		resultContent = contentDAO.read(3L);
		assertNull(resultContent);
	}
	
}
