package com.company.selluv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.selluv.service.OrderResponseService;

@Controller
public class OrderResponseInsertController {
	private static final Logger logger = LoggerFactory.getLogger(OrderResponseInsertController.class);
	@Autowired
	private OrderResponseService service;
	
	@RequestMapping("/orderResponseInsert.do")
	public String orderResponseInsert(@RequestParam("itemInsert")String res, @RequestParam("titleInsert")String title, 
			@RequestParam("peedId")String peedId, @RequestParam("formCode")String formCode,
			Model model, HttpSession session) {
		String[] resAry = res.split("/");
		String[] titleAry = title.split("/");
		
		String memberId = (String)session.getAttribute("memberId");
		
		List<String> titleList = new ArrayList<String>();
		List<String> responseList = new ArrayList<String>();
		
		for(String r: resAry) {
			if(!r.isEmpty()){
				responseList.add(r);
			}
		}
		for(String t: titleAry) {
			if(!t.isEmpty()) {
				titleList.add(t);
			}
		}
		
		service.orderResponseInsert(memberId, formCode, titleList, responseList, peedId);
		model.addAttribute("memberId", peedId);
		
		return "redirect:userPeedView.do?id="+peedId;
	}
}
