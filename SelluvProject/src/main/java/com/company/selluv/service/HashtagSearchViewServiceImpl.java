package com.company.selluv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.HashtagSearchViewVO;
import com.company.selluv.persistence.HashtagSearchViewMapper;

@Service
public class HashtagSearchViewServiceImpl implements HashtagSearchViewService{
	
	@Autowired
	HashtagSearchViewMapper hashtagSearchViewMapper;
	
	@Override
	public List<HashtagSearchViewVO> hashtagSearchViewSearch(String hashtag_name){
		return hashtagSearchViewMapper.searchHashtagSearchView(hashtag_name);
	}
}
