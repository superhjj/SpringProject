package com.company.selluv.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.FollowDTO;
import com.company.selluv.domain.dto.MemberDTO;
import com.company.selluv.persistence.FollowMapper;

@Service
public class FollowServiceImpl implements FollowService{
	@Autowired
	private FollowMapper follow;
	
	@Override
	public boolean followAdd(String followId, String followerId) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			FollowDTO add = new FollowDTO();
			add.setFollowNum(generateFollowCode());
			add.setFollowId(followId);
			add.setFollowerId(followerId);
			
			follow.addFollow(add);
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}
	
	
	 /* followDelete
	  매개변수에 followId와 follwerId를 세팅하여야 한다.*/
	 
	@Override
	public boolean followDelete(String followId, String followerId) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			FollowDTO delete = new FollowDTO();
			delete.setFollowId(followId);
			delete.setFollowerId(followerId);
			
			follow.deleteFollow(delete);
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}

	@Override
	public List<MemberDTO> followSearch(String followerId) {
		// TODO Auto-generated method stub
		List<MemberDTO> search = null;
		
		try {
			search = follow.searchFollow(followerId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return search;
	}

	@Override
	public List<MemberDTO> followerSearch(String followId) {
		// TODO Auto-generated method stub
		List<MemberDTO> search = null;
		
		try {
			search = follow.searchFollower(followId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return search;
	}

	@Override
	public List<FollowDTO> followSearchAll() {
		List<FollowDTO> list = null;
		
		try {
			list = follow.searchFollowAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	private String generateFollowCode() {
		List<FollowDTO> list = null;
		String follow_code = null;
		int max = 0;
		
		try {
			list = followSearchAll();
			
			for(FollowDTO elem : list) {
				int num = Integer.parseInt(elem.getFollowNum().substring(7));
				
				if(num > max) {
					max = num;
				}
			}
			
			follow_code = "follow-" + (max + 1);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return follow_code;
	}
}
