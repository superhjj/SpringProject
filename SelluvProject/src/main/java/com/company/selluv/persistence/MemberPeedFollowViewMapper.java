package com.company.selluv.persistence;

import com.company.selluv.domain.vo.MemberPeedFollowViewVO;

public interface MemberPeedFollowViewMapper {
	MemberPeedFollowViewVO searchFollowView(String memberId);
}
