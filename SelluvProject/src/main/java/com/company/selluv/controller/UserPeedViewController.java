package com.company.selluv.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

@Controller
public class UserPeedViewController {
	
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
	
//	@RequestMapping(value="/userPeedView.do", method=RequestMethod.GET)
//	public String userPeedView(HttpServletRequest request, @RequestParam("id") String id
//			,@RequestParam("followerId") String followerId, Model model){
//		String memberId;
//		
//		if(request.getAttribute("id")==null) {
//			memberId=id;
//		}else {
//			memberId=(String)request.getAttribute("id");
//		}
//		//String followerId=(String)session.getAttribute("memberId");
//		List<ContentDTO> contents = contentService.contentByMemberIdSearch(memberId);
//		if(contents==null||contents.size()==0)
//			model.addAttribute("contentsCount", 0);
//		model.addAttribute("contents", contents);
//		model.addAttribute("id", memberId);
//		
//		MemberPeedViewVO mpv=memberPeedViewService.memberPeedViewSearch(memberId);
//		model.addAttribute("memberInfo", mpv);
//		MemberPeedContentsCntView mpv1=memberPeedContentsCnt.memberPeedViewSearch(memberId);
//		model.addAttribute("contentsCnt", mpv1);
//		MemberPeedFollowerViewVO mpv2=memberPeedFollowerView.followerViewSearch(memberId);
//		model.addAttribute("followerCnt", mpv2);
//		MemberPeedFollowViewVO mpv3=memberPeedFollowView.followViewSearch(memberId);
//		model.addAttribute("followCnt", mpv3);
//		
//		FollowVO followVO=null;
//		followVO=isFollow.followIsSearch(memberId, followerId);
//		if(followVO==null) {
//			model.addAttribute("isFollow", "N");
//		}else {
//			model.addAttribute("isFollow", "Y");
//		}
//		
//		return "/userpeed";
//	}
	
	@RequestMapping(value="/userPeedView.do", method=RequestMethod.GET)
	public String userPeedView(HttpServletRequest request, @RequestParam("id") String id
			,HttpSession session, Model model){
		String memberId;
		
		if(request.getAttribute("id")==null) {
			memberId=id;
		}else {
			memberId=(String)request.getAttribute("id");
		}
		String followerId=(String)session.getAttribute("memberId");
		List<ContentDTO> contents = contentService.contentByMemberIdSearch(memberId);
		if(contents==null||contents.size()==0)
			model.addAttribute("contentsCount", 0);
		model.addAttribute("contents", contents);
		model.addAttribute("id", memberId);
		
		MemberPeedViewVO mpv=memberPeedViewService.memberPeedViewSearch(memberId);
		model.addAttribute("memberInfo", mpv);
		MemberPeedContentsCntView mpv1=memberPeedContentsCnt.memberPeedViewSearch(memberId);
		model.addAttribute("contentsCnt", mpv1);
		MemberPeedFollowerViewVO mpv2=memberPeedFollowerView.followerViewSearch(memberId);
		model.addAttribute("followerCnt", mpv2);
		MemberPeedFollowViewVO mpv3=memberPeedFollowView.followViewSearch(memberId);
		model.addAttribute("followCnt", mpv3);
		
		FollowVO followVO=null;
		followVO=isFollow.followIsSearch(memberId, followerId);
		if(followVO==null) {
			model.addAttribute("isFollow", "N");
		}else {
			model.addAttribute("isFollow", "Y");
		}
		
		return "/userpeed";
	}
}
