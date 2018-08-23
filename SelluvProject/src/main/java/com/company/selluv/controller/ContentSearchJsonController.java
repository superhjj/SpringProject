package com.company.selluv.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.service.ContentService;

@RestController
public class ContentSearchJsonController {

	@Autowired
	ContentService contentService;
	
	@ResponseBody
	@RequestMapping(value="contentSearchJson.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public List<JSONObject> contentJsonSearch(@RequestParam("id") String memberId) {
		
		List<ContentDTO> contents = contentService.contentByMemberIdSearch(memberId);
		//JSONArray jAry = new JSONArray();
		List<JSONObject> jAry = new ArrayList<JSONObject>();
		
		for(ContentDTO content: contents) {
			JSONObject obj = new JSONObject();
			obj.put("contents_img", content.getContentImg());
			obj.put("contents_code", content.getContentCode());
			obj.put("id", memberId);
			jAry.add(obj);
		}
		
		return jAry;
	}
	
}
