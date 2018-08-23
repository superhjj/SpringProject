package com.company.selluv.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.FormResponseDTO;
import com.company.selluv.domain.dto.OrderMemberDTO;
import com.company.selluv.persistence.OrderResponseMapper;

@Service
public class OrderResponseServiceImpl implements OrderResponseService {

	@Autowired
	private OrderResponseMapper orderResponseMapper;
	private static int formResponseNum;
	private static int orderMemberNum;
	private static final Logger logger = LoggerFactory.getLogger(OrderResponseServiceImpl.class);

	
	@Override
	public boolean orderResponseListDelete(String formResponseCode) {
		// TODO Auto-generated method stub
		try {
			orderResponseMapper.deleteOrderResponseList(formResponseCode);
			return true;
		} catch (Exception e) {
			logger.error("orderResponseListDelete 에러");
		}
		return false;
	}

	@Override
	public boolean orderResponseDelete(String formCode, int flag) {
		// TODO Auto-generated method stub
		try {
				orderResponseMapper.deleteOrderResponse(formCode);
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("orderResponseDelete error");
		}

		return false;
	}

	@Override
	public FormResponseDTO orderResponseSearch(String formResponseCode) {
		// TODO Auto-generated method stub
		try {
			FormResponseDTO dto = orderResponseMapper.searchOrderResponseCode(formResponseCode);
			return dto;
		} catch (Exception e) {
			logger.error("formResponseCode로 orderResponseSearch 에러");
		}
		return null;
	}

	@Override
	public List<FormResponseDTO> orderResponseSearch(String formCode, int flag) {
		// TODO Auto-generated method stub
		try {
			List<FormResponseDTO> list = orderResponseMapper.searchOrderResponseForm(formCode);
			return list;
		} catch (Exception e) {
			logger.error("formCode로 orderResponseSearch 에러");
		}
		return null;
	}

	@Override
	public boolean orderMemberDelete(String memberId) {
		// TODO Auto-generated method stub
		try {
			orderResponseMapper.deleteOrderMemberByMember(memberId);
			return true;
		} catch (Exception e) {
			logger.error("memberId로 orderMemberDelete 에러");
		}
		return false;
	}

	@Override
	public boolean orderMemberDelete(String orderMemberCode, int flag) {
		try {
			orderResponseMapper.deleteOrderMemberByCode(orderMemberCode);
			return true;
		} catch (Exception e) {
			logger.error("orderMemberCode로 orderMemberDelete 에러");
		}
		return false;
	}

	@Override
	public List<OrderMemberDTO> orderMemberSearch(String memberId) {
		// TODO Auto-generated method stub
		try {
			List<OrderMemberDTO> list  = orderResponseMapper.searchOrderMemberByMember(memberId);
			return list;
		} catch (Exception e) {
			logger.error("memberId로 orderMemberSearch 에러");
		}
		return null;
	}

	@Override
	public OrderMemberDTO orderMemberSearch(String orderMemberCode, int flag) {
		// TODO Auto-generated method stub
		try {
			OrderMemberDTO dto  = orderResponseMapper.searchOrderMemberByCode(orderMemberCode);
			return dto;
		} catch (Exception e) {
			logger.error("memberId로 orderMemberSearch 에러");
		}
		return null;
	}

	public String generateFormResponseCode() {
		formResponseNum++;
		return "form-response-" + formResponseNum;
	}
	
	public String generateOrderMemberCode() {
		orderMemberNum++;
		return "order-member-" + orderMemberNum;
	}
	
	@Override
	public boolean loadFormResponseList() {
		List<FormResponseDTO> formResponseList = orderResponseMapper.loadFormResponseList();
		int maxNum = 0;
		
		for(FormResponseDTO formResponse: formResponseList) {
			formResponseNum = Integer.parseInt(formResponse.getFormResponseCode().substring(14));
			if(maxNum < formResponseNum) {
				maxNum = formResponseNum;
			}
		}
		formResponseNum = maxNum;
		
		return true;
	}
	
	@Override
	public boolean loadOrderMemberList() {
		
		List<OrderMemberDTO> orderMemberList = orderResponseMapper.loadOrderMemberList();
		int maxNum = 0;
		
		for(OrderMemberDTO orderMember: orderMemberList) {
			orderMemberNum = Integer.parseInt(orderMember.getOrderMemberCode().substring(13));
			if(maxNum < orderMemberNum) {
				maxNum = orderMemberNum;
			}
		}
		orderMemberNum = maxNum;
		
		return true;
	}
	
	@Override
	public boolean orderResponseInsert(String memberId, String formCode, 
			List<String> titleList, List<String> responseList, String peedId) {
		
		loadFormResponseList();
		String formResponseCode = generateFormResponseCode();
		
		orderResponseMapper.addOrderResponse(formResponseCode, formCode);
		
		orderResponseFileInsert(memberId, formCode, titleList, responseList, peedId);
		orderMemberInsert(formResponseCode, memberId);
		
		return true;
	}
	
	public boolean orderResponseFileInsert(String memberId, String formCode, 
			List<String> titleList, List<String> responseList, String peedId) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String orderDate = sdf.format(new Date());
		
		StringBuffer sb = new StringBuffer();
		
		for(String titleTmp: titleList) {
			sb.append(titleTmp + "/");
		}
		String title = sb.toString();
		
		sb.delete(0, sb.length());
		
		for(String responseTmp: responseList) {
			sb.append(responseTmp + "/");
		}
		String response = sb.toString();
		
		String filePath = "C:\\Users\\user\\Documents\\workspace-sts-3.9.5.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Selluv\\resources\\form\\"+peedId+"\\"+formCode;
		try {
			File file = new File(filePath);
			File file2 = new File(filePath+"\\"+formCode+"_response.txt");
			
			BufferedWriter bw = null;
			boolean isExist = file.exists();
			
			if(!isExist) {
				file.mkdirs();
			}
			if(!file2.exists()) {
				FileOutputStream output = new FileOutputStream(filePath+"\\"+formCode+"_response.txt");
				bw = new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
				bw.write("주문서작성날짜/주문자ID/"+title);
				bw.newLine();
			}
			else {
				FileOutputStream output = new FileOutputStream(filePath+"\\"+formCode+"_response.txt", true);
				bw =  new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
			}
			
			bw.write(orderDate + "/" + memberId + "/" + response);
			bw.newLine();
			bw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	@Override
	public boolean orderMemberInsert(String formResponseCode, String memberId) {
		
		loadOrderMemberList();
		String orderMemberCode = generateOrderMemberCode();
		
		orderResponseMapper.addOrderMember(orderMemberCode, formResponseCode, memberId);
		
		return true;
	}
}
