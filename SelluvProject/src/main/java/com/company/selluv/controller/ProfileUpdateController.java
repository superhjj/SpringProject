package com.company.selluv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.selluv.domain.dto.ProfileDTO;
import com.company.selluv.service.ProfileService;

@Controller
public class ProfileUpdateController {

	@Autowired
	ProfileService profileService;

	private static final Logger logger = LoggerFactory.getLogger(ProfileUpdateController.class);

	@RequestMapping(value = "/profileUpdate.do", method = RequestMethod.GET)
	public String profileUpdateGet(@RequestParam("memberId") String memberId, Model model) {
		logger.info("profileUpdate get method called....");
		ProfileDTO profile = profileService.profileSearch(memberId);
		model.addAttribute("profile", profile);
		return "/profile";
	}
	
	@RequestMapping(value = "/profileUpdate.do", method = RequestMethod.POST)
	public String profileUpdate(@RequestParam("memberId") String memberId, Model model) {
		logger.info("profileUpdate post method called....");
		ProfileDTO profile = profileService.profileSearch(memberId);
		model.addAttribute("profile", profile);
		return "/profile";
	}

}
