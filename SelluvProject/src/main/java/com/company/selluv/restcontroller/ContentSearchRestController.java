package com.company.selluv.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.service.ContentService;

@Controller
public class ContentSearchRestController {

	@Autowired
	ContentService service;
	
	@RequestMapping(value="/m.contentSearch", method=RequestMethod.POST)
	public String contentSearch(@RequestParam("job") String job, @RequestParam("memberId") String memberId, RedirectAttributes redirectAttributes) {
		
		List<ContentDTO> contentList = service.contentByMemberIdSearch(memberId);
		if(job.equals("searchContentList")) {
			
			redirectAttributes.addAttribute("contents", contentList.toString());
			redirectAttributes.addAttribute("id", memberId);
			
			return "redirect:/m.userPeedView?id="+memberId;
			
		}
		return null;
		
	}
	
}
