package com.company.selluv.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.FormDTO;
import com.company.selluv.persistence.FormMapper;

@Service
public class FormServiceImpl implements FormService {

	@Autowired
	private FormMapper mapper;
	private static int formNum;
	private static final Logger logger = LoggerFactory.getLogger(FormServiceImpl.class);

	private int max_fn() {
		List<FormDTO> formList = loadFormList();
		int maxNum = 0;

		if (!(formList.size() == 0 || formList == null)) {
			// order-1
			for(FormDTO dto:formList) {
				String key = dto.getFormCode();
				int num = Integer.parseInt(key.substring(5));

				if (num > maxNum) {
					maxNum = num;
				}
			}
		}

		return ++maxNum;
	}
	
	public void addFormFile(String formCode, String memberId, String formHtml){
		//해당 컴퓨터 메타데이터 경로로 바꿔 주어야 함
		String filePath = "C:\\sts-bundle\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Selluv\\form\\"+memberId+"\\"+formCode;
		String basicHtml = "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>";
		String basic2 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
		String startHtml="<html><head></head><body>";
		String endHtml = "</body></html>";	

		
		File f =new File(filePath);
		if(!f.exists()){
			f.mkdirs();
		}
		try {
			FileOutputStream output = new FileOutputStream(filePath+"\\"+formCode+".jsp");
			OutputStreamWriter osw;
			try {
				osw = new OutputStreamWriter(output, "UTF-8");
				BufferedWriter bufferedWriter = new BufferedWriter(osw);
				bufferedWriter.write(basicHtml);
				bufferedWriter.write(basic2);
				bufferedWriter.write(startHtml);
				bufferedWriter.write(formHtml);
				bufferedWriter.write(endHtml);
				bufferedWriter.close();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch(IOException e2){
				e2.printStackTrace();
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	 
	@Override
	public FormDTO addForm(String formTitle, String formContent, String memberId, String period_flag, Date formStartDate,
			Date formEndDate, String formHtml) {
		formNum = max_fn();
		String formCode = this.generateFormCode();
		
/*		//빈 등록하기!
		@Autowired*/
		
		
		try {
			mapper.formInsert(formCode, formTitle, formContent, memberId, period_flag, (java.sql.Date)formStartDate, (java.sql.Date)formEndDate);	
			FormDTO dto = null;
			dto = new FormDTO();
			dto.setFormCode(formCode);
			dto.setFormTitle(formTitle);
			dto.setFormContent(formContent);
			dto.setMemberId(memberId);
			dto.setPeriod_flag(period_flag);
			dto.setFormStartDate(formStartDate);
			dto.setFormEndDate(formEndDate);
			addFormFile(formCode, memberId, formHtml);
			return dto;
		}
		catch(Exception e) {
			logger.error("addForm insert error");
			e.printStackTrace();
		}
		
		return null;
		// TODO Auto-generated method stub		
	}
	
	private String generateFormCode() {
		return "form-" + formNum;
	}

	@Override
	public FormDTO searchForm(String formCode, String memberId) {
		// TODO Auto-generated method stub
		return mapper.searchForm(formCode, memberId);
	}

	@Override
	public List<FormDTO> searchFormList(String memberId) {
		// TODO Auto-generated method stub
		return mapper.searchFormList(memberId);
	}

	@Override
	public boolean deleteForm(String formCode, String memberId) {
		// TODO Auto-generated method stub
		try {
			mapper.formDelete(formCode, memberId);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("deleteForm error");
		}
		return false;
	}

	@Override
	public List<FormDTO> loadFormList() {
		return mapper.loadFormList();
	}

}
