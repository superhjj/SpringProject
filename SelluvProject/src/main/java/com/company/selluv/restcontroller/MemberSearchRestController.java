package com.company.selluv.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.service.MemberService;

@RestController
public class MemberSearchRestController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/m.memberSearch/{memberId}", method= { RequestMethod.GET, RequestMethod.POST })
	public MemberDTO memberSearch(@PathVariable String memberId) {
		MemberDTO result = memberService.memberSearch(memberId, 1);
		
		return result;
	}
}
