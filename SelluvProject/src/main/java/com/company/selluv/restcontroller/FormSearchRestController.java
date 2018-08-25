package com.company.selluv.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.selluv.domain.dto.FormDTO;
import com.company.selluv.service.FormService;

@RestController
public class FormSearchRestController {

	@Autowired
	FormService service;
	
	@RequestMapping(value="/m.searchFormController", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public Map<String, String> formSearch(HttpSession session, @RequestParam("member_id")String member_id2)
	{
		String member_id = (String) session.getAttribute("memberId");
		
		List<FormDTO> formList =service.searchFormList(member_id2);
		Map<String, String> map = new HashMap<String, String>();
		
		if(formList.size() != 0){
			for(FormDTO elem : formList){
				JSONObject obj = new JSONObject();
				map.put("form_code", elem.getFormCode());
				map.put("form_title", elem.getFormTitle());
				map.put("member_id", member_id);
				map.put("peed_id", member_id2);
			}
		}
		else {
			map.put("peed_id", member_id2);
		}
		
		return map;
/*		JSONArray jAry = new JSONArray();
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
		
		return jAry.toString();*/
	}
}
