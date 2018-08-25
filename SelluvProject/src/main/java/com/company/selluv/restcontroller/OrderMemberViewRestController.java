	package com.company.selluv.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.controller.OrderMemberViewController;
import com.company.selluv.domain.vo.OrderMemberViewVO;
import com.company.selluv.service.OrderMemberViewService;

@RestController
public class OrderMemberViewRestController {
	private static final Logger logger = LoggerFactory.getLogger(OrderMemberViewController.class);
	
	@Autowired
	private OrderMemberViewService service;
	
	@RequestMapping(value="/m.orderMemberView")
	public List<OrderMemberViewVO> orderSheetSearch(@RequestParam("form_code")String form_code, Model model) {
		
		List<OrderMemberViewVO> list = service.orderMemberViewSearch(form_code);
		/*model.addAttribute(list);*/
		
		return list;
	}
}
