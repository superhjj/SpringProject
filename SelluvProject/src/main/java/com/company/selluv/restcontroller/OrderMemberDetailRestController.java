package com.company.selluv.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.vo.OrderMemberDetailVO;
import com.company.selluv.service.OrderMemberViewService;

@RestController
public class OrderMemberDetailRestController {
	public static final Logger logger = LoggerFactory.getLogger(OrderMemberDetailRestController.class);
	
	@Autowired
	private OrderMemberViewService service;
	
	@RequestMapping("/m.orderMemberDetail")
	public List<OrderMemberDetailVO> orderMemberDetail(@RequestParam("form_code")String form_code, @RequestParam("member_id")String member_id
			,HttpSession session, Model model) {
			String myId = (String) session.getAttribute("memberId");
			
			List<OrderMemberDetailVO> orderMemberDetailList = service.orderMemberDetailSearch(myId, form_code, member_id);
		
			
			
			model.addAttribute(orderMemberDetailList.get(0));
			model.addAttribute(orderMemberDetailList.get(1));
			/*
			return orderMemberDetail;
			*/
			
			
			
			return orderMemberDetailList;
	}
}
