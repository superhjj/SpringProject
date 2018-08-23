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

import com.company.selluv.domain.vo.FollowViewVO;
import com.company.selluv.service.FollowerViewService;

@Controller
public class FollowerViewSearchController {
	private static final Logger logger = LoggerFactory.getLogger(FollowerViewSearchController.class);
	
	@Autowired
	FollowerViewService followerViewService;
	
	@RequestMapping(value = "/followerViewSearch.do", method = RequestMethod.GET)
	public String followerSearchGet(@RequestParam("memberId")String memberId, Model model) {
		logger.info("FollowerView get method called....");
		List<FollowViewVO> followerList = followerViewService.followerViewSearch(memberId);
		model.addAttribute("followerList", followerList);
		return "/follower";
	}
	
	@RequestMapping(value = "/followerViewSearch.do",method=RequestMethod.POST)
	public String followerSearch(@RequestParam("memberId")String memberId, Model model) {
		try {
			logger.info("FollowerView post method called....");
			List<FollowViewVO> followerList = followerViewService.followerViewSearch(memberId);
			model.addAttribute("followerList", followerList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/follower";
	}
	
}
