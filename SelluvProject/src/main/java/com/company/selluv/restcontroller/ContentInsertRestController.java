package com.company.selluv.restcontroller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.service.ContentService;

@Controller
public class ContentInsertRestController {

	@Autowired
	ContentService service;
	
	@RequestMapping(value="/m.contentInsert", method=RequestMethod.POST)
	public String contentInsert(@RequestPart("addcontents_img") MultipartFile file, @RequestParam("addcontents_text") String contentText, 
			HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		
		String path="C:\\Users\\user\\Documents\\workspace-sts-3.9.5.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\lab\\resources\\image\\content\\";
		String memberId = (String)session.getAttribute("memberId");
		String contentImg = null;
		
		try {
			contentImg = file.getOriginalFilename();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		File dir = new File(path);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File target = new File(dir, contentImg);
		FileCopyUtils.copy(file.getBytes(), target);
		
		ContentDTO dto;
		
		if(contentText == null || contentText.length() == 0) {
			dto = service.contentAddImgNoneContext(contentImg, memberId);
		}
		else {
			dto = service.contentAddImgNoneContext(contentImg, memberId);
		}
		
		if(dto != null) {
			redirectAttributes.addAttribute("job","searchContentList");
	    	redirectAttributes.addAttribute("id", memberId);
	    	return "redirect:/m.userPeedView";
		}
		return null;
	}
	
}
