package com.company.selluv.domain.dto;

public class HashtagLinkDTO {
	private String hashtag_link_code;
	private String hashtag_code;
	private String contents_code;
	
	public HashtagLinkDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public HashtagLinkDTO(String hashtag_link_code, String hashtag_code, String contents_code) {
		super();
		this.hashtag_link_code = hashtag_link_code;
		this.hashtag_code = hashtag_code;
		this.contents_code = contents_code;
	}

	public String getHashtag_link_code() {
		return hashtag_link_code;
	}

	public void setHashtag_link_code(String hashtag_link_code) {
		this.hashtag_link_code = hashtag_link_code;
	}

	public String getHashtag_code() {
		return hashtag_code;
	}

	public void setHashtag_code(String hashtag_code) {
		this.hashtag_code = hashtag_code;
	}

	public String getContents_code() {
		return contents_code;
	}

	public void setContents_code(String contents_code) {
		this.contents_code = contents_code;
	}

	@Override
	public String toString() {
		return "HashtagLinkDTO [hashtag_link_code=" + hashtag_link_code + ", hashtag_code=" + hashtag_code
				+ ", contents_code=" + contents_code + "]";
	}
}
