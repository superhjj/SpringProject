package com.company.selluv.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.company.selluv.domain.vo.ItemVO;

public class OrderSheetServiceImpl implements OrderSheetService{

	@Override
	public Map<String, ItemVO> SearchOrderSheet(String formCode, String memberId) {
		try {
			String filePath = "C:\\sts-bundle\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Selluv\\form\\"+memberId+"\\"+formCode;
			File file = new File(filePath + "\\" + formCode + ".txt"); // form-1, id1
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line = null;
			Map<String, ItemVO> searchList = new HashMap<String, ItemVO>();
			//1/亲格力格/亲格汲疙/N/sa
			//public ItemVO(String itemNum, String itemTitle, String itemDescript, String itemNecessary, String itemType)
			while((line = br.readLine()) != null) {
				String[] list = line.split("/");
				ItemVO item = null;
				if(list.length == 5) {
						item = new ItemVO(list[0],list[1], list[2], list[3], list[4]);
				}
				else if(list.length == 6) {
					 item = new ItemVO(list[0],list[1], list[2], list[3], list[4], list[5]);					
				}
								
				searchList.put(list[0], item);
			}
			return searchList;
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
