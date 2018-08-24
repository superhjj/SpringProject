package com.company.selluv.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.selluv.service.LikeService;

@Controller
public class LikeSearchRestController {

	@Autowired
	LikeService likeService;
	
	@RequestMapping(value="/m.likeSearch", method=RequestMethod.POST)
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
