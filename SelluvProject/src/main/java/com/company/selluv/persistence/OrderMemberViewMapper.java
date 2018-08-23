package com.company.selluv.persistence;

import java.util.List;

import com.company.selluv.domain.vo.OrderMemberViewVO;

public interface OrderMemberViewMapper {
	public List<OrderMemberViewVO> searchOrderMemberView(String form_code);
}
