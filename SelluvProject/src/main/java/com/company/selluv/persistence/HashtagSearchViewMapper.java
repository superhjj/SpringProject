package com.company.selluv.persistence;

import java.util.List;

import com.company.selluv.domain.vo.HashtagSearchViewVO;

public interface HashtagSearchViewMapper {
	public List<HashtagSearchViewVO> searchHashtagSearchView(String hashtagName);
}
