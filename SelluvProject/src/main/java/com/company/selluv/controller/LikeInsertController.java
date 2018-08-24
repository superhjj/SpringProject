package com.company.selluv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.dto.LikeDTO;
import com.company.selluv.service.LikeService;

@RestController
public class LikeInsertController {
	
	@Autowired
	LikeService likeService;
	
	@RequestMapping(value="likeInsert.do", method=RequestMethod.GET)
	public String likeInsert(@RequestParam("memberId") String memberId, @RequestParam("contentsCode") String contentCode) {
		boolean res = likeService.likeAdd(memberId, contentCode);
		if(res) {
			return "{\"flag\":\"y\"}";
		}
		return null;
	}
	
}
