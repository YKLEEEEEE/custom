package com.pcwk.ehr.wishtest.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcwk.ehr.wishtest.cmn.BusiNumVO;
import com.pcwk.ehr.wishtest.cmn.SearchVO;
import com.pcwk.ehr.wishtest.dao.WishTestDao;
import com.pcwk.ehr.wishtest.domain.AccountVO;
import com.pcwk.ehr.wishtest.domain.WishVO;

@Service("wishService")
@Transactional
public class WishServiceImpl implements WishService {

	@Autowired
	WishTestDao dao;
	
	@Override
	public int doSave(WishVO inVO, AccountVO ainVO) throws SQLException {
		return dao.doSave(inVO, ainVO);
	}

	@Override
	//@Transactional(propagation =Propagation.REQUIRED)
	public int doDelete(WishVO inVO, AccountVO ainVO) throws SQLException {
		return dao.doDelete(inVO, ainVO);
	}

	@Override
	public int doUpdate(WishVO inVO, AccountVO ainVO) throws SQLException {
		return dao.doUpdate(inVO, ainVO);
	}

	@Override
	public WishVO doSelectOne(BusiNumVO inVO) throws SQLException {
		WishVO outVO = dao.doSelectOne(inVO);
		return outVO;
	}


	@Override
	public List<WishVO> doRetrieve(SearchVO inVO) throws SQLException {
		return dao.doRetrieve(inVO);
	}

	@Override
	public int Check(WishVO inVO) throws SQLException {
		return dao.Check(inVO);
	}

}
