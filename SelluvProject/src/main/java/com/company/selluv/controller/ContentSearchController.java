package com.company.selluv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.service.ContentService;

@Controller
public class ContentSearchController {
	
	@Autowired
	ContentService contentService;
	
	@RequestMapping(value="/contentsSearch.do", method=RequestMethod.POST)
	public String contentSearch(@RequestParam("job") String job, @RequestParam("memberId") String memberId, RedirectAttributes redirectAttributes) {
		//RedirectAttributes redirectAttributes
		
		List<ContentDTO> contents = contentService.contentByMemberIdSearch(memberId);
		if(job.equals("searchContentList")) {
			
			redirectAttributes.addAttribute("contents", contents);
			redirectAttributes.addAttribute("id", memberId);
			
			return "redirect:/userPeedView.do?id="+memberId;
			
		}
		return null;
		
	}
	
}
