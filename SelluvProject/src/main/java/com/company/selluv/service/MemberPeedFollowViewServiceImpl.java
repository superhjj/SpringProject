package com.company.selluv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.MemberPeedFollowViewVO;
import com.company.selluv.persistence.MemberPeedFollowViewMapper;

@Service
public class MemberPeedFollowViewServiceImpl implements MemberPeedFollowViewService {
	
	@Autowired
	private MemberPeedFollowViewMapper memberPeedFollowViewMapper;
	
	@Override
	public MemberPeedFollowViewVO followViewSearch(String memberId) {
		return memberPeedFollowViewMapper.searchFollowView(memberId);
	}
}
