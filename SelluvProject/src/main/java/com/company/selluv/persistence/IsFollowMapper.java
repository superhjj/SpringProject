package com.company.selluv.persistence;

import org.apache.ibatis.annotations.Param;

import com.company.selluv.domain.vo.FollowVO;

public interface IsFollowMapper {
	public FollowVO isSearchFollow(@Param("followId")String followId, @Param("followerId")String followerId);
}
