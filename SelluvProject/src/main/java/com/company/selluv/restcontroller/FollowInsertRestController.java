package com.company.selluv.restcontroller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.controller.FollowInsertController;
import com.company.selluv.domain.vo.FollowVO;
import com.company.selluv.service.FollowService;
import com.company.selluv.service.IsFollowService;

@RestController
public class FollowInsertRestController {

	private static final Logger logger = LoggerFactory.getLogger(FollowInsertRestController.class);

	@Autowired
	private FollowService followService;

	@Autowired
	private IsFollowService isFollowService;

	@RequestMapping(value = "/m.followInsert", method = RequestMethod.GET)
	public FollowVO followInsert(@RequestParam("followId") String followId, HttpSession session) {
		String followerId = (String)session.getAttribute("memberId");
		logger.info(followerId);
		
		followService.followSearch(followerId);
			
		if (followService.followAdd(followId, followerId)) {
			logger.info("dddd");

			FollowVO followVO = isFollowService.followIsSearch(followId, followerId);
			
			return followVO;

		} else {
			logger.info("mFollowInsert error");
		}

		return null;
	}
}
