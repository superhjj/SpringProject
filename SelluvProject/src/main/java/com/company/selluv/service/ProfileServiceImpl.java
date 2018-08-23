package com.company.selluv.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.ProfileDTO;
import com.company.selluv.persistence.ProfileMapper;

@Service
public class ProfileServiceImpl implements ProfileService{
	@Autowired
	private ProfileMapper profile;
	
	@Override
	public ProfileDTO profileAdd(String memberId, String profileIntro, String profileImg, String profileWebsite) {
		// TODO Auto-generated method stub
		ProfileDTO add = null;
		
		try {
			add = new ProfileDTO();
			String id = generateProfileId();
			System.out.println("proifle_id : " + id);
			add.setProfileId(id);
			add.setMemberId(memberId);
			add.setProfileIntro(profileIntro);
			add.setProfileImg(profileImg);
			add.setProfileWebSite(profileWebsite);
			
			profile.addProfile(add);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return add;
	}

	@Override
	public ProfileDTO profileDelete(String memberId) {
		// TODO Auto-generated method stub
		ProfileDTO delete = null;
		
		try {
			delete = profileSearch(memberId);
			profile.deleteProfile(memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return delete;
	}

	@Override
	public ProfileDTO profileImgUpdate(String memberId, String profileImg) {
		ProfileDTO update = null;
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("member_id", memberId);
			map.put("profile_img", profileImg);
			
			profile.updateProfileImg(map);
			update = profileSearch(memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return update;
	}

	@Override
	public ProfileDTO profileIntroUpdate(String memberId, String profileIntro) {
		// TODO Auto-generated method stub
		ProfileDTO update = null;
		
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("member_id", memberId);
			map.put("profile_intro", profileIntro);
			
			profile.updateProfileIntro(map);
			update = profileSearch(memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return update;
	}

	@Override
	public ProfileDTO profileWebSiteUpdate(String memberId, String profileWebSite) {
		// TODO Auto-generated method stub
		ProfileDTO update = null;
		
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("member_id", memberId);
			map.put("profile_website", profileWebSite);
			
			profile.updateProfileWebSite(map);
			
			update = profileSearch(memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return update;
	}

	@Override
	public ProfileDTO profileSearch(String memberId) {
		// TODO Auto-generated method stub
		ProfileDTO search = null;
		
		try {
			search = profile.searchProfileById(memberId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return search;
	}

	@Override
	public List<ProfileDTO> profileSearchAll() {
		List<ProfileDTO> result = null;
		
		try {
			result = profile.searchProfileAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	private String generateProfileId() {
		String profile_id = null;
		List<ProfileDTO> list = profileSearchAll();
		
		int max = 0;
		
		if(list != null) {
			for(ProfileDTO elem : list) {
				int num = Integer.parseInt(elem.getProfileId().substring(8));
				
				if(num > max) {
					max = num;
				}
			}
			profile_id = "profile-" + (max + 1); 
		}
		
		return profile_id;
	}

	@Override
	public ProfileDTO profileUpdate(String memberId, String profileIntro, String profileImg, String profileWebsite) {
		ProfileDTO update = null;
		
		try {
			update = new ProfileDTO(memberId, profileIntro, profileImg, profileWebsite);
			profile.updateProfile(update);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return update;
	}
}
