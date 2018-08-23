package com.company.selluv.service;

import java.util.List;

import com.company.selluv.domain.dto.CommentDTO;

public interface CommentService {
	
	boolean loadCommentList();
	
	CommentDTO commentInsert(String memberId, String commentText, String contentsCode);
	
	boolean commentDelete(String memberId, String commentCode);
	
	boolean commentDeleteByAll(String commentCode, String contentsCode, String memberId);
	
	boolean commentDeleteByContents(String contentsCode);
	
	List<CommentDTO> commentSearchByContents(String contentsCode);
	
	CommentDTO commentSearchByComment(String commentCode, String memberId);
	
}
