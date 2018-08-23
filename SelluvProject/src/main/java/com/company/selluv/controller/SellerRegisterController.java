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
	
	@ResponseBody
	@RequestMapping(value="/sellerRegister.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public JSONObject sellerRegister(HttpSession session, @RequestParam("sellerRegisterNum")String wrkrRegNo, @RequestParam("repName")String repName) {
		String memberId = (String)session.getAttribute("memberId");
		JSONObject result = new JSONObject();
		
		
		MemberDTO memberDTO=service.memberSearch(memberId, 0);
    	if(!memberDTO.getName().equals(repName)){
    		logger.info("error : 회원의 실명과 일치 x");
    		
    		result.put("error", "1");
    		result.put("errorMsg", "회원의 실명과 일치하지 않습니다.");     
    		
    		return result;
    	}
    	
    	String repNm = service.memberRegistSeller(wrkrRegNo, repName);
		
        if(wrkrRegNo!=null&&repNm!=null&&repNm.equals(repName)){
        	logger.info("");
        	memberDTO.setLevelCode("SL");
        	service.memberUpdate(memberDTO);
        	result.put("repNm", repNm);
        }
        else{
        	result.put("error", "2");
        	result.put("errorMsg", "유효하지 않는 사업자 번호입니다.");
        }
		return result;
	}
}
