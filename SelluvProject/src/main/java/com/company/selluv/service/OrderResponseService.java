package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.dto.FormResponseDTO;
import com.company.selluv.domain.dto.OrderMemberDTO;

public interface OrderResponseService {
	boolean loadFormResponseList();
	boolean loadOrderMemberList();
	boolean orderResponseInsert(String memberId, String formCode, List<String> titleList, List<String> responseList, String peedId);
	boolean orderMemberInsert(String formResponseCode, String memberId);
	
	public boolean orderResponseListDelete(String formResponseCode);
	public boolean orderResponseDelete(String formCode, int flag);
	public FormResponseDTO orderResponseSearch(String formResponseCode);
	public List<FormResponseDTO> orderResponseSearch(String formCode, int flag);
	public boolean orderMemberDelete(String memberId);
	public boolean orderMemberDelete(String orderMemberCode, int flag);
	public List<OrderMemberDTO> orderMemberSearch(String memberId);
	public OrderMemberDTO orderMemberSearch(String orderMemberCode, int flag);
}
