package com.company.selluv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.MemberPeedFollowerViewVO;
import com.company.selluv.persistence.MemberPeedFollowerViewMapper;

@Service
public class MemberPeedFollowerViewServiceImpl implements MemberPeedFollowerViewService {

	@Autowired
	private MemberPeedFollowerViewMapper memberPeedFollowerViewMapper;
	
	@Override
	public MemberPeedFollowerViewVO followerViewSearch(String memberId) {
		return memberPeedFollowerViewMapper.searchFollowerView(memberId);
	}
	
}
