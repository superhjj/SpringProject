package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.dto.FollowDTO;
import com.company.selluv.domain.dto.MemberDTO;

public interface FollowService {
	public boolean followAdd(String followId, String followerId);
	
	public boolean followDelete(String followId, String followerId);
	
	public List<MemberDTO> followSearch(String followerId);
	
	public List<MemberDTO> followerSearch(String followId);
	
	public List<FollowDTO> followSearchAll();
}
