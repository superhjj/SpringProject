package com.company.selluv.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.dto.CommentDTO;
import com.company.selluv.service.CommentService;

@RestController
public class CommentSearchRestController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/m.commentSearch/{contentCode}", method={ RequestMethod.GET, RequestMethod.POST })
	public List<CommentDTO> commentSearchByContents(@PathVariable String contentCode){
		List<CommentDTO> list = commentService.commentSearchByContents(contentCode);
		
		return list;
	}
}
