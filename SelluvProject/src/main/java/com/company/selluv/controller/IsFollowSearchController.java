package com.company.selluv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.domain.vo.FollowVO;
import com.company.selluv.service.IsFollowService;

@Controller
public class IsFollowSearchController {
	private static final Logger logger = LoggerFactory.getLogger(IsFollowSearchController.class);
	
	@Autowired
	IsFollowService isFollowService;
	
	@RequestMapping(value = "/followSearch.do", method = RequestMethod.GET)
	public String isFollowSearchGet(@RequestParam("followId")String followId,@RequestParam("followerId")String followerId, Model model) {
		logger.info("IsFollow get method called....");
		FollowVO followVO = isFollowService.followIsSearch(followId,followerId);
		model.addAttribute("followVO", followVO);
		return "/follow";
	}
	
	@RequestMapping(value = "/followSearch.do", method = RequestMethod.POST)
	public String isFollowSearch(@RequestParam("followId")String followId,@RequestParam("followerId")String followerId, Model model) {
		try {
			logger.info("IsFollow post method called....");
			FollowVO followVO = isFollowService.followIsSearch(followId,followerId);
			model.addAttribute("followVO", followVO);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/follow";
	}
	
}
