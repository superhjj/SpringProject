package com.company.selluv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.selluv.domain.dto.FormDTO;
import com.company.selluv.service.FormService;

@Controller
public class FormSearchController {

	@Autowired
	FormService service;
	
	@ResponseBody
	@RequestMapping(value="/searchFormController.do", method= {RequestMethod.POST, RequestMethod.GET}, produces="application/json; charset=UTF-8")
	public String formSearch(HttpSession session, @RequestParam("member_id")String member_id2)
	{
		String member_id = (String) session.getAttribute("memberId");
		List<FormDTO> formList =service.searchFormList(member_id2);
		
		JSONArray jAry = new JSONArray();
		if(formList.size() != 0){
			for(FormDTO elem : formList){
				JSONObject obj = new JSONObject();
				obj.put("form_code", elem.getFormCode());
				obj.put("form_title", elem.getFormTitle());
				obj.put("member_id", member_id);
				obj.put("peed_id", member_id2);
				
				System.out.println("FormSearchController peed_id : "+member_id2);
				jAry.add(obj);
			}
		}
		else{
			JSONObject obj = new JSONObject();
			obj.put("peed_id", member_id2);
			
			jAry.add(obj);
		}
		
		return jAry.toString();
	}
}
