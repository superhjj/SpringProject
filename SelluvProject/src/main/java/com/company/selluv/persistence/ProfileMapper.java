package com.company.selluv.persistence;

import java.util.List;
import java.util.Map;

import com.company.selluv.domain.dto.ProfileDTO;

public interface ProfileMapper {
	public void addProfile(ProfileDTO pro) throws Exception;
	
	public void deleteProfile(String member_id) throws Exception;
	
	public void updateProfile(ProfileDTO pro) throws Exception;
	
	public void updateProfileImg(Map<String, String> map) throws Exception;
	
	public void updateProfileIntro(Map<String, String> map) throws Exception;
	
	public void updateProfileWebSite(Map<String, String> map) throws Exception;
	
	public ProfileDTO searchProfileById(String member_id) throws Exception;
	
	public List<ProfileDTO> searchProfileAll() throws Exception;
}
