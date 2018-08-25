package com.company.selluv.service;

import java.util.Date;
import java.util.List;

import com.company.selluv.domain.dto.FormDTO;
import com.company.selluv.domain.vo.ItemVO;

public interface FormService {
	public List<FormDTO> loadFormList();
	public FormDTO addForm(String formTitle, String formContent, String memberId, String periodFlag, Date formStartDate,
			Date formEndDate, String formHtml);
	public String addForm(String formTitle, String formContent, String memberId, String periodFlag, Date formStartDate,
			Date formEndDate, String formHtml, List<ItemVO> itemList);
	public FormDTO searchForm(String formCode, String memberId);
	public List<FormDTO> searchFormList(String memberId);
	public boolean deleteForm(String formCode, String memberId);
}
