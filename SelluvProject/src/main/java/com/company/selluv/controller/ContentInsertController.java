package com.company.selluv.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ContentInsertController {

   private static final Logger logger = LoggerFactory.getLogger(ContentInsertController.class);
   
   @Autowired
   ContentService service;
   
//   @RequestMapping(value="/contentInsert2.do", method=RequestMethod.GET)
//   public String contentInsert() {
//      return "/addcontents";
//   }
   
   @RequestMapping(value="/addcontents", method=RequestMethod.GET)
   public String addContents()
   {
	   return "addcontents";
   }
   
   
   @RequestMapping(value="/contentsInsert.do", method=RequestMethod.POST)
   public String contentInsert(@RequestPart("addcontents_img") MultipartFile file, @RequestParam("addcontents_text") String contentText, 
         HttpSession session, RedirectAttributes redirectAttributes) throws Exception
   {
      
      //경로 바꾸기
      //C:\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\Selluv\resources\image
      String path="C:\\Users\\HYH\\Documents\\workspace-sts-3.9.5.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Selluv\\resources\\image\\content\\";
      String memberId = (String)session.getAttribute("memberId");
      //String memberId = "id9";
      String contentImg = null;
      try {
       contentImg = file.getOriginalFilename();
      }
      catch(Exception e) {
         logger.error("contentInsert : 사진  읽어오기 오류");
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
            dto = service.contentAddImg(contentText, contentImg, memberId);
         }
         
         if(dto != null) {
          logger.info("contentInsert : 컨텐츠 등록 성공");
          redirectAttributes.addAttribute("job","searchContentList");
          redirectAttributes.addAttribute("id", memberId);
          return "redirect:userPeedView.do";
         }
         logger.info("contentInsert : 컨텐츠 등록 실패");
         
      return null;//터짐!!
   }
}