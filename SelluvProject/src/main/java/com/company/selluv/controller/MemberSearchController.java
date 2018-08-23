package com.company.selluv.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.service.MemberService;

@Controller
public class MemberSearchController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/memberSearch.do", method=RequestMethod.POST)
	@ResponseBody
	public void memberSearch(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
			String data=request.getParameter("data");
			if((memberService.memberSearch(data, 1)==null)) {
				response.getWriter().write("error");
				return;
			}
			MemberDTO member=memberService.memberSearch(data, 1);
			response.getWriter().write(member.getMemberId());
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}
