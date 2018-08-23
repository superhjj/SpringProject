package com.company.selluv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.selluv.domain.dto.CommentDTO;
import com.company.selluv.service.CommentService;

@Controller
public class CommentController {
	private Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentService commentService;
	
	@ResponseBody
	@RequestMapping(value="/commentSearch.do", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public List<JSONObject> commentSearchByContents(@RequestParam("contentCode") String contentCode, HttpServletResponse res, Model model) {
		List<CommentDTO> commentlist = commentService.commentSearchByContents(contentCode);
		List<JSONObject> resultlist = new ArrayList<JSONObject>();
		
 		logger.info("CommentController -> commentSearch.do");
 		
		for(int elem = 0; elem < commentlist.size(); elem++) {
			JSONObject obj = new JSONObject();
			obj.put("memberId", commentlist.get(elem).getMemberId());
			obj.put("commentText", commentlist.get(elem).getCommentText());
			obj.put("commentCode", commentlist.get(elem).getCommentCode());
			
			resultlist.add(obj);
		}
		
		return resultlist;
	}
	
	@ResponseBody
	@RequestMapping(value="/commentInsert.do", method=RequestMethod.POST)
	public JSONObject commentInsert(@RequestParam("memberId") String memberId, @RequestParam("commentText") String inputComment, @RequestParam("contentCode") String contentCode, HttpSession session) {
		CommentDTO add = commentService.commentInsert(memberId, inputComment, contentCode);
		JSONObject result = new JSONObject();
		
		result.put("memberId", memberId);
		result.put("commentText", inputComment);
		result.put("commentCode", add.getCommentCode());
		
		return result;
	}
	
	@RequestMapping(value="/commentDelete.do", method=RequestMethod.POST)
	public String commentDelete(@RequestParam("commentCode") String commentCode, @RequestParam("memberId") String memberId, @RequestParam("writer") String writer, @RequestParam("contentCode") String contentCode, HttpSession session) {
		logger.info("CommentController -> commentDelete.do");
		
		String level = "AD";
		String member_id = (String) session.getAttribute("memberId");
		String member_lvl = (String) session.getAttribute("levelCode");
		
		if(memberId.equals(member_id) || level.equals(member_lvl)) {
			commentService.commentDelete(memberId, commentCode);
		}
		
		/*
		 * 테스트용 코드이므로 지워야 함
		 */
		commentService.commentDelete(memberId, commentCode);
		
		return "redirect:/detailContents.do?idNum="+ writer + "&contentNum=" + contentCode;
	}
}
