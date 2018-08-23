package com.company.selluv.persistence;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.selluv.domain.dto.FormDTO;

public interface FormMapper {
	public List<FormDTO> loadFormList();
	public void formInsert(@Param("formCode")String formCode, @Param("formTitle")String formTitle, @Param("formContent")String formContent, @Param("memberId")String memberId, @Param("period_flag")String period_flag, @Param("formStartDate")Date formStartDate,
			@Param("formEndDate")Date formEndDate);
	public FormDTO searchForm(@Param("formCode")String formCode,@Param("memberId") String memberId);
	public List<FormDTO> searchFormList(@Param("memberId")String memberId);
	public void formDelete(@Param("formCode")String formCode, @Param("memberId")String memberId);
}
