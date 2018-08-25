package com.company.selluv.domain.dto;

import java.util.Date;

public class FormDTO {
	private String formCode;
	private String formTitle;
	private String formContent;
	private String memberId;
	//boolean -> String���� ��ħ!!
	private String periodFlag;
	private Date formStartDate;
	private Date formEndDate;
	
	public FormDTO() { }

	public FormDTO(String formCode, String formTitle, String formContent, String memberId, String periodFlag,
			Date formStartDate, Date formEndDate) {
		super();
		this.formCode = formCode;
		this.formTitle = formTitle;
		this.formContent = formContent;
		this.memberId = memberId;
		this.periodFlag = periodFlag;
		this.formStartDate = formStartDate;
		this.formEndDate = formEndDate;
	}

	public FormDTO(String formTitle, String formContent, String memberId, String periodFlag,
			Date formStartDate, Date formEndDate) {
		super();
		this.formTitle = formTitle;
		this.formContent = formContent;
		this.memberId = memberId;
		this.periodFlag = periodFlag;
		this.formStartDate = formStartDate;
		this.formEndDate = formEndDate;
	}
	
	public FormDTO(String formTitle, String formContent, String memberId, String periodFlag) {
		super();
		this.formTitle = formTitle;
		this.formContent = formContent;
		this.memberId = memberId;
		this.periodFlag = periodFlag;
	}



	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	public String getFormContent() {
		return formContent;
	}

	public void setFormContent(String formContent) {
		this.formContent = formContent;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setperiodFlag(String periodFlag) {
		this.periodFlag = periodFlag;
	}

	public Date getFormStartDate() {
		return formStartDate;
	}

	public void setFormStartDate(Date formStartDate) {
		this.formStartDate = formStartDate;
	}

	public Date getFormEndDate() {
		return formEndDate;
	}

	public void setFormEndDate(Date formEndDate) {
		this.formEndDate = formEndDate;
	}

	public String getPeriodFlag() {
		return periodFlag;
	}

	public void setPeriodFlag(String periodFlag) {
		this.periodFlag = periodFlag;
	}

	@Override
	public String toString() {
		return "FormDTO [formCode=" + formCode + ", formTitle=" + formTitle + ", formContent=" + formContent
				+ ", memberId=" + memberId + ", periodFlag=" + periodFlag + ", formStartDate=" + formStartDate
				+ ", formEndDate=" + formEndDate + "]";
	}

	
}
