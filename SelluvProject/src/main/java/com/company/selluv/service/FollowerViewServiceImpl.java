package com.company.selluv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.FollowViewVO;
import com.company.selluv.persistence.FollowerViewMapper;

@Service
public class FollowerViewServiceImpl implements FollowerViewService {

	@Autowired
	private FollowerViewMapper followerViewMapper;
	
	@Override
	public List<FollowViewVO> followerViewSearch(String memberId) {
		return followerViewMapper.searchFollowerView(memberId);
	}
	
}
