package com.company.selluv.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderSheetSearchRestController {
	private static final Logger logger = LoggerFactory.getLogger(OrderSheetSearchRestController.class);
	
	@RequestMapping(value="/orderSheetSearch.do/{formCode}/{memberId}", method = RequestMethod.GET)
	public Map<String, String> orderSheetSearch(@PathVariable String formCode, @PathVariable String memberId, Model model) {
		logger.info("Order Sheet Search method called...");
		logger.info("formcode: " + formCode);
		logger.info("memberId: " + memberId);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("formCode", formCode);
		map.put("memberId", memberId);
		
		
		return map;
	}
}
