package com.company.selluv.persistence;

import java.util.List;

import com.company.selluv.domain.dto.HashtagDTO;

public interface HashtagMapper {
	public void hashtagDelete(String hashtag_code);
	public HashtagDTO hastagSelectByCode(String hashtag_code);
	public List<HashtagDTO> hastagSelectByName(String hashtag_name);
/*	public List<ContentDTO> hashtagNameSelect(String hashtag_name);*/
}
