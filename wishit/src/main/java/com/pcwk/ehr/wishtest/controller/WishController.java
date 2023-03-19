package com.pcwk.ehr.wishtest.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.org.eclipse.jdt.internal.core.SetContainerOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ehr.wishtest.cmn.BusiNumVO;
import com.pcwk.ehr.wishtest.cmn.MessageVO;
import com.pcwk.ehr.wishtest.cmn.SearchVO;
import com.pcwk.ehr.wishtest.cmn.StringUtil;
import com.pcwk.ehr.wishtest.domain.AccountVO;
import com.pcwk.ehr.wishtest.domain.WishVO;
import com.pcwk.ehr.wishtest.service.WishService;

@Controller("wishController")
@RequestMapping("wishtest")
public class WishController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	
	@Autowired
	WishService wishService;
	
	@RequestMapping(value = "/wish.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	public String boardView(Model model,SearchVO inVO)throws SQLException{
		String viewPage = "wish";
		
		
		if(null != inVO && inVO.getSearchWordBn()==null) {
			inVO.setSearchWordBn(StringUtil.nvl(inVO.getSearchWordBn()));
		}	
		
		if(null != inVO && null == inVO.getSearchWordC()) {
			inVO.setSearchWordC(StringUtil.nvl(inVO.getSearchWordC()));
		}
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│inVO = "+inVO);
		List<WishVO> list = wishService.doRetrieve(inVO);
		model.addAttribute("list",list);
		
		return viewPage;
		
	}
	
	
	@RequestMapping(value = "/doRetrieve.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doRetrive(SearchVO inVO)throws SQLException{
		String jsonString = "";
		
		
		if(null != inVO && inVO.getSearchWordBn()==null) {
			inVO.setSearchWordBn(StringUtil.nvl(inVO.getSearchWordBn()));
		}	
		
		if(null != inVO && null == inVO.getSearchWordC()) {
			inVO.setSearchWordC(StringUtil.nvl(inVO.getSearchWordC()));
		}
		//LOG.debug("디버깅");
		//LOG.debug("│inVO11 = "+inVO);
		
		List<WishVO> list = wishService.doRetrieve(inVO);
		LOG.debug("│list1 = "+list);
		jsonString = new Gson().toJson(list);
		LOG.debug("│jsonString = "+jsonString);
		LOG.debug("└──────────────────────────────┘");
		
		
		return jsonString;
	}
	
	@RequestMapping(value = "/pop.do", method = RequestMethod.GET)
	public String pop(Model model, SearchVO inVO) throws SQLException{
		String VIEW_NAME = "pop";
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│inVO = "+inVO);
		LOG.debug("│VIEW_NAME = "+VIEW_NAME);
		LOG.debug("└──────────────────────────────┘");
		
		return VIEW_NAME;
	}
	
	
	
	@RequestMapping(value = "/moveToReg.do", method = RequestMethod.GET)
	public String moveToReg(Model model, SearchVO inVO) throws SQLException{
		String VIEW_NAME = "/wish_reg";
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│inVO = "+inVO);
		LOG.debug("│VIEW_NAME = "+VIEW_NAME);
		LOG.debug("└──────────────────────────────┘");
		
		return VIEW_NAME;
	}
	
	
	
	@RequestMapping(value = "/doSave.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doSave(HttpServletRequest req)throws SQLException{
		String jsonString = "";
		WishVO inVO = new WishVO();
		AccountVO inVOA = new AccountVO();
		LOG.debug("┌──────────────────────────────┐");
		
		String busiNumC        =(String)req.getParameter("busiNumC");
		String custom          =(String)req.getParameter("custom");
		String shortN          =(String)req.getParameter("shortN");
		String ceo             =(String)req.getParameter("ceo");
		String chargePerson    =(String)req.getParameter("chargePerson");
		String busiCondition   =(String)req.getParameter("busiCondition");
		String item            =(String)req.getParameter("item");
		String postNum         =(String)req.getParameter("postNum");
		String addr1           =(String)req.getParameter("addr1");
		String addr2           =(String)req.getParameter("addr2");
		String tel             =(String)req.getParameter("tel");
		String fax             =(String)req.getParameter("fax");
		String homePage        =(String)req.getParameter("homePage");
		String coYn            =(String)req.getParameter("coYn");
		String foreignYn       =(String)req.getParameter("foreignYn");
		String taxYn           =(String)req.getParameter("taxYn");
		String countryEng      =(String)req.getParameter("countryEng");
		String countryKor      =(String)req.getParameter("countryKor");
		String specialRelation =(String)req.getParameter("specialRelation");
		String tradeStop       =(String)req.getParameter("tradeStop");
		String contractPeriodS =(String)req.getParameter("contractPeriodS");
		String contractPeriodE =(String)req.getParameter("contractPeriodE");
		String regiInfoMan     =(String)req.getParameter("regiInfoMan");
		String regiInfoDate    =(String)req.getParameter("regiInfoDate");
		String modiInfoMan     =(String)req.getParameter("modiInfoMan");
		String modiInfoDate    =(String)req.getParameter("modiInfoDate");
		String country         =(String)req.getParameter("country");
		
		String factory    =(String)req.getParameter("factory");   
		String tradeBank  =(String)req.getParameter("tradeBank");   
		String accountNum =(String)req.getParameter("accountNum");      
		
		inVO.setBusiNumC(busiNumC);
		inVO.setCustom(custom);
		inVO.setShortN(shortN);
		inVO.setCeo(ceo);
		inVO.setChargePerson(chargePerson);
		inVO.setBusiCondition(busiCondition);
		inVO.setItem(item);
		inVO.setPostNum(postNum);
		inVO.setAddr1(addr1);
		inVO.setAddr2(addr2);
		inVO.setTel(tel);
		inVO.setFax(fax);
		inVO.setHomePage(homePage);
		inVO.setCoYn(coYn);
		inVO.setForeignYn(foreignYn);
		inVO.setTaxYn(taxYn);
		inVO.setCountryEng(countryEng);
		inVO.setCountryKor(countryKor);
		inVO.setSpecialRelation(specialRelation);
		inVO.setTradeStop(tradeStop);
		inVO.setContractPeriodS(contractPeriodS);
		inVO.setContractPeriodE(contractPeriodE);
		inVO.setRegiInfoMan(regiInfoMan);
		inVO.setRegiInfoDate(regiInfoDate);
		inVO.setModiInfoMan(modiInfoMan);
		inVO.setModiInfoDate(modiInfoDate);
		inVO.setCountry(country);
		
		inVOA.setBusiNumA(busiNumC);
		inVOA.setFactory(factory);
		inVOA.setTradeBank(tradeBank);
		inVOA.setAccountNum(accountNum);
		
		if(null != inVO && inVO.getContractPeriodS()==null) {
			inVO.setContractPeriodS(StringUtil.nvl(inVO.getContractPeriodS()));
		}	
		
		if(null != inVO && null == inVO.getContractPeriodE()) {
			inVO.setContractPeriodE(StringUtil.nvl(inVO.getContractPeriodE()));
		}
		if(null != inVO && inVO.getRegiInfoDate()==null) {
			inVO.setRegiInfoDate(StringUtil.nvl(inVO.getRegiInfoDate()));
		}	
		
		if(null != inVO && null == inVO.getModiInfoDate()) {
			inVO.setModiInfoDate(StringUtil.nvl(inVO.getModiInfoDate()));
		}
		if(null != inVO && null == inVO.getCountry()) {
			inVO.setCountry(StringUtil.nvl(inVO.getCountry()));
		}
		if(null != inVO && null == inVO.getSpecialRelation()) {
			inVO.setSpecialRelation(StringUtil.nvl(inVO.getSpecialRelation()));
		}
		if(null != inVO && null == inVO.getTradeStop()) {
			inVO.setTradeStop(StringUtil.nvl(inVO.getTradeStop()));
		}
		

		                       
		LOG.debug("│inVO = "+inVO);
		LOG.debug("└──────────────────────────────┘");
		String message = "";
		
		int cnt = wishService.Check(inVO);
		if(1 <= cnt) {
			message = "사업자번호가 같은 항목이 있습니다.";
			cnt = 3;
			jsonString = new Gson().toJson(new MessageVO(String.valueOf(cnt),message));
		}else {
			int flag = this.wishService.doSave(inVO, inVOA);
	
			if(1==flag) {
				message = "등록되었습니다.";
			}else {
				message = "등록 실패.";
			}
			jsonString = new Gson().toJson(new MessageVO(String.valueOf(flag),message));
		}

		return jsonString;
	}
	
	@RequestMapping(value = "/doSelectOne.do", method = RequestMethod.GET)
	public String doSelectOne(BusiNumVO inVO, Model model)throws SQLException{
		
		
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│inVO = "+inVO);
		LOG.debug("└──────────────────────────────┘");
		
		
		WishVO outVO = wishService.doSelectOne(inVO);
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│outVO = "+outVO);
		LOG.debug("└──────────────────────────────┘");
		model.addAttribute("vo", outVO);
		return "wish_mod";
		
	}
	
	@RequestMapping(value = "/doDelete.do",method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(WishVO inVO, AccountVO inVOA) throws SQLException {
		String jsonString = "";
		
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│inVO = "+inVO);
		int flag = wishService.doDelete(inVO, inVOA);
		
		LOG.debug("│flag = "+flag);
		
		String message = "";
		if(flag == 1) {
			message = "삭제 되었습니다.";
		}else {
			message = "삭제 실패";
		}
		
		jsonString = new Gson().toJson(new MessageVO(String.valueOf(flag), message));
		
		LOG.debug("│jsonString = "+jsonString);
		LOG.debug("└──────────────────────────────┘");
		
		return jsonString;
		
	}
	
	@RequestMapping(value = "/doUpdate.do", method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUpdate(WishVO inVO, AccountVO inVOA)throws SQLException{
		String jsonString = "";
		
		if(null != inVO && inVO.getContractPeriodS()==null) {
			inVO.setContractPeriodS(StringUtil.nvl(inVO.getContractPeriodS()));
		}	
		
		if(null != inVO && null == inVO.getContractPeriodE()) {
			inVO.setContractPeriodE(StringUtil.nvl(inVO.getContractPeriodE()));
		}
		if(null != inVO && inVO.getRegiInfoDate()==null) {
			inVO.setRegiInfoDate(StringUtil.nvl(inVO.getRegiInfoDate()));
		}	
		
		if(null != inVO && null == inVO.getModiInfoDate()) {
			inVO.setModiInfoDate(StringUtil.nvl(inVO.getModiInfoDate()));
		}
		if(null != inVO && null == inVO.getCountry()) {
			inVO.setCountry(StringUtil.nvl(inVO.getCountry()));
		}
		
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│inVO = "+inVO);
		LOG.debug("└──────────────────────────────┘");
		
		int flag = wishService.doUpdate(inVO, inVOA);
		LOG.debug("┌──────────────────────────────┐");
		LOG.debug("│flag = "+flag);
		
		String message = "";
		
		if(1==flag) {
			message = "수정 되었습니다.";
		}else {
			message = "수정 실패.";
			
		}
		
		jsonString = new Gson().toJson(new MessageVO(flag+"", message));
		LOG.debug("│jsonString = "+jsonString);
		LOG.debug("└──────────────────────────────┘");
		
		return jsonString;
		
	}
	
}
