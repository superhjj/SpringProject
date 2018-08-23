package com.company.selluv.domain.dto;

public class HashtagDTO {
	private String hashtag_code;
	private String hashtag_name;
	
	public HashtagDTO() {
		// TODO Auto-generated constructor stub
	}

	public HashtagDTO(String hashtag_code, String hashtag_name) {
		super();
		this.hashtag_code = hashtag_code;
		this.hashtag_name = hashtag_name;
	}

	public String getHashtag_code() {
		return hashtag_code;
	}

	public void setHashtag_code(String hashtag_code) {
		this.hashtag_code = hashtag_code;
	}

	public String getHashtag_name() {
		return hashtag_name;
	}

	public void setHashtag_name(String hashtag_name) {
		this.hashtag_name = hashtag_name;
	}

	@Override
	public String toString() {
		return "HashtagDTO [hashtag_code=" + hashtag_code + ", hashtag_name=" + hashtag_name + "]";
	}
	
	
}
