package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.dto.HashtagLinkDTO;

public interface HashtagLinkService {

	boolean loadHashtagLinkList();
	
	HashtagLinkDTO hashtagLinkInsert(String contentsCode, String hashtagCode);
	
	boolean hashtagLinkDeleteByContent(String contentsCode);
	
	boolean hashtagLinkDelete(String hashtagCode);
	
	List<String> hashtagLinkSearch(String contentsCode);
	
}
