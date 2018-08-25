package com.company.selluv.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.dto.CommentDTO;
import com.company.selluv.service.CommentService;

@RestController
public class CommentInsertRestController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/m.commentInsert/{memberId}/{contentCode}/{commentText}", method= {RequestMethod.GET, RequestMethod.POST})
	public CommentDTO commentInsert(@PathVariable String memberId, @PathVariable String commentText, @PathVariable String contentCode) {
		CommentDTO result = commentService.commentInsert(memberId, commentText, contentCode);
		
		return result;
	}
}