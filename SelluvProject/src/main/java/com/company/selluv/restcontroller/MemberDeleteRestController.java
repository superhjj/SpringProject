package com.company.selluv.restcontroller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.controller.MemberDeleteController;
import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.service.MemberService;

@RestController
public class MemberDeleteRestController {
public static final Logger logger= LoggerFactory.getLogger(MemberDeleteController.class);
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="m.memberDelete", method=RequestMethod.POST)
	public String memberDelete(HttpSession session, @RequestParam("id")String memberId,@RequestParam("pwd")String pwd, Model model) {
		String sessionId = (String) session.getAttribute("memberId");
		
		MemberDTO sessionDTO = service.memberSearch(sessionId, 1);
		MemberDTO memberDTO = service.memberSearch(memberId, pwd);
		
		String path=null;
		if(sessionDTO == null) {
			logger.info("비로그인 상태");	
			path="";//?????????????
			return "{\"message\":\"로그인 먼저 하세요\"}";
		}
		
		if(memberDTO == null && !sessionDTO.getLevelCode().equals("AD")){
			logger.info("비밀번호 일치하지 않음");
			model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
			path="";//?????????????
			return "{\"message\":\"비밀번호가 일치하지 않습니다.\"}";
		}
		
		service.memberDelete(memberId, pwd);
		if(sessionDTO.getLevelCode().equals("AD"))
		{
			path="{\"message\":\"해당 회원이 성공적으로 삭제되었습니다.\"}";
		}
		else if(memberDTO != null) {
			path="{\"message\":\"그동안 이용해주셔서 감사합니다.\"}";
		}
		return path;
		
	}
}
