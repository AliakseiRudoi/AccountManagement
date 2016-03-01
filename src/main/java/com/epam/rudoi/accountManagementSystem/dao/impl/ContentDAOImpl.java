package com.epam.rudoi.accountManagementSystem.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.rudoi.accountManagementSystem.dao.IContentDAO;
import com.epam.rudoi.accountManagementSystem.entity.Content;
import com.epam.rudoi.accountManagementSystem.exceptions.DAOException;

public class ContentDAOImpl extends JdbcDaoSupport implements IContentDAO {
	
	 public static final String SQL_CREATE_CONTENT = "INSERT INTO CONTENT ( CONTENT_TITLE, CONTENT_TEXT) VALUES (?,?)";
	 public static final String SQL_READ_CONTENT= "SELECT * FROM CONTENT WHERE CONTENT_ID = ?";
	 public static final String SQL_UPDATE_CONTENT= "UPDATE CONTENT SET CONTENT_TITLE=?, CONTENT_TEXT=? WHERE CONTENT_ID= ?";
	 public static final String SQL_DELETE_CONTENT= "DELETE FROM CONTENT WHERE CONTENT_ID = ?";
	
	@Autowired
	private DataSource dataSource;
	
	public Long create(Content content) throws DAOException {
		Long contentId= (long)getJdbcTemplate().update(SQL_CREATE_CONTENT,
				new Object[] { content.getContentTitle(), content.getContentText() });
		return contentId;
	}

	public Content read(Long contenId) throws DAOException {
		Content content = (Content)getJdbcTemplate().queryForObject(
				SQL_READ_CONTENT, new Object[] { contenId }, 
				new BeanPropertyRowMapper(Content.class));
		return content;
	}
	
	public void update(Content content) throws DAOException {
		getJdbcTemplate().update(SQL_UPDATE_CONTENT,
				new Object[] { content.getContentTitle(), content.getContentText(), content.getContentId() });
	}

	public void delete(Long contentId) throws DAOException {
		getJdbcTemplate().update(SQL_DELETE_CONTENT, Long.valueOf(contentId));
	}

}
