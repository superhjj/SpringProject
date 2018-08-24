package com.company.selluv.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.selluv.service.CommentService;

@Controller
public class CommentDeleteRestController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/m.commentDelete", method=RequestMethod.POST)
	public String commentDelete(@RequestParam("commentCode") String commentCode, @RequestParam("memberId") String memberId, @RequestParam("writer") String writer, @RequestParam("contentCode") String contentCode, HttpSession session) {
		String level = "AD";
		String member_id = (String) session.getAttribute("memberId");
		String member_lvl = (String) session.getAttribute("levelCode");
		
		if(memberId.equals(member_id) || level.equals(member_lvl)) {
			commentService.commentDelete(memberId, commentCode);
		}
		
		commentService.commentDelete(memberId, commentCode);
		
		return "redirect:/m.detailContents?idNum="+ writer + "&contentNum=" + contentCode;
	}
	
}
