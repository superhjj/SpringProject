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
	   public String login(@RequestParam("id")String memberID,@RequestParam("pwd")String memberPwd
	         ,Model model,HttpSession session, RedirectAttributes redirect) {
	      if(session.getAttribute("memberId")!=null){
	         /*HttpUtil.forward(request, response, "/mainPeedView.do");*/
	         logger.info("로그인 상태");
	         return "redirect:/mainPeedView.do";
	      }
	      
	      String path = null;
	      if(session.isNew() || session.getAttribute("memberId") == null){
	         /*memberDao.searchMember(memberID, memberPwd)*/   
	         MemberDTO dto = service.memberSearch(memberID, memberPwd);
	         if(dto != null){
	               logger.info("로그인 성공 : "+memberID);
	               session.setAttribute("memberId", memberID);
	               session.setAttribute("levelCode", dto.getLevelCode());
	               redirect.addAttribute("memberId", memberID);
	               path="redirect:/mainPeedView.do";
	            }
	            else{
	               logger.info("로그인 실패");
	               JSONObject json=new JSONObject();
	               json.put("error", "아이디와 비밀번호를 확인하여 주십시오.");
	              // model.addAttribute("error", "아이디와 비밀번호를 확인하여 주십시오.");
	               path="redirect:/login";
	            }
	      }
	      return path;
	   }
}
