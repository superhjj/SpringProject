package com.company.selluv.persistence;

import java.util.List;

import com.company.selluv.domain.dto.FollowDTO;
import com.company.selluv.domain.dto.MemberDTO;

public interface FollowMapper {
	public void addFollow(FollowDTO follow) throws Exception;
	
	public void deleteFollow(FollowDTO follow) throws Exception;
	
	public List<MemberDTO> searchFollow(String follower_id) throws Exception;
	
	public List<MemberDTO> searchFollower(String follow_id) throws Exception;
	
	public List<FollowDTO> searchFollowAll() throws Exception;
}
