package com.company.selluv.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.service.MemberService;

@RestController
public class FindIdRestController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/m.findId", method= { RequestMethod.GET, RequestMethod.POST })
	public Map<String, String> findId(@RequestParam("mail") String mail) {
		String result = service.memberIdSearch(mail);
		Map<String, String> findIdResult = new HashMap<String, String>();
		
		if(result != null) {
			findIdResult.put("findId", "회원님의 아이디는 " + result + "입니다.");
		}
		else {
			findIdResult.put("findId", "회원님의 아이디를 찾을 수 없습니다.");
		}
		
		return findIdResult;
	}
}
