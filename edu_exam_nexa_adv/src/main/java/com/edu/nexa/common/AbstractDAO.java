package com.edu.nexa.common;

import com.edu.nexa.common.AbstractDAO;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@SuppressWarnings("rawtypes")
public class AbstractDAO {
	private static final Logger logger = LoggerFactory.getLogger(AbstractDAO.class);
  
	@Autowired
	private SqlSessionTemplate sqlSession;
  
	protected void printQueryId(String queryId) {
		if (logger.isDebugEnabled()) {
			logger.debug("\t〓〓〓〓〓〓〓〓〓〓〓〓〓  DB Query and Parameters 〓〓〓〓〓〓〓〓〓〓〓〓〓");	
			logger.debug("\t■ QueryId  \t:  " + queryId);	
			logger.debug("\t〓〓〓〓〓〓〓〓〓〓〓〓〓  DB Query and Parameters 〓〓〓〓〓〓〓〓〓〓〓〓〓");	
		}
	}

	protected void printQueryId(String queryId, Object params) {
		if (logger.isDebugEnabled()) {
			logger.debug("\t〓〓〓〓〓〓〓〓〓〓〓〓〓  DB Query and Parameters 〓〓〓〓〓〓〓〓〓〓〓〓〓");	
			logger.debug("\t■ QueryId  \t:  " + queryId);
			logger.debug("\t■ Params   \t:  " + params);
			logger.debug("\t〓〓〓〓〓〓〓〓〓〓〓〓〓  DB Query and Parameters 〓〓〓〓〓〓〓〓〓〓〓〓〓");	
		}
	}
  
	public Object insert(String queryId, Object params) {
		printQueryId(queryId, params);
		return Integer.valueOf(this.sqlSession.insert(queryId, params));
	}
  
	public Object update(String queryId, Object params) {
		printQueryId(queryId, params);
		return Integer.valueOf(this.sqlSession.update(queryId, params));
	}
  
	public Object delete(String queryId, Object params) {
		printQueryId(queryId, params);
		return Integer.valueOf(this.sqlSession.delete(queryId, params));
	}
  
	public Object selectOne(String queryId) {
		printQueryId(queryId);
		return this.sqlSession.selectOne(queryId);
	}
  
	public Object selectOne(String queryId, Object params) {
		printQueryId(queryId, params);
		return this.sqlSession.selectOne(queryId, params);
	}

  
	public List selectList(String queryId) {
		printQueryId(queryId);
		return this.sqlSession.selectList(queryId);
	}

  
	public List selectList(String queryId, Object params) {
		printQueryId(queryId, params);
		return this.sqlSession.selectList(queryId, params);
	}
}
