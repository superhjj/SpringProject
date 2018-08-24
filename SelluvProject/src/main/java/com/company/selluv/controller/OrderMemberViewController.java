package com.company.selluv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.selluv.domain.vo.OrderMemberViewVO;
import com.company.selluv.service.OrderMemberViewService;

@Controller
public class OrderMemberViewController {
	private static final Logger logger = LoggerFactory.getLogger(OrderMemberViewController.class);
	
	@Autowired
	private OrderMemberViewService service;
	
	@RequestMapping(value="/orderMemberView.do")
	public String orderMemberViewSearch(@RequestParam("form_code")String form_code, Model model) {
		
		List<OrderMemberViewVO> list = service.orderMemberViewSearch(form_code);
		logger.info("OrderMemberViewVO size : " + list.size());
		
		model.addAttribute("list", list);
		
		return "orderMemberView";
	}
}
