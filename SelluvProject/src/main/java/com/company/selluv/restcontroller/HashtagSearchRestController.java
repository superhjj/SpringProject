package com.company.selluv.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.controller.HashtagSearchController;
import com.company.selluv.domain.vo.HashtagSearchViewVO;
import com.company.selluv.domain.vo.MainPeedViewVO;
import com.company.selluv.service.HashtagSearchViewService;
import com.company.selluv.service.MainPeedViewService;

@RestController
public class HashtagSearchRestController {

	public static final Logger logger = LoggerFactory.getLogger(HashtagSearchController.class);
	
	@Autowired
	private HashtagSearchViewService hastagViewService;
	
	@Autowired
	private MainPeedViewService mainPeedViewService;
	
	@RequestMapping(value= "/m.searchHashtag", method = RequestMethod.GET)
	public JSONObject hashtagSearch(@RequestParam("hashtag")String hashtag)
	{
		JSONObject jsonObject = new JSONObject();
		List<HashtagSearchViewVO> hashtagList = hastagViewService.hashtagSearchViewSearch(hashtag);
		jsonObject.put("hashtagList", hashtagList);
		
		List<MainPeedViewVO> hashtagpeeds= new ArrayList<MainPeedViewVO>();
		jsonObject.put("hashtagpeeds", hashtagpeeds);
		for(HashtagSearchViewVO search : hashtagList){
			String contents_code = search.getContents_code();
			jsonObject.put("contents_code", contents_code);
			MainPeedViewVO mainPeedViewVO = mainPeedViewService.mainPeedViewByContentsCodeSearch(contents_code);
			jsonObject.put("mainPeedViewVO", mainPeedViewVO);
			hashtagpeeds.add(mainPeedViewVO);
		}
		
		return jsonObject;
	}
	
}
