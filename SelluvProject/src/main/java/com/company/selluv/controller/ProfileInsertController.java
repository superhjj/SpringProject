package com.company.selluv.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.company.selluv.domain.dto.ProfileDTO;
import com.company.selluv.persistence.ProfileMapper;

@Controller
public class ProfileInsertController {

	@Autowired
	ProfileMapper profileMapper;

	private static final Logger logger = LoggerFactory.getLogger(ProfileInsertController.class);

	@RequestMapping(value = "/profileInsert.do", method = RequestMethod.GET)
	public String profileInsertGet(@RequestPart("contents_image") MultipartFile file, Model model) {
		/*
		 * MultipartFile file = multipartHttpServletRequest.getFile("contents_image");
		 * model.addAttribute("origin", file.getOriginalFilename());
		 */

		try {
			logger.info("profileInsert get method called...");
			logger.info(file.getOriginalFilename());

			String path = "";
			path = "./image/";

			/*
			 * String savePath = path + file.getOriginalFilename();
			 * 
			 * ProfileDTO originalProfileDTO = profileMapper.searchProfileById(memberId);
			 * 
			 * originalProfileDTO.setProfileImg(savePath);
			 * originalProfileDTO.setProfileIntro(profileIntro);
			 * originalProfileDTO.setProfileWebSite(profileWebSite);
			 * profileMapper.updateProfile(originalProfileDTO);
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/mainpeed";
	}

	@RequestMapping(value = "/profileInsert.do", method = RequestMethod.POST)
	public String profileInsert(@RequestPart("contents_image") MultipartFile file,
			@RequestParam("profileIntro") String profileIntro, @RequestParam("website") String website,
			@RequestParam("name1") String memberId, HttpServletRequest req, Model model) {
		/*
		 * MultipartFile file = multipartHttpServletRequest.getFile("contents_image");
		 * model.addAttribute("origin", file.getOriginalFilename());
		 */
		try {
			logger.info("profileInsert post method called...");
			logger.info(file.getOriginalFilename());
			logger.info("profileIntro : " + profileIntro);
			logger.info("memberId : " + memberId);
			logger.info("website : " + website);
			String p = req.getSession().getServletContext().getRealPath("/");
			logger.info(p);
			
			String path = "";
			path = "resources/image/"; 

			String savePath = path + file.getOriginalFilename();

			ProfileDTO originalProfileDTO = profileMapper.searchProfileById(memberId);

			originalProfileDTO.setProfileImg(savePath);
			originalProfileDTO.setProfileIntro(profileIntro);
			originalProfileDTO.setProfileWebSite(website);
			
			profileMapper.updateProfile(originalProfileDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/mainpeed";
	}

}
