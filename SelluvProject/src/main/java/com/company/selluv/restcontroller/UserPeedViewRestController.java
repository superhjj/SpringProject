package com.company.selluv.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.domain.vo.FollowVO;
import com.company.selluv.domain.vo.MemberPeedContentsCntView;
import com.company.selluv.domain.vo.MemberPeedFollowViewVO;
import com.company.selluv.domain.vo.MemberPeedFollowerViewVO;
import com.company.selluv.domain.vo.MemberPeedViewVO;
import com.company.selluv.service.ContentService;
import com.company.selluv.service.IsFollowService;
import com.company.selluv.service.MemberPeedContentsCntService;
import com.company.selluv.service.MemberPeedFollowViewService;
import com.company.selluv.service.MemberPeedFollowerViewService;
import com.company.selluv.service.MemberPeedViewService;

@RestController
public class UserPeedViewRestController {

	@Autowired
	ContentService contentService;
	@Autowired
	MemberPeedViewService memberPeedViewService;
	@Autowired
	MemberPeedContentsCntService memberPeedContentsCnt;
	@Autowired
	MemberPeedFollowViewService memberPeedFollowView;
	@Autowired
	MemberPeedFollowerViewService memberPeedFollowerView;
	@Autowired
	IsFollowService isFollow;

	@RequestMapping(value = "/m.userPeedView", method = RequestMethod.GET)
	public JSONObject userPeedView(HttpServletRequest request, @RequestParam("id") String id, HttpSession session) {
		JSONObject jsonObject = new JSONObject();

		String memberId;

		if (request.getAttribute("id") == null) {
			memberId = id;
		} else {
			memberId = (String)request.getAttribute("id");
		}
		
		String followerId = (String)session.getAttribute("memberId");
		
		List<ContentDTO> contents = contentService.contentByMemberIdSearch(memberId);
		
		if (contents == null || contents.size() == 0) {
			jsonObject.put("contentsCount", 0);
		}
		
		jsonObject.put("contents", contents);
		jsonObject.put("id", memberId);
		
		MemberPeedViewVO mpv = memberPeedViewService.memberPeedViewSearch(memberId);
		jsonObject.put("memberInfo", mpv);
		MemberPeedContentsCntView mpv1 = memberPeedContentsCnt.memberPeedViewSearch(memberId);
		jsonObject.put("contentsCnt", mpv1);
		MemberPeedFollowerViewVO mpv2 = memberPeedFollowerView.followerViewSearch(memberId);
		jsonObject.put("followerCnt", mpv2);
		MemberPeedFollowViewVO mpv3 = memberPeedFollowView.followViewSearch(memberId);
		jsonObject.put("followCnt", mpv3);

		FollowVO followVO = null;
		followVO = isFollow.followIsSearch(memberId, followerId);
		jsonObject.put("followVO", followVO);
		
		if (followVO == null) {
			jsonObject.put("isFollow", "N");
		} else {
			jsonObject.put("isFollow", "Y");
		}
		
		return jsonObject;
	}
}
