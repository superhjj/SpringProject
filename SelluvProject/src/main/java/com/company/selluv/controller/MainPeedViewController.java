package com.company.selluv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.domain.vo.MainPeedViewVO;
import com.company.selluv.service.FollowService;
import com.company.selluv.service.MainPeedViewService;

@Controller
public class MainPeedViewController {
	private static final Logger logger = LoggerFactory.getLogger(FollowInsertController.class);
	
	@Autowired
	FollowService followService;
	@Autowired
	MainPeedViewService mainPeedViewService;
	
	@RequestMapping(value="/mainPeedView", method=RequestMethod.GET)
	public String mainPeedView(@RequestParam("memberId") String memberId, Model model) {
		List<MemberDTO> followList=null;
		Map<String,List<MainPeedViewVO>> mainPeedViewList=new HashMap<String,List<MainPeedViewVO>>();
		
		followList=followService.followSearch(memberId);
		if(followList==null) {
			logger.info("MainPeed: followList null");
		}
		
		if(followList!=null){
			for(int i=0;i<followList.size();i++){
				 mainPeedViewList.put(followList.get(i).getMemberId(),
						 mainPeedViewService.mainPeedViewSearch(followList.get(i).getMemberId()));
			}
		}
		model.addAttribute("mainpeeds", mainPeedViewList);
		return "/mainpeed";
	}
	
//	@RequestMapping(value="/mainPeedView.do", method=RequestMethod.GET)
//	public String mainPeedView(HttpSession session, Model model) {
//		List<MemberDTO> followList=null;
//		Map<String,List<MainPeedViewVO>> mainPeedViewList=new HashMap<String,List<MainPeedViewVO>>();
//		String memberId=(String)session.getAttribute("memberId");
//		
//		followList=followService.followSearch(memberId);
//		if(followList==null) {
//			logger.info("MainPeed: followList null");
//		}
//		
//		if(followList!=null){
//			for(int i=0;i<followList.size();i++){
//				 mainPeedViewList.put(followList.get(i).getMemberId(),
//						 mainPeedViewService.mainPeedViewSearch(followList.get(i).getMemberId()));
//						
//			}
//		}
//		return "/mainpeed";
//	}
}
