package com.company.selluv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.selluv.domain.vo.OrderMemberDetailVO;
import com.company.selluv.service.OrderMemberViewService;

@Controller
public class OrderMemberDetailController {
	
	public static final Logger logger = LoggerFactory.getLogger(OrderMemberDetailController.class);
	
	@Autowired
	private OrderMemberViewService service;
	
	@RequestMapping("/orderMemberDetail.do")
	public String orderMemberDetail(@RequestParam("form_code")String form_code, @RequestParam("member_id")String member_id
			,HttpSession session, Model model) {
			String myId = (String) session.getAttribute("memberId");
			
			List<OrderMemberDetailVO> orderMemberDetailList = service.orderMemberDetailSearch(myId, form_code, member_id);
			model.addAttribute(orderMemberDetailList.get(0));
			model.addAttribute(orderMemberDetailList.get(1));
			
			
		return "orderMemberDetail";
	}

}
