package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.vo.HashtagSearchViewVO;

public interface HashtagSearchViewService {
	public List<HashtagSearchViewVO> hashtagSearchViewSearch(String hashtagName);
}
