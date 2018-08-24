package com.company.selluv.controller;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.service.MemberService;

@Controller
public class SellerRegisterController {
	public static final Logger logger = LoggerFactory.getLogger(SellerRegisterController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/sellerRegister.do", method=RequestMethod.GET)
	public String sellerRegisterGET() {
		return "businessRegister";
	}
	
	@ResponseBody
	@RequestMapping(value="/sellerRegister.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public JSONObject sellerRegister(HttpSession session, @RequestParam("sellerRegisterNum")String wrkrRegNo, @RequestParam("repName")String repName) {
		String memberId = (String)session.getAttribute("memberId");
		JSONObject result = new JSONObject();
		
		logger.info(repName);
		logger.info(wrkrRegNo);
		
		MemberDTO memberDTO=service.memberSearch(memberId, 0);
    	if(!memberDTO.getName().equals(repName)){
    		logger.info("error : 이름 에러");
    		
    		result.put("error", "1");
    		result.put("errorMsg", "ȸ���� �Ǹ�� ��ġ���� �ʽ��ϴ�.");     
    		
    		return result;
    	}
    	
    	String repNm = service.memberRegistSeller(wrkrRegNo, repName);
    	logger.info(repNm);
		
        if(wrkrRegNo!=null&&repNm!=null&&repNm.equals(repName)){
        	logger.info("성공");
        	memberDTO.setLevelCode("SL");
        	service.memberUpdate(memberDTO);
        	result.put("repNm", repNm);
        }
        else{
        	result.put("error", "2");
        	result.put("errorMsg", "��ȿ���� �ʴ� ����� ��ȣ�Դϴ�.");
        }
		return result;
	}
}
