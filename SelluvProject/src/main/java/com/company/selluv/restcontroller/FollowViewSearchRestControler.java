package com.company.selluv.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.vo.FollowViewVO;
import com.company.selluv.service.FollowViewService;

@RestController
public class FollowViewSearchRestControler {
	
	private static final Logger logger = LoggerFactory.getLogger(FollowViewSearchRestControler.class);
	
	@Autowired
	FollowViewService followViewService;
	
	@RequestMapping(value = "/m.followViewSearch", method = RequestMethod.GET)
	public List<FollowViewVO> followSearchGet(@RequestParam("followerId")String followerId) {
		logger.info("FollowViewSearch RestController get method called....");
		List<FollowViewVO> followList = followViewService.followViewSearch(followerId);
	
		return followList;
	}
}