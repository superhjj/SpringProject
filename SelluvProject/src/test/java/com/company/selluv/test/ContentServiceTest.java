package com.company.selluv.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.selluv.domain.dto.ContentDTO;
import com.company.selluv.service.ContentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ContentServiceTest {
	@Autowired
	private ContentService contentService;
	
	private static Logger logger = LoggerFactory.getLogger(ContentServiceTest.class);

	@Test
	public void contentLoadTest() {
		contentService.contentLoadList();
		
	}
	
	@Test
	public void addContentImgTest() {
		contentService.contentAddImg("MyBatisInsertTest1", "gam2.jpg", "superhjj33");
	}
	
	@Test
	public void addContentImgNoneContextTest() {
		contentService.contentAddImgNoneContext("gam3.jpg", "superhjj33");		
	}
	
	@Test
	public void addContentVideo() {
		contentService.contentAddVideo("MyBatisVideo1", "video1", "superhjj33");
	}
	
	@Test
	public void addContentVideoNoneContextTest() {
		contentService.contentAddVideoNoneContext("video2", "superhjj33");
	}
	
	@Test
	public void searchContentByContentCodeTest(){
		ContentDTO contentDTO=null;
		contentDTO=contentService.contentByContentCodeSearch("contentCode-8");
		logger.info(contentDTO.getContentsText());
	}
	
	@Test
	public void searchContentByCodeAndIdTest(){
		ContentDTO contentDTO=null;
		contentDTO=contentService.contentByCodeAndIdSearch("contentCode-4", "superhjj33");
		logger.info(contentDTO.getContentsText());
	}
	
	@Test
	public void searchContentByMemberIdTest(){
		List<ContentDTO> list=null;
		list=contentService.contentByMemberIdSearch("superhjj33");
		for(int i=0;i<list.size();i++) {
			logger.info(list.get(i).getContentsText());
		}
	}
	
	@Test
	public void updateContentTextByContentCodeTest(){
		ContentDTO contentDTO=null;
		contentDTO=contentService.contentTextByContentCodeUpdate("contentCode-4", "°í¿äÇÏ°í ½Î´ÃÇÑ ±æ #°ñ¸ñ±æ");
		logger.info(contentDTO.getContentsText());
	}
	
	@Test
	public void updateContentHiddenTest(){
		contentService.contentHiddenUpdate("Y", "contentCode-4");
		
	}
	
	@Test
	public void deleteContentTest(){
		contentService.contentDelete("contentCode-5", "superhjj33");
		
	}
	
	@Test
	public void searchContentTextTest(){
		List<ContentDTO> list=null;
		list=contentService.contentTextSearch("#");
		for(int i=0;i<list.size();i++) {
			logger.info(list.get(i).getContentsText());
		}
	}
}
