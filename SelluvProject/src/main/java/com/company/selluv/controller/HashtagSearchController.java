package com.company.selluv.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.selluv.domain.vo.HashtagSearchViewVO;
import com.company.selluv.domain.vo.MainPeedViewVO;
import com.company.selluv.service.HashtagSearchViewService;
import com.company.selluv.service.MainPeedViewService;

@Controller
public class HashtagSearchController {

	public static final Logger logger = LoggerFactory.getLogger(HashtagSearchController.class);
	
	@Autowired
	private HashtagSearchViewService hastagViewService;
	
	@Autowired
	private MainPeedViewService mainPeedViewService;
	
	@RequestMapping("/searchHashtag.do")
	public String hashtagSearch(@RequestParam("hashtag")String hashtag, Model model)
	{
		List<HashtagSearchViewVO> hashtagList = hastagViewService.hashtagSearchViewSearch(hashtag);
		
		List<MainPeedViewVO> hashtagpeeds= new ArrayList<MainPeedViewVO>();
		for(HashtagSearchViewVO search : hashtagList){
			String contents_code = search.getContents_code();
			MainPeedViewVO mainPeedViewVO = mainPeedViewService.mainPeedViewByContentsCodeSearch(contents_code);
			hashtagpeeds.add(mainPeedViewVO);
		}
		
		model.addAttribute("hashtagpeeds", hashtagpeeds);
		
		return "mainpeed";
	}
	
}
