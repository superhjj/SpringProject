package com.company.selluv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderSheetSearchController {
	private static final Logger logger = LoggerFactory.getLogger(OrderSheetSearchController.class);
	
/*	@Autowired
	private OrderResponseService service;*/
	
	//userpeed.js line59수정 url 전송 수정 + 더있나 보기
	@RequestMapping(value="/orderSheetSearch.do/{formCode}/{memberId}", method = RequestMethod.GET)
	public String orderSheetSearch(@PathVariable String formCode, @PathVariable String memberId, Model model) {
		logger.info("Order Sheet Search method called...");
		
		logger.info("formcode: " + formCode);
		logger.info("memberId: " + memberId);
		
		model.addAttribute("formCode", formCode);
		model.addAttribute("memberId", memberId);
		
		return "orderSheet";
	}
	
	
}
