package com.company.selluv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.HashtagLinkDTO;
import com.company.selluv.persistence.HashtagLinkMapper;

@Service
public class HashtagLinkServiceImpl implements HashtagLinkService {

	@Autowired
	private HashtagLinkMapper hashtagLinkMapper;
	private static int hashtagLinkNumber;
	
	private String generateHashtagLinkCode(){
		hashtagLinkNumber++;
		return "hashtaglink-" + hashtagLinkNumber;
	}
	
	@Override
	public boolean loadHashtagLinkList() {
		
		List<HashtagLinkDTO> hashtagLinkList = hashtagLinkMapper.loadHashtagLinkList();
		int maxNum = 0;
		
		for(HashtagLinkDTO hashtagLink: hashtagLinkList) {
			hashtagLinkNumber = Integer.parseInt(hashtagLink.getHashtag_link_code().substring(12));
			if(maxNum < hashtagLinkNumber) {
				maxNum = hashtagLinkNumber;
			}
		}
		hashtagLinkNumber = maxNum;
		
		return true;
	}

	@Override
	public HashtagLinkDTO hashtagLinkInsert(String contentsCode, String hashtagCode) {
		
		loadHashtagLinkList();
		String hashtagLinkCode = generateHashtagLinkCode();
		hashtagLinkMapper.addHashtagLink(hashtagLinkCode, hashtagCode, contentsCode);
		
		HashtagLinkDTO hashtagLinkDTO = new HashtagLinkDTO(hashtagLinkCode, hashtagCode, contentsCode);
		
		return hashtagLinkDTO;
	}

	@Override
	public boolean hashtagLinkDeleteByContent(String contentsCode) {

		hashtagLinkMapper.deleteHashtagLinkByContent(contentsCode);
		
		return false;
	}

	@Override
	public boolean hashtagLinkDelete(String hashtagCode) {
		
		hashtagLinkMapper.deleteHashtagLink(hashtagCode);
		
		return false;
	}

	@Override
	public List<String> hashtagLinkSearch(String contentsCode) {

		return hashtagLinkMapper.searchHashtagLink(contentsCode);
	}

}
