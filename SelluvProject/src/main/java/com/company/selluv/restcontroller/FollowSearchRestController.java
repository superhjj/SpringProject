package com.company.selluv.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.vo.FollowVO;
import com.company.selluv.service.IsFollowService;

@RestController
public class FollowSearchRestController {

	private static final Logger logger = LoggerFactory.getLogger(FollowSearchRestController.class);

	@Autowired
	IsFollowService isFollowService;

	@RequestMapping(value = "/m.followSearch", method = RequestMethod.GET)
	public FollowVO isFollowSearchGet(@RequestParam("followId") String followId,
			@RequestParam("followerId") String followerId) {
		logger.info("Regisrer get method called....");
		FollowVO followVO = isFollowService.followIsSearch(followId, followerId);
		return followVO;
	}
}
