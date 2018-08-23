package com.company.selluv.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.selluv.domain.dto.HashtagLinkDTO;

public interface HashtagLinkMapper {
	
	List<HashtagLinkDTO> loadHashtagLinkList();
	
	void addHashtagLink(@Param("hashtagLinkCode")String hashtagLinkCode, @Param("hashtagCode")String hashtagCode, @Param("contentsCode")String contentsCode);
	
	void deleteHashtagLinkByContent(String contentsCode);
	
	void deleteHashtagLink(String hashtagCode);
	
	List<String> searchHashtagLink(String contentsCode);
	
}
