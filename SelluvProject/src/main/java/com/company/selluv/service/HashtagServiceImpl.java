package com.company.selluv.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.domain.dto.HashtagDTO;
import com.company.selluv.domain.dto.HashtagLinkDTO;
import com.company.selluv.persistence.HashtagMapper;

@Service
public class HashtagServiceImpl implements HashtagService {
	@Autowired
	HashtagMapper mapper;
	
	@Autowired
	HashtagLinkService linkService;
	
	@Override
	public HashtagLinkDTO addHashtag(String contents_code, String hashtag_name) {
		// TODO Auto-generated method stub
		HashtagLinkDTO hashtagLink = null;
		
		try {
			String hashtag_code = generateHashtagCode();
			HashtagDTO add = new HashtagDTO();
			add.setHashtag_code(hashtag_code);
			add.setHashtag_name(hashtag_name);
			
			mapper.hashtagInsert(add);
			
			hashtagLink = linkService.hashtagLinkInsert(contents_code, hashtag_code);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return hashtagLink;
	}

	@Override
	public List<HashtagLinkDTO> addHashtags(String contents_code, List<String> hashtag_names) {
		List<HashtagLinkDTO> list = null;
		
		if(hashtag_names != null && hashtag_names.size() != 0) {
			list = new ArrayList<HashtagLinkDTO>();
			
			for(String elem : hashtag_names) {
				HashtagDTO add = new HashtagDTO();
				String h_code = generateHashtagCode();
				add.setHashtag_code(h_code);
				add.setHashtag_name(elem);
				
				try {
					mapper.hashtagInsert(add);
				}
				catch(Exception e) {
					e.printStackTrace();
					return null;
				}
				
				HashtagLinkDTO addLink = linkService.hashtagLinkInsert(contents_code, h_code);
				
				list.add(addLink);
			}
		}
		
		return list;
	}

	@Override
	public List<HashtagDTO> searchHashtagAll() {
		List<HashtagDTO> list = null;
		
		try {
			list = mapper.hashtagSearchAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return list;
	}
	
   private static final Logger logger = LoggerFactory.getLogger(HashtagServiceImpl.class);
	
	@Override
	public boolean deleteHashtag(String hashtag_code) {
		// TODO Auto-generated method stub
		try {		
			mapper.hashtagDelete(hashtag_code);
			return true;
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
				//hash_tag code�� content���ͼ� �����ϴ°�
				//Content search...�� ����...
				
			}
		}
		catch(Exception e){
			logger.error("searchHashtagName");
			e.printStackTrace();
		}
		return contentList;
	}
	private String generateHashtagCode() {
		String hashtagCode = null;
		int max = 0;
		List<HashtagDTO> list = searchHashtagAll();
		
		if(list.size() != 0) {
			for(HashtagDTO elem : list) {
				int num = Integer.parseInt(elem.getHashtag_code().substring(8));
				
				if(num > max) {
					max = num;
				}
				
				hashtagCode = "hashtag-" + (max + 1);
			}
		}
		
		hashtagCode = "hashtag-" + (max + 1);
		
		return hashtagCode;
	}
	
	
}
