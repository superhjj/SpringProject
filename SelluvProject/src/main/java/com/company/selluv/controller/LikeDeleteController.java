package com.company.selluv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.service.LikeService;

@RestController
public class LikeDeleteController {

	@Autowired
	LikeService likeService;
	
	@RequestMapping(value="likeDelete.do", method=RequestMethod.GET)
	public String likeDelete(@RequestParam("memberId") String memberId, @RequestParam("contentsCode") String contentCode) {
		boolean res = likeService.likeDelete(memberId, contentCode);
		if(res) {
			return "{\"flag\":\"n\"}";
		}
		return null;
	}
	
}
