package com.company.selluv.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.selluv.domain.dto.FormResponseDTO;
import com.company.selluv.domain.dto.OrderMemberDTO;

public interface OrderResponseMapper {
List<FormResponseDTO> loadFormResponseList();
	
	List<OrderMemberDTO> loadOrderMemberList();
	void addOrderResponse(@Param("formResponseCode")String formResponseCode, @Param("formCode")String formCode);
	void addOrderMember(@Param("orderMemberCode")String orderMemberCode, @Param("formResponseCode")String formResponseCode, @Param("memberId")String memberId);
	public void deleteOrderResponseList(String formResponseCode);
	public void deleteOrderResponse(String formCode);
	public FormResponseDTO searchOrderResponseCode(String formResponseCode);
	public List<FormResponseDTO> searchOrderResponseForm(String formCode);
	public void deleteOrderMemberByMember(String memberId);
	public void deleteOrderMemberByCode(String orderMemberCode);
	public List<OrderMemberDTO> searchOrderMemberByMember(String memberId);
	public OrderMemberDTO searchOrderMemberByCode(String orderMemberCode);
}
