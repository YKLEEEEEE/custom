package com.pcwk.ehr;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.wishtest.cmn.BusiNumVO;
import com.pcwk.ehr.wishtest.cmn.SearchVO;
import com.pcwk.ehr.wishtest.dao.WishTestDao;
import com.pcwk.ehr.wishtest.domain.AccountVO;
import com.pcwk.ehr.wishtest.domain.WishVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class JWebWishTestDao {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired 
	ApplicationContext context;
	
	@Autowired
	WishTestDao dao;
	
	WishVO wishVO01;
	
	BusiNumVO busiNumVO;
	
	SearchVO searchVO;
	
	AccountVO accountVO;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("==============================");
		LOG.debug("context:"+context);
		LOG.debug("boardDao:"+dao);
		LOG.debug("==============================");
		
		wishVO01 = new WishVO("6","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7","8","9","0","","","1","","2","","3");
		accountVO = new AccountVO("6","2","2","2");
		searchVO = new SearchVO("2", "2");
	}
	
	@Test
	@Ignore
	public void doSave()throws SQLException{
		dao.doSave(wishVO01, accountVO);
		
	}
	
	@Test
	@Ignore
	public void doDelete()throws SQLException{
		dao.doDelete(wishVO01, accountVO);
	}
	
	@Test
	//@Ignore
	public void doUpdate()throws SQLException{
		//dao.doSave(wishVO01);
		
		String up = "영";
		
		wishVO01.setCeo(wishVO01.getCeo()+up);
		accountVO.setFactory(accountVO.getFactory()+up);
		
		dao.doUpdate(wishVO01, accountVO);
	}
	
	@Test
	@Ignore
	public void doSelectOne()throws SQLException{
		WishVO outVO123 = dao.doSelectOne(busiNumVO);
		LOG.debug("outVO123: "+outVO123);
	}
	
	@Test
	@Ignore
	public void doRetrieve()throws SQLException{
		
		List<WishVO> list = dao.doRetrieve(searchVO);
	}
	
	
	@Test
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}

}
