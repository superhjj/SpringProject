package com.company.selluv.restcontroller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.vo.ItemVO;
import com.company.selluv.service.OrderSheetService;

@RestController
public class OrderSheetSearchRestController {
	private static final Logger logger = LoggerFactory.getLogger(OrderSheetSearchRestController.class);
	
	@Autowired
	OrderSheetService service;
	
	@RequestMapping(value="/orderSheetSearch.do/{formCode}/{memberId}", method = RequestMethod.GET)
	public Map<String, ItemVO> orderSheetSearch(@PathVariable String formCode, @PathVariable String memberId, Model model) {
		logger.info("Order Sheet Search method called...");
		logger.info("formcode: " + formCode);
		logger.info("memberId: " + memberId);		
		
		Map<String, ItemVO> map;
		map = service.SearchOrderSheet(formCode, memberId);
		
		return map;
	}
}
