package com.company.selluv.restcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.service.MemberService;

@RestController
public class SellerRegisterRestController {

	@Autowired
	MemberService service;
	
	@RequestMapping(value="/m.sellerRegister", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public Map<String, String> sellerRegister(HttpSession session, @RequestParam("sellerRegisterNum")String wrkrRegNo, @RequestParam("repName")String repName) {
		
		String memberId = (String)session.getAttribute("memberId");
		Map<String, String> result = new HashMap<String, String>();
		
		MemberDTO memberDTO=service.memberSearch(memberId, 0);
		if(!memberDTO.getName().equals(repName)){
			result.put("error", "1");
			result.put("errorMsg", "회원의 실명과 일치하지 않습니다.");
			
			return result;
		}
		
		String repNm = service.memberRegistSeller(wrkrRegNo, repName);
		
		if(wrkrRegNo!=null&&repNm!=null&&repNm.equals(repName)){
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
