package com.company.selluv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.FollowViewVO;
import com.company.selluv.persistence.FollowViewMapper;

@Service
public class FollowViewServiceImpl implements FollowViewService {
	
	@Autowired
	private FollowViewMapper followViewMapper;
	
	@Override
	public List<FollowViewVO> followViewSearch(String memberId) {
		return followViewMapper.searchFollowView(memberId);
	}
	
}
