package com.company.selluv.domain.dto;

import java.sql.Timestamp;

public class CommentDTO {
	private String commentCode;
	private String memberId;
	private String commentText;
	private Timestamp commentDate;
	private String contentsCode;
	
	public CommentDTO(){ }

	public CommentDTO(String commentCode, String memberId, String commentText, Timestamp commentDate,
			String contentsCode) {
		super();
		this.commentCode = commentCode;
		this.memberId = memberId;
		this.commentText = commentText;
		this.commentDate = commentDate;
		this.contentsCode = contentsCode;
	}

	public CommentDTO(String memberId, String commentText, Timestamp commentDate, String contentsCode) {
		super();
		this.memberId = memberId;
		this.commentText = commentText;
		this.commentDate = commentDate;
		this.contentsCode = contentsCode;
	}

	public String getCommentCode() {
		return commentCode;
	}

	public void setCommentCode(String commentNum) {
		this.commentCode = commentNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public String getContentsCode() {
		return contentsCode;
	}

	public void setContentsCode(String contentsNum) {
		this.contentsCode = contentsNum;
	}

	@Override
	public String toString() {
		return "CommentDTO [commentCode=" + commentCode + ", memberId=" + memberId + ", commentText=" + commentText
				+ ", commentDate=" + commentDate + ", contentsCode=" + contentsCode + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDTO other = (CommentDTO) obj;
		if (commentDate == null) {
			if (other.commentDate != null)
				return false;
		} else if (!commentDate.equals(other.commentDate))
			return false;
		if (commentCode == null) {
			if (other.commentCode != null)
				return false;
		} else if (!commentCode.equals(other.commentCode))
			return false;
		if (commentText == null) {
			if (other.commentText != null)
				return false;
		} else if (!commentText.equals(other.commentText))
			return false;
		if (contentsCode == null) {
			if (other.contentsCode != null)
				return false;
		} else if (!contentsCode.equals(other.contentsCode))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
	
}
