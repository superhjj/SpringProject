package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.dto.HashtagDTO;
import com.company.selluv.domain.dto.HashtagLinkDTO;

public interface HashtagService {
	public HashtagLinkDTO addHashtag(String contents_code, String hashtag_code);
	
	public List<HashtagLinkDTO> addHashtags(String contents_code, List<String>hashtag_codes);
	
	public List<HashtagDTO> searchHashtagAll();
	
	public boolean deleteHashtag(String hashtag_code);
	
	public HashtagDTO searchHashtag(String hashtag_code);
	
	public List<HashtagDTO> searchHashtag(String hashtag_name, int flag);
}
