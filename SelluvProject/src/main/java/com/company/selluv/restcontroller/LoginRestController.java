package com.company.selluv.restcontroller;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.selluv.controller.LoginController;
import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.service.MemberService;

@RestController
public class LoginRestController {
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	   @Autowired
	   private MemberService service;

	   
	   @RequestMapping(value="/m.login", method=RequestMethod.POST)
	   public MemberDTO login(@RequestParam("id")String memberID,@RequestParam("pwd")String memberPwd, Model model,HttpSession session, RedirectAttributes redirect) {
		   MemberDTO member = service.memberSearch(memberID, memberPwd);
		   
		   return member;
	   }
}