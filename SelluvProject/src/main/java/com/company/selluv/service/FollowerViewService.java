package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.vo.FollowViewVO;

public interface FollowerViewService {

	List<FollowViewVO> followerViewSearch(String memberId);
}
