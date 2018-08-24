package com.company.selluv.persistence;

import java.util.List;

import com.company.selluv.domain.dto.HashtagDTO;

public interface HashtagMapper {
	public void hashtagInsert(HashtagDTO hash) throws Exception;
	
	public void hashtagsInsert(List<HashtagDTO> hashtagList) throws Exception;
	
	public List<HashtagDTO> hashtagSearchAll() throws Exception;
	
	public void hashtagDelete(String hashtag_code);
	
	public HashtagDTO hastagSelectByCode(String hashtag_code);
	
	public List<HashtagDTO> hastagSelectByName(String hashtag_name);
/*	public List<ContentDTO> hashtagNameSelect(String hashtag_name);*/
}
