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
public class FindPwdRestController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/m.findPwd", method=RequestMethod.GET)
	public Map<String, String> findPwd(@RequestParam("memberId") String memberId, @RequestParam("mail") String mail) {
		Map<String, String> result = new HashMap<String, String>();
		String findPwd = service.memberPwdSearch(memberId, mail);
		
		if(findPwd != null) {
			result.put("findPwd", "회원님의 비밀번호는 " + findPwd + " 입니다.");
		}
		else {
			result.put("findPwd", "회원님의 비밀번호를 찾을 수 없습니다.");
		}
		
		return result;
	}
}
