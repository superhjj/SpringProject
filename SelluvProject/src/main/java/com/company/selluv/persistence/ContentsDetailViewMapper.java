package com.company.selluv.persistence;

import org.apache.ibatis.annotations.Param;

import com.company.selluv.domain.vo.ContentsDetailViewVO;

public interface ContentsDetailViewMapper {
	public ContentsDetailViewVO searchContentsDetailView(@Param("memberId")String memberId,@Param("contentCode")String contentCode);
}
