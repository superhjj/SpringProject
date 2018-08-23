package com.company.selluv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.MemberPeedViewVO;
import com.company.selluv.persistence.MemberPeedViewMapper;

@Service
public class MemberPeedViewServiceImpl implements MemberPeedViewService{
	
	@Autowired
	MemberPeedViewMapper memberPeedViewMapper;
	
	@Override
	public MemberPeedViewVO memberPeedViewSearch(String memberId) {
		return memberPeedViewMapper.searchMemberPeedView(memberId);
	}
}
