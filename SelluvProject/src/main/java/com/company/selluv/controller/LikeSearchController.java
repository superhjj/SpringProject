package com.company.selluv.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.selluv.service.LikeService;

@Controller
public class LikeSearchController {
	
	@Autowired
	LikeService likeService;
	
	@RequestMapping(value="/likeSearch.do", method=RequestMethod.POST)
	public String likeSearch(@RequestParam("job") String job, @RequestParam("contentsCode") String contentCode, RedirectAttributes redirectAttributes, HttpSession session) {
		
		String memberId = (String) session.getAttribute("memberId");
		
		if(job.equals("likeSearch")) {
			String res = likeService.likeCodeSearch(memberId, contentCode);
			
			redirectAttributes.addAttribute("memberId", memberId);
			redirectAttributes.addAttribute("contentsCode", contentCode);
			
			if(res == null) {
				return "redirect:/likeInsert.do";
			}
			else {
				return "redirect:/likeDelete.do";
			}
		}
		return null;
	}
	
}
