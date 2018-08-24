package com.company.selluv.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.service.ContentService;

@RestController
public class ContentDeleteRestController {

	@Autowired
	ContentService contentsService;
	
	@RequestMapping(value="/m.contentDelete", method=RequestMethod.GET)
	public void contentDelete(HttpSession session, @RequestParam("memberId") String memberId, @RequestParam("contentCode") String contentCode) {
		String sessionId=(String)session.getAttribute("memberId");
		String levelCode=(String)session.getAttribute("levelCode");
		//관리자이면
		if(levelCode.equals("AD")) {
			contentsService.contentDelete(contentCode, memberId);
		}
		//관리자가 아니면
		else {
			if(sessionId.equals(memberId)) {
				contentsService.contentDelete(contentCode, memberId);
			}
		}
	}
	
}
