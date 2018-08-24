package com.company.selluv.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.vo.FollowViewVO;
import com.company.selluv.service.FollowerViewService;

@RestController
public class FollowerViewSearchRestControler {
	
	private static final Logger logger = LoggerFactory.getLogger(FollowerViewSearchRestControler.class);
	
	@Autowired
	FollowerViewService followerViewService;
	
	@RequestMapping(value = "/m.followerViewSearch", method = RequestMethod.GET)
	public List<FollowViewVO> followerSearchGet(@RequestParam("followId")String followId) {
		logger.info("FollowViewSearch RestController get method called....");
		List<FollowViewVO> followerList = followerViewService.followerViewSearch(followId);
	
		return followerList;
	}
}
