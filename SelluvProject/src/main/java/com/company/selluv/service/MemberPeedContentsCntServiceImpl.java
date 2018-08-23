package com.company.selluv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.MemberPeedContentsCntView;
import com.company.selluv.persistence.MemberPeedContentsCntViewMapper;

@Service
public class MemberPeedContentsCntServiceImpl implements MemberPeedContentsCntService{
	
	@Autowired
	MemberPeedContentsCntViewMapper memberPeedContentsCntViewMapper;
	
	@Override
	public MemberPeedContentsCntView memberPeedViewSearch(String member_id) {
		return memberPeedContentsCntViewMapper.searchMemberPeedView(member_id);
	}
}
