package com.company.selluv.persistence;

import com.company.selluv.domain.vo.MemberPeedFollowerViewVO;

public interface MemberPeedFollowerViewMapper {
	MemberPeedFollowerViewVO searchFollowerView(String memberId);
}
