package com.company.selluv.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.selluv.domain.dto.FormDTO;
import com.company.selluv.domain.vo.ItemVO;
import com.company.selluv.service.FormService;

@Controller
public class FormInsertController {
	private static final Logger logger = LoggerFactory.getLogger(FormInsertController.class);
	
	@Autowired
	FormService service;
	
	@RequestMapping(value="/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value="/form_item")
	public String formItem() {
		return "form_item";
	}

	
	@RequestMapping(value="/form_title")
	public String formTitle() {
		return "form_title";
	}

	@RequestMapping(value="/formitemtype/ai")
	public String ai() {
		return "formitemtype/ai";
	}
	
	@RequestMapping(value="/formitemtype/mi")
	public String mi() {
		return "formitemtype/mi";
	}
	
	@RequestMapping(value="/formitemtype/mm")
	public String mm() {
		return "formitemtype/mm";
	}
	

	@RequestMapping(value="/formitemtype/ms_add")
	public String msAdd() {
		return "formitemtype/ms_add";
	}

	@RequestMapping(value="/formitemtype/ms_edit")
	public String msEdit() {
		return "formitemtype/ms_edit";
	}

	@RequestMapping(value="/formitemtype/ms")
	public String ms() {
		return "formitemtype/ms";
	}

	@RequestMapping(value="/formitemtype/sa_add")
	public String saAdd() {
		return "formitemtype/sa_add";
	}

	@RequestMapping(value="/formitemtype/sa")
	public String sa() {
		return "formitemtype/sa";
	}
	
	@RequestMapping(value="/formitemtype/sn")
	public String sn() {
		return "formitemtype/sn";
	}
	
	@RequestMapping(value="/formitemtype/ss_add")
	public String ssAdd() {
		return "formitemtype/ss_add";
	}
	
	@RequestMapping(value="/formitemtype/ss_edit")
	public String ssEdit() {
		return "formitemtype/ss_edit";
	}
	
	@RequestMapping(value="/formitemtype/ss")
	public String ss() {
		return "formitemtype/ss";
	}
	
	@RequestMapping(value="/formitemtype/ti")
	public String ti() {
		return "formitemtype/ti";
	}
	
	
	
	@RequestMapping(value="/formInsert.do", method=RequestMethod.POST)
	public String formInsert(Model model
			, @RequestParam("formTitle")String formTitle, @RequestParam(value="formContent", required=false)String formContent
			, @RequestParam("memberId")String memberId, @RequestParam(value="periodFlag", required=false)String periodFlag
			, @RequestParam(value="formStartDate", required=false)String formStartDate, @RequestParam(value="formEndDate", required=false)String formEndDate
			, @RequestParam(value="formHtml", required=false)String formHtml
			, @RequestParam(value="itemNums", required=false)String[] itemNums, @RequestParam(value="titles", required=false)String[] titles 
			,@RequestParam(value="descripts", required=false)String[] descripts, @RequestParam(value="necessaries", required=false) String []necessaries
			,@RequestParam(value="types", required=false)String[] types, @RequestParam(value="options")String[] options
			,RedirectAttributes redirect) 
	{
		//formStartDate, formEndDate -> formDTO Ÿ�� �ٸ� ~> �ȹ޾����� �Ķ���� �߰��ϱ�
		//@RequestParams("formStartDate")String formStartDate, @RequestParam("formEndDate")String formEndDate -> formDTO�� �ȵ�� �� ���

		
		logger.info("itemNums : " + itemNums[0]);
		logger.info("titles : " + titles[0]);
		logger.info("descripts : " + descripts[0]);
		logger.info("necessaries" + necessaries[0]);
		logger.info("types : " +types[0]);
		logger.info("options : "+options[0]);
		logger.info("formTitle : " + formTitle);
		logger.info("periodFlag : " + periodFlag);
		logger.info("formStartDate : " + formStartDate);
		
		
		FormDTO formDTO = new FormDTO(formTitle, formContent, memberId, periodFlag);
		logger.info("formDTO : "+ formDTO);
		Date start = null;
		Date end = null;
		
		if (formDTO.getPeriodFlag().equals("Y")) {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				start = transFormat.parse(formStartDate);
				end = transFormat.parse(formEndDate);
				formDTO.setFormStartDate(start);
				formDTO.setFormEndDate(end);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			formDTO.setFormStartDate(null);
			formDTO.setFormEndDate(null);
		}
		logger.info("formDTO : "+ formDTO);
		logger.info("itemNums length : " + itemNums.length);
		List<ItemVO> itemList = new ArrayList<ItemVO>();	
		for (int i = 0; i < itemNums.length; ++i) {
			ItemVO item = new ItemVO(itemNums[i], titles[i], descripts[i], necessaries[i], types[i], options[i]);
			System.out.println(item);
			itemList.add(item);
		}
	
		String formCode = service.addForm(formDTO.getFormTitle(), formDTO.getFormContent(), formDTO.getMemberId(), formDTO.getPeriodFlag(), formDTO.getFormStartDate(), formDTO.getFormEndDate(), formHtml, itemList);
		formDTO.setFormCode(formCode);
		
		redirect.addAttribute("formCode",formCode);
		redirect.addAttribute("insert", "insertForm");
		
	return "redirect:/userPeedView.do?id="+formDTO.getMemberId();
	}
}
