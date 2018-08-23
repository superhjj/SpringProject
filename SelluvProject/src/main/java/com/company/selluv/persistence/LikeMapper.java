package com.company.selluv.persistence;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.domain.dto.LikeDTO;
import com.company.selluv.domain.dto.ProfileDTO;

public interface LikeMapper {
	
	public void addLike(LikeDTO likeDTO);
	
	public boolean deleteLike(@Param("memberId")String memberId,@Param("contentsCode")String contentsCode);
	
	public String searchLikeCode(@Param("memberId")String memberId, @Param("contentsCode")String contentsCode);
	
	public List<ProfileDTO> searchLikeMember(String contentsCode);
	
	public List<ContentDTO> searchLike(String memberId);

	public List<LikeDTO> loadLikeList();
}