package com.company.selluv.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.selluv.service.FollowService;


@Controller	
public class FollowInsertController {
	private static final Logger logger = LoggerFactory.getLogger(FollowInsertController.class); 
	
	@Autowired
	private FollowService followService;
	
	
//	@RequestMapping(value="/followInsert", method=RequestMethod.POST)
//	public String followInsert(@RequestParam("followId") String followId,@RequestParam("memberId") String followerId) {
//
//		if(followService.followAdd(followId, followerId)) {
//			logger.info("ÆÈ·Î¿ì ¼º°ø");
//			return "/userpeed";
//		}
//		else {
//			logger.info("ÆÈ·Î¿ì ½ÇÆÐ");
//		}
//		
//		return null;
//	}
	
	
	@RequestMapping(value="/followInsert.do", method=RequestMethod.GET)
	public String followInsert(@RequestParam("followId") String followId, HttpSession session) {
		String followerId=(String)session.getAttribute("memberId");
		
		if(followService.followAdd(followId, followerId)) {
			logger.info("ÆÈ·Î¿ì ¼º°ø");
			
			return "/userpeed";
		}
		else {
			logger.info("ÆÈ·Î¿ì ½ÇÆÐ");
		}
		
		return null;
	}
}
