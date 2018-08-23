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
import com.company.selluv.domain.vo.FollowViewVO;
import com.company.selluv.service.IsFollowService;
import com.company.selluv.service.FollowViewService;

@Controller
public class FollowViewSearchController {
	private static final Logger logger = LoggerFactory.getLogger(FollowViewSearchController.class);
	
	@Autowired
	FollowViewService followViewService;
	
	@RequestMapping(value = "/followViewSearch.do", method = RequestMethod.GET)
	public String followSearchGet(@RequestParam("followerId")String followerId, Model model) {
		logger.info("FollowView get method called....");
		List<FollowViewVO> followList = followViewService.followViewSearch(followerId);
		model.addAttribute("followList", followList);
		return "/follow";
	}
	
	@RequestMapping(value = "/followViewSearch.do",method=RequestMethod.POST)
	public String followSearch(@RequestParam("followerId")String followerId, Model model) {
		try {
			logger.info("FollowView post method called....");
			List<FollowViewVO> followList = followViewService.followViewSearch(followerId);
			model.addAttribute("followList", followList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/follow";
	}
	
}
