package com.company.selluv.restcontroller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.controller.OrderSheetSearchController;

@RestController
public class LogoutRestController {
	private static final Logger logger = LoggerFactory.getLogger(OrderSheetSearchController.class);

	@RequestMapping(value="/m.logout")
	public String logout(HttpSession session) {
		
		if(session!=null && session.getAttribute("memberId")!=null){
			session.invalidate();
			logger.info("·Î±×¾Æ¿ô");
		}
		return "·Î±×¾Æ¿ô";//???????
		
	}
}
