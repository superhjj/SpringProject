package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.dto.ProfileDTO;

public interface ProfileService {
	public ProfileDTO profileAdd(String memberId, String profileIntro, String profileImg, String profileWebsite);
	
	public ProfileDTO profileDelete(String memberId);
	
	public ProfileDTO profileUpdate(String memberId, String profileIntro, String profileImg, String profileWebsite);
	
	public ProfileDTO profileImgUpdate(String memberId, String profileImg);
	
	public ProfileDTO profileIntroUpdate(String memberId, String profileIntro);
	
	public ProfileDTO profileWebSiteUpdate(String memberId, String profileWebSite);
	
	public ProfileDTO profileSearch(String memberId);
	
	public List<ProfileDTO> profileSearchAll();
}
