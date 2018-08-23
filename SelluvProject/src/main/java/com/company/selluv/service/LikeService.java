package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.domain.dto.LikeDTO;
import com.company.selluv.domain.dto.ProfileDTO;

public interface LikeService {
	public boolean likeAdd(String memberId, String contentsCode);
	
	public boolean likeDelete(String memberId,String contentsCode);
	
	public String likeCodeSearch(String memberId,String contentsCode);
	
	public List<ProfileDTO> likeMemberSearch(String contentsCode);
	
	public List<ContentDTO> likeSearch(String memberId);
	
	public boolean loadLikeList();
	
}
