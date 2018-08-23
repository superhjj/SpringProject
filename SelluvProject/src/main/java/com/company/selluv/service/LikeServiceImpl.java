package com.company.selluv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.domain.dto.LikeDTO;
import com.company.selluv.domain.dto.OrderMemberDTO;
import com.company.selluv.domain.dto.ProfileDTO;
import com.company.selluv.persistence.LikeMapper;

@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeMapper likeMapper;
	
	private static int likeNumber;
	
	private String generateLikeCode() {
		likeNumber++;
		return "like-"+likeNumber;
	}
	
	public boolean loadLikeList() {
			
		List<LikeDTO> likeList = likeMapper.loadLikeList();
		
		int maxNum = 0;
		
		for(LikeDTO likeDTO: likeList) {
			likeNumber = Integer.parseInt(likeDTO.getLikeCode().substring(5));
			if(maxNum < likeNumber) {
				maxNum = likeNumber;
			}
		}
		likeNumber = maxNum;
		
		return true;
	}
	
	@Override
	public boolean likeAdd(String memberId, String contentsCode) {
		if(memberId==null||contentsCode==null) return false;
		loadLikeList();
		String likeCode = generateLikeCode();
		LikeDTO likeDTO = new LikeDTO();
		likeDTO.setLikeCode(likeCode);
		likeDTO.setMemberId(memberId);
		likeDTO.setContentsCode(contentsCode);
		
		likeMapper.addLike(likeDTO);
		
		return true;
	}	
	
	@Override
	public boolean likeDelete(String memberId, String contentsCode) {
		likeMapper.deleteLike(memberId, contentsCode);
		return true;
	}
	@Override
	public String likeCodeSearch(String memberId,String contentsCode) {
		return likeMapper.searchLikeCode(memberId, contentsCode);
	}
	@Override
	public List<ProfileDTO> likeMemberSearch(String contentsCode){
		return likeMapper.searchLikeMember(contentsCode);
	}
	@Override
	public List<ContentDTO> likeSearch(String memberId){
		return likeMapper.searchLike(memberId);
	}
	
}
