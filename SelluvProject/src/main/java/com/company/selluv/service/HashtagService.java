package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.dto.HashtagDTO;

public interface HashtagService {
	public boolean deleteHashtag(String hashtag_code);
	public HashtagDTO searchHashtag(String hashtag_code);
	public List<HashtagDTO> searchHashtag(String hashtag_name, int flag);
	/*public List<ContentDTO> searchHashtagName(String hashtag_name);*/
}
