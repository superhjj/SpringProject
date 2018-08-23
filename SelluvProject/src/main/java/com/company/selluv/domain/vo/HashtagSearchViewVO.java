package com.company.selluv.domain.vo;

public class HashtagSearchViewVO {
	private String member_id;
	private String hashtag_code;
	private String hashtag_name;
	private String hashtag_link_code;
	private String contents_code;
	public HashtagSearchViewVO(String member_id, String hashtag_code, String hashtag_name, String hashtag_link_code, String contents_code) {
		super();
		this.member_id = member_id;
		this.hashtag_code = hashtag_code;
		this.hashtag_name = hashtag_name;
		this.hashtag_link_code = hashtag_link_code;
		this.contents_code = contents_code;
	}

	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
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
	public String getHashtag_link_code() {
		return hashtag_link_code;
	}
	public void setHashtag_link_code(String hashtag_link_code) {
		this.hashtag_link_code = hashtag_link_code;
	}
	public String getContents_code() {
		return contents_code;
	}
	public void setContents_code(String contents_code) {
		this.contents_code = contents_code;
	}

	@Override
	public String toString() {
		return "HashtagSearchViewVO [member_id=" + member_id + ", hashtag_code=" + hashtag_code + ", hashtag_name="
				+ hashtag_name + ", hashtag_link_code=" + hashtag_link_code + ", contents_code=" + contents_code + "]";
	}
	
}
