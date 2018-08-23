package com.company.selluv.domain.dto;

import java.sql.Timestamp;

public class RetwitDTO {
	private String retwitNum;
	private Timestamp retwitDate;
	private String contentsNum;
	private String memberId;
	
	public RetwitDTO() {
		// TODO Auto-generated constructor stub
	}

	public RetwitDTO(String retwitNum, Timestamp retwitDate, String contentsNum, String memberId) {
		super();
		this.retwitNum = retwitNum;
		this.retwitDate = retwitDate;
		this.contentsNum = contentsNum;
		this.memberId = memberId;
	}
	
	public RetwitDTO(Timestamp retwitDate, String contentsNum, String memberId) {
		super();
		this.retwitDate = retwitDate;
		this.contentsNum = contentsNum;
		this.memberId = memberId;
	}

	public String getRetwitNum() {
		return retwitNum;
	}

	public void setRetwitNum(String retwitNum) {
		this.retwitNum = retwitNum;
	}

	public Timestamp getRetwitDate() {
		return retwitDate;
	}

	public void setRetwitDate(Timestamp retwitDate) {
		this.retwitDate = retwitDate;
	}

	public String getContentsNum() {
		return contentsNum;
	}

	public void setContentsNum(String contentsNum) {
		this.contentsNum = contentsNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "RetwitDTO [retwitNum=" + retwitNum + ", retwitDate=" + retwitDate + ", contentsNum=" + contentsNum
				+ ", memberId=" + memberId + "]";
	}
	
	

}
