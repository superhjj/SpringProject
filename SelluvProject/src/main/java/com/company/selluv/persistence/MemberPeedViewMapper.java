package com.company.selluv.persistence;

import com.company.selluv.domain.vo.MemberPeedViewVO;

public interface MemberPeedViewMapper {
	public MemberPeedViewVO searchMemberPeedView(String memberId);
}
