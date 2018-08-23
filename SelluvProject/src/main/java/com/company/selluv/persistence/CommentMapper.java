package com.company.selluv.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.selluv.domain.dto.CommentDTO;

public interface CommentMapper {
	
	List<CommentDTO> loadCommentList();
	
	void addComment(@Param("commentCode")String commentCode, @Param("memberId")String memberId, @Param("commentText")String commentText, @Param("contentsCode")String contentsCode);

	void deleteComment(@Param("memberId")String memberId, @Param("commentCode")String commentCode);
	
	void deleteCommentByAll(@Param("commentCode")String commentCode,  @Param("contentsCode")String contentsCode, @Param("memberId")String memberId);
	
	void deleteCommentByContents( @Param("contentsCode")String contentsCode);
	
	List<CommentDTO> searchCommentByContents( @Param("contentsCode")String contentsCode);
	
	CommentDTO searchCommentByComment(@Param("commentCode")String commentCode, @Param("memberId")String memberId);
	
}
