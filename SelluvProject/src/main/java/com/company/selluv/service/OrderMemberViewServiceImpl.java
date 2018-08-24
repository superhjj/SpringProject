package com.company.selluv.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.vo.OrderMemberDetailVO;
import com.company.selluv.domain.vo.OrderMemberViewVO;
import com.company.selluv.persistence.OrderMemberViewMapper;

@Service
public class OrderMemberViewServiceImpl implements OrderMemberViewService{
	private Logger logger = LoggerFactory.getLogger(OrderMemberViewServiceImpl.class);
	
	@Autowired
	OrderMemberViewMapper orderMemberViewMapper;
	
	@Override
	public List<OrderMemberViewVO> orderMemberViewSearch(String form_code){
		return orderMemberViewMapper.searchOrderMemberView(form_code);
	}
	
	@Override	
	public List<OrderMemberDetailVO> orderMemberDetailSearch(String myId, String form_code, String member_id) {
		/*
		 * �ֹ���¥�� �ֹ��� ID, �׸� ������ �����ϴ� order ��ü
		 */
		OrderMemberDetailVO order = new OrderMemberDetailVO();
		
		/*
		 * ���� ����� �����ϴ� orderMemberList ��ü
		 */
		List<OrderMemberDetailVO> orderMemberDetailList = new ArrayList<OrderMemberDetailVO>();
		
		logger.info(myId);
		
		OrderMemberDetailVO orderMemberList = new OrderMemberDetailVO();
	    
		FileInputStream ifs = null;
		try {
			//��� ���� sts�� �����ؾ� ��!!/////////////////////////////////////////////////////////////////////////////////////////////////
			ifs = new FileInputStream("C:\\Users\\HYH\\Documents\\workspace-sts-3.9.5.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Selluv\\resources\\form\\"+ myId +"\\"+ form_code + "\\" + form_code + "_response.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader isr= null;
		try {
			isr = new InputStreamReader(ifs, "euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = null;
		
		/*
		 * �� ù��° �� �о���� (�ֹ��� �ۼ�����, �ֹ��� id, �׸�����)
		 */
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st = new StringTokenizer(line, "/");
		int content_count = st.countTokens();
		int order_cnt = 0;
		String[] orderTitles = new String[content_count - 2];
		
		while(st.hasMoreTokens()){
			String item = st.nextToken();
			
			switch(order_cnt){
			case 0:{
				order.setOrder_date(item);
				break;
			}
			case 1:{
				order.setOrder_member(item);
				break;
			}
			default:{
				orderTitles[order_cnt - 2] = item;
				break;
			}
			}
			
			order_cnt++;
		}
		
		order.setAnswer(orderTitles);
		content_count -= 2;
		
		/*
		 * �ۼ��ڵ��� ���䳻���� �о����
		 */
		try {
			while((line = br.readLine()) != null) {
				st = new StringTokenizer(line, "/");
				int count = 0;
				boolean result = false;
				String order_date = null;
				String order_member = null;
				String[] answer = null;
				
				while(st.hasMoreTokens()){
					String item = st.nextToken();
					if(result){
						answer[count - 2] = item;
					}
					
					if(count < 2){
						switch(count){
							case 0:{
								order_date = item;
								break;
							}
							case 1:{
								order_member = item;
								
								if(order_member.equals(member_id)){
									answer = new String[content_count];
									result = true;
								}
								
								break;
							}
							default:{
								break;
							}
						}
					}
					count++;
				}
				
				if(answer != null){
					OrderMemberDetailVO omd = new OrderMemberDetailVO(order_date, order_member, answer);
					orderMemberList = omd;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		orderMemberDetailList.add(order);
		orderMemberDetailList.add(orderMemberList);
		
		return orderMemberDetailList;
	}
}
