package com.company.selluv.persistence;

import java.util.List;

import com.company.selluv.domain.vo.FollowViewVO;

public interface FollowerViewMapper {
	List<FollowViewVO> searchFollowerView(String memberId);
}
