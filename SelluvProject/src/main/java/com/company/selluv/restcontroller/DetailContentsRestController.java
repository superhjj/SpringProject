package com.company.selluv.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.vo.ContentsDetailViewVO;
import com.company.selluv.service.ContentsDetailViewService;

@RestController
public class DetailContentsRestController {
	@Autowired
	ContentsDetailViewService contentsDetailService;
	
	@RequestMapping(value="m.detailContents/{memberId}/{contentCode}", method= { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> contentsDetailViewSearch(@PathVariable String memberId, @PathVariable String contentCode) {
		ContentsDetailViewVO detailContent = contentsDetailService.contentsDetailViewSearch(memberId, contentCode);
		String text = detailContent.getContentsText();
		Map<String, Object> result = new HashMap<String, Object>();
		
		StringTokenizer token = new StringTokenizer(text, "#");
		List<String> hashtag = new ArrayList<String>();
		
		if(token.hasMoreTokens()) {
			while(token.hasMoreTokens()) {
				String next = token.nextToken();
				hashtag.add(next);
			}
		}
		
		String newText = hashtag.get(0);
		detailContent.setContentsText(newText);
		
		hashtag.remove(0);
		
		if(hashtag.size() != 0) {
			result.put("hashtag", hashtag);
		}
		
		result.put("detailContent", detailContent);
		
		return result;
	}
}
