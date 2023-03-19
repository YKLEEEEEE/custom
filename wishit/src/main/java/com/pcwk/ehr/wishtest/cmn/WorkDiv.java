package com.pcwk.ehr.wishtest.cmn;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.wishtest.domain.AccountVO;
import com.pcwk.ehr.wishtest.domain.WishVO;

public interface WorkDiv<T> {
	
	int Check(WishVO inVO) throws SQLException;
	
	/**
	 * 등록
	 * @param t
	 * @return 1/0(0이면 실패)(1이면 성공)
	 * @throws SQLException
	 */
	int doSave(WishVO inVO, AccountVO ainVO) throws SQLException;
	
	/**
	 * 삭제
	 * @param t
	 * @return 1/0(0이면 실패)(1이면 성공)
	 * @throws SQLException
	 */
	int doDelete(WishVO inVO, AccountVO ainVO) throws SQLException;
	
	/**
	 * 수정
	 * @param t
	 * @return 1/0(0이면 실패)(1이면 성공)
	 * @throws SQLException
	 */
	int doUpdate(WishVO inVO, AccountVO ainVO) throws SQLException;
	
	/**
	 * 단건조회
	 * @param t
	 * @return 1/0(0이면 실패)(1이면 성공)
	 * @throws SQLException
	 */
	WishVO doSelectOne(BusiNumVO inVO)throws SQLException;
	
	/**
	 * 목록조회
	 * @param t
	 * @return 1/0(0이면 실패)(1이면 성공)
	 * @throws SQLException
	 */
	List<WishVO> doRetrieve(SearchVO inVO) throws SQLException;






}
