package com.company.selluv.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.selluv.domain.dto.HashtagDTO;
import com.company.selluv.service.HashtagService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class HashtagServiceTest {

	@Autowired
	private HashtagService service;
	private static final Logger logger = LoggerFactory.getLogger(HashtagServiceTest.class);
	
	@Test
	public void testDeleteHashtag() {
		//hashtag code 넣기
		boolean flag = service.deleteHashtag("");
		logger.info("testDeleteHashtag : "+ flag);
	}
	
	@Test
	public void testSearchHashtagByCode() {
		//해시태그 코드 넣기
		HashtagDTO dto = service.searchHashtag("hashtag_code");
		logger.info("testSearchHashtagByCode : "+dto);
	}
	
	@Test
	public void testsearchHashtagByName() {
		//해시태그 name 넣기
		List<HashtagDTO> list = service.searchHashtag("hashtag_name", 1);
		logger.info("testsearchHashtagByName : "+list);
	}
	

}
