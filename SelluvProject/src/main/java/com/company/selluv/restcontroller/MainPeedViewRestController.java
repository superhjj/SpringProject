package com.company.selluv.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.domain.vo.MainPeedViewVO;
import com.company.selluv.service.FollowService;
import com.company.selluv.service.MainPeedViewService;

@RestController
public class MainPeedViewRestController {
	private Logger logger = LoggerFactory.getLogger(MainPeedViewRestController.class);
	
	@Autowired
	FollowService followService;
	
	@Autowired
	MainPeedViewService mainPeedViewService;
	
	@RequestMapping(value="/m.mainPeedView/{memberId}", method=RequestMethod.GET)
	public Map<String, List<MainPeedViewVO>> mainPeedView(@PathVariable String memberId){
		List<MemberDTO> followList = null;
		Map<String, List<MainPeedViewVO>> mainPeedViewList = new HashMap<String, List<MainPeedViewVO>>();
		
		followList=followService.followSearch(memberId);
		
		if(followList == null) {
			logger.info("MainPeed : followList null");
		}
		
		if(followList != null) {
			for(int i = 0; i < followList.size(); i++) {
				mainPeedViewList.put(followList.get(i).getMemberId(), mainPeedViewService.mainPeedViewSearch(followList.get(i).getMemberId()));
			}
		}
		
		return mainPeedViewList;
	}
}
