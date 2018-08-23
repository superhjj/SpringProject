package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.vo.OrderMemberDetailVO;
import com.company.selluv.domain.vo.OrderMemberViewVO;

public interface OrderMemberViewService {
	public List<OrderMemberViewVO> orderMemberViewSearch(String form_code);
	public List<OrderMemberDetailVO> orderMemberDetailSearch(String myId, String form_code, String member_id);
}
