package com.company.selluv.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selluv.domain.dto.CommentDTO;
import com.company.selluv.persistence.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	
	private Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);
	
	@Autowired
	private CommentMapper commentMapper;
	
	private static int commentNum;
	
	private String generateCommentCode(){
		commentNum++;
		return "commentCode-"+commentNum;
	}

	@Override
	public boolean loadCommentList() {
		
		List<CommentDTO> commentList = commentMapper.loadCommentList();
		int maxNum = 0;
		
		for(CommentDTO comment: commentList) {
			commentNum = Integer.parseInt(comment.getCommentCode().substring(12));
			if(maxNum < commentNum) {
				maxNum = commentNum;
			}
		}
		commentNum = maxNum;
		
		return true;
	}

	@Override
	public CommentDTO commentInsert(String memberId, String commentText, String contentsCode) {
		
		loadCommentList();
		
		String commentCode = generateCommentCode();
		logger.info("commentCode °ª : " + commentCode);
		commentMapper.addComment(commentCode, memberId, commentText, contentsCode);
		Timestamp commentDate = Timestamp.valueOf(LocalDateTime.now());
		CommentDTO commentDTO = new CommentDTO(commentCode, memberId, commentText, commentDate, contentsCode);
		return commentDTO;
	}

	@Override
	public boolean commentDelete(String memberId, String commentCode) {
		
		commentMapper.deleteComment(memberId, commentCode);
		
		return true;
	}

	@Override
	public boolean commentDeleteByAll(String commentCode, String contentsCode, String memberId) {
		
		commentMapper.deleteCommentByAll(commentCode, contentsCode, memberId);
		
		return true;
	}

	@Override
	public boolean commentDeleteByContents(String contentsCode) {
		
		commentMapper.deleteCommentByContents(contentsCode);
		
		return true;
	}

	@Override
	public List<CommentDTO> commentSearchByContents(String contentsCode) {
		
		return commentMapper.searchCommentByContents(contentsCode);
	}

	@Override
	public CommentDTO commentSearchByComment(String commentCode, String memberId) {
		
		return commentMapper.searchCommentByComment(commentCode, memberId);
	}

}
