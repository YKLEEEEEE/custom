package com.pcwk.ehr.wishtest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.wishtest.cmn.BusiNumVO;
import com.pcwk.ehr.wishtest.cmn.DTO;
import com.pcwk.ehr.wishtest.cmn.SearchVO;
import com.pcwk.ehr.wishtest.domain.AccountVO;
import com.pcwk.ehr.wishtest.domain.WishVO;

@Repository("WishTestDao")
public class WishTestDaoImpl implements WishTestDao {

	final Logger LOG = LogManager.getFormatterLogger(getClass());
	final String NAMESPACE = "com.pcwk.ehr.wishtest";
	final String DOT = ".";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int doSave(WishVO inVO, AccountVO ainVO) throws SQLException {
		LOG.debug("┌─────────────────────────┐");
		LOG.debug("│param: "+inVO);
		LOG.debug("│param: "+ainVO);
		
		String statement = NAMESPACE+DOT+"doSave";
		String statement2 = NAMESPACE+DOT+"doSave2";
		LOG.debug("│statement: "+statement);
		LOG.debug("│statement2: "+statement2);
		
		int flag = 0;
		int flag1 = sqlSessionTemplate.insert(statement, inVO);
		int flag2 = sqlSessionTemplate.insert(statement2, ainVO);
	    LOG.debug("│flag1: "+flag1);
	    LOG.debug("│flag2: "+flag2);
	     
	    if(flag1 == 1 && flag2 == 1) {
	      flag = 1;
	    }

		LOG.debug("└─────────────────────────┘");
		return flag;
	}

	@Override
	public int doDelete(WishVO inVO ,AccountVO ainVO) throws SQLException {
		LOG.debug("┌─────────────────────────┐");
		LOG.debug("│param: "+inVO);
		LOG.debug("│param: "+ainVO);
		
		String statement = NAMESPACE+DOT+"doDelete";
		String statement2 = NAMESPACE+DOT+"doDelete2";
		
		LOG.debug("│statement: "+statement);
		LOG.debug("│statement2: "+statement2);
		
		int flag = 0;
		int flag1 = sqlSessionTemplate.delete(statement, inVO);
		int flag2 = sqlSessionTemplate.delete(statement2, ainVO);
	    LOG.debug("│flag1: "+flag1);
	    LOG.debug("│flag2: "+flag2);
	    
	    if(flag1 == 1 && flag2 == 1) {
	      flag = 1;
	    }
		
		LOG.debug("│flag: "+flag);
		LOG.debug("└─────────────────────────┘");
		return flag;
	}

	@Override
	public int doUpdate(WishVO inVO ,AccountVO ainVO) throws SQLException {
		LOG.debug("┌─────────────────────────┐");
		LOG.debug("│param: "+inVO);
		LOG.debug("│param: "+ainVO);
		
		String statement = NAMESPACE+DOT+"doUpdate";
		String statement2 = NAMESPACE+DOT+"doUpdate2";
		
		LOG.debug("│statement: "+statement);
		LOG.debug("│statement2: "+statement2);
		
		int flag = 0;
		int flag1 = sqlSessionTemplate.update(statement, inVO);
		int flag2 = sqlSessionTemplate.update(statement2, ainVO);
	    LOG.debug("│flag1: "+flag1);
	    LOG.debug("│flag2: "+flag2);
	    
	    if(flag1 == 1 && flag2 == 1) {
	    	flag = 1;
		}
	    
		LOG.debug("│flag: "+flag);
		LOG.debug("└─────────────────────────┘");
		return flag;
	}

	@Override
	public WishVO doSelectOne(BusiNumVO inVO) throws SQLException {
		
		WishVO outVO = null;
		String statement = NAMESPACE+DOT+"doSelectOne";
		LOG.debug("┌─────────────────────────┐");
		LOG.debug("│param: "+inVO);
		LOG.debug("│statement: "+statement);

		
		outVO = sqlSessionTemplate.selectOne(statement, inVO);
		
		LOG.debug("│outVO	: "+outVO);
		LOG.debug("└─────────────────────────┘");
		return outVO;
	}

	@Override
	public List<WishVO> doRetrieve(SearchVO inVO) throws SQLException {
		SearchVO search = (SearchVO)inVO;
		LOG.debug("│search: "+search);
		List<WishVO> list = new ArrayList<WishVO>();
		String statement = NAMESPACE+DOT+"doRetrieve";
		LOG.debug("┌─────────────────────────┐");
		LOG.debug("│param: "+inVO);
		LOG.debug("│list: "+list);
		LOG.debug("│statement: "+statement);
		
		list = sqlSessionTemplate.selectList(statement,search);
		LOG.debug("│list: "+list);
		for(WishVO vo : list) {
			LOG.debug("|vo : " + vo);
		}
		
		LOG.debug("└─────────────────────────┘");
		
		return list;
	}

	@Override
	public int Check(WishVO inVO) throws SQLException {
		LOG.debug("param: " + inVO);

		String statement = NAMESPACE + DOT + "Check";
		LOG.debug("statement: " + statement);

		int flag = sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("flag: " + flag);

		//flag=1이면 있음, 0이면 없음.
		return flag;
	}

}
