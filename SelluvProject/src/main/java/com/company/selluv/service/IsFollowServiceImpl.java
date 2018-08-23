package com.company.selluv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.FollowVO;
import com.company.selluv.persistence.IsFollowMapper;

@Service
public class IsFollowServiceImpl implements IsFollowService{
	
	@Autowired
	IsFollowMapper isfollowMapper; 
	
	@Override
	public FollowVO followIsSearch(String followId,String followerId){
		return isfollowMapper.isSearchFollow(followId,followerId);
	}
}
