package com.company.selluv.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.ItemVO;

@Service
public interface OrderSheetService {
	public Map<String, ItemVO> SearchOrderSheet(String formCode, String memberId);
}
