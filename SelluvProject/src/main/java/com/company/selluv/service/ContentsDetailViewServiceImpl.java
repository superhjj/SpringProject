package com.company.selluv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.ContentsDetailViewVO;
import com.company.selluv.persistence.ContentsDetailViewMapper;

@Service
public class ContentsDetailViewServiceImpl implements ContentsDetailViewService{
	
	@Autowired
	ContentsDetailViewMapper contentsDetailViewMapper;
	
	@Override
	public ContentsDetailViewVO contentsDetailViewSearch(String memberId, String contentCode) {	
		return contentsDetailViewMapper.searchContentsDetailView(memberId, contentCode);
	}
}
