package com.company.selluv.restcontroller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.vo.FollowVO;
import com.company.selluv.service.FollowService;
import com.company.selluv.service.IsFollowService;

@RestController
public class FollowDeleteRestController {

	private static final Logger logger = LoggerFactory.getLogger(FollowDeleteRestController.class);

	@Autowired
	private FollowService followService;

	@Autowired
	private IsFollowService isFollowService;

	@RequestMapping(value = "/m.followDelete", method = RequestMethod.GET)
	public FollowVO followDelete(@RequestParam("followId") String followId, HttpSession session) {
		String followerId = (String)session.getAttribute("memberId");
		logger.info(followerId);
		FollowVO followVO = isFollowService.followIsSearch(followerId, followId);
		System.out.println(followVO);

		if (followService.followDelete(followId, followerId)) {
			logger.info("RestController followDelete get method called...");

			return followVO;
		} else {
			logger.info("error");
		}

		return null;
	}
}
