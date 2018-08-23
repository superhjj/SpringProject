package com.company.selluv.persistence;

import java.util.List;

import com.company.selluv.domain.vo.MainPeedViewVO;

public interface MainPeedViewMapper {

	List<MainPeedViewVO> searchMainPeedView(String memberId);
	
	MainPeedViewVO searchMainPeedViewByContentsCode(String contentCode);
	
}
