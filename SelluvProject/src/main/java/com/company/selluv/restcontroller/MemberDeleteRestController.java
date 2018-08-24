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
			logger.info("��α��� ����");	
			path="";//?????????????
			return "{\"message\":\"�α��� ���� �ϼ���\"}";
		}
		
		if(memberDTO == null && !sessionDTO.getLevelCode().equals("AD")){
			logger.info("��й�ȣ ��ġ���� ����");
			model.addAttribute("error", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			path="";//?????????????
			return "{\"message\":\"��й�ȣ�� ��ġ���� �ʽ��ϴ�.\"}";
		}
		
		service.memberDelete(memberId, pwd);
		if(sessionDTO.getLevelCode().equals("AD"))
		{
			path="{\"message\":\"�ش� ȸ���� ���������� �����Ǿ����ϴ�.\"}";
		}
		else if(memberDTO != null) {
			path="{\"message\":\"�׵��� �̿����ּż� �����մϴ�.\"}";
		}
		return path;
		
	}
}
