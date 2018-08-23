package com.company.selluv.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.domain.dto.HashtagDTO;
import com.company.selluv.persistence.HashtagMapper;

@Service
public class HashtagServiceImpl implements HashtagService {

	@Autowired
	public HashtagMapper mapper;
	
	@Autowired
	public HashtagLinkService linkService;
	
	private static final Logger logger = LoggerFactory.getLogger(HashtagServiceImpl.class);
	
	@Override
	public boolean deleteHashtag(String hashtag_code) {
		// TODO Auto-generated method stub
		try {
			mapper.hashtagDelete(hashtag_code);
			if(linkService.hashtagLinkDelete(hashtag_code)) {
				return true;
			}
		}
		catch(Exception e){
			logger.error("deleteHashtag error");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public HashtagDTO searchHashtag(String hashtag_code) {
		// TODO Auto-generated method stub
		HashtagDTO dto = null;
		try {
			dto = mapper.hastagSelectByCode(hashtag_code);
			return dto;
		}
		catch(Exception e){
			logger.error("searchHashtag by code error");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<HashtagDTO> searchHashtag(String hashtag_name, int flag) {
		// TODO Auto-generated method stub
		List<HashtagDTO> list = null;
		try {
			list = mapper.hastagSelectByName(hashtag_name);
			return list;
		}
		catch(Exception e){
			logger.error("searchHashtag by name error");
			e.printStackTrace();
		}
		return list;
	}


	public List<ContentDTO> searchHashtagName(String hashtag_name) {
		// TODO Auto-generated method stub

		List<HashtagDTO> list = null;
		List<ContentDTO> contentList = null;
		try {
			list = mapper.hastagSelectByName(hashtag_name);
			for(HashtagDTO dto:list)
			{
				//hash_tag code로 content얻어와서 저장하는거
				//Content search...난 없다...
				
			}
		}
		catch(Exception e){
			logger.error("searchHashtagName");
			e.printStackTrace();
		}
		return contentList;
	}
}
