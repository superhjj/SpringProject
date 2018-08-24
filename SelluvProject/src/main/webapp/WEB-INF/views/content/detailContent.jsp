<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
/*
 * 댓글 불러오기
 */
	function loadComment(){
		while(document.getElementById('commentList').hasChildNodes()){
			document.getElementById('commentList').removeChild(document.getElementById('commentList').firstChild);
		}
		var comment = new XMLHttpRequest();
		
		comment.open('GET', 'commentSearch.do?contentCode=' + encodeURIComponent(document.getElementById('contentCode').value), true);
		
		comment.onreadystatechange = function() {
			if(comment.readyState == 4 && comment.status == 200){
				var comm = JSON.parse(comment.responseText);
				var list = document.createElement('div');
				var str = '';
				
				for(var i = 0; i < comm.length; i++){
					str += '<li><div><div>' + comm[i].memberId + '</div></div><div><div>' + comm[i].commentText + '</div></div>' + 
					'<form id=\"comment-form-' + i + '\" action=\"../commentDelete.do\" method=\"GET\"> <input id=\"member-' + i + '\" name=\"memberId\" type=\"hidden\" value=\"'+ comm[i].memberId + '\">' +
					'<input id=\"comment-' + i + '\" name=\"commentCode\" type=\"hidden\" value=\"' + comm[i].commentCode + '\">' +
					'<input id=\"content-'+ i + '\" name=\"contentCode\" type=\"hidden\" value=\"' + document.getElementById('contentCode').value + '\">' + 
					'<input id=\"writer-' + i + '\" name=\"writer\" type=\"hidden\" value=\"' + document.getElementById('writer').value + '\">' + 
					'<button type=\"button\" id=\"comment-delete-btn-' + i + '\">삭제</button></form>'+
					'</div>';
				}
				
				list.innerHTML = str;
				document.getElementById('commentList').append(list);
				
				for(var i = 0; i < comm.length; i++){
					$('#comment-delete-btn-' + i).click(function(){
						this.parentNode.submit();
					});
				}
			}
		}
		comment.send(null);
	}
	
	$(document).ready(function(){
		$('#comment-btn').click(function(){
			console.log('추가 버튼 클릭');
			var comment = new XMLHttpRequest();
			comment.open('POST', 'commentInsert.do?commentText=' + encodeURIComponent(document.getElementById('inputComment').value) + 
					'&contentCode='+encodeURIComponent(document.getElementById('contentCode').value) + "&memberId=" + encodeURIComponent(document.getElementById('memberId').value), true);
			/* 마지막에 memberId를 삭제해야 함 */
			comment.onreadystatechange = function(){
				if(comment.readyState == 4 && comment.status == 200){
					var comm = JSON.parse(this.responseText);
					var str = '';
					var list = document.createElement('div');
					
					var size = document.getElementById('commentList').firstChild.childNodes.length;
					console.log('댓글의 개수 : ' + size);
					
					str += '<li><div><div>' + comm.memberId + '</div></div><div><div>' + comm.commentText + '</div></div>' + 
					'<form id=\"comment-form-' + (size + 1) + '\" action=\"../commentDelete.do\" method=\"GET\"> <input id=\"member-' + (size + 1) + '\" name=\"memberId\" type=\"hidden\" value=\"'+ comm.memberId + '\">' +
					'<input id=\"comment-' + (size + 1) + '\" name=\"commentCode\" type=\"hidden\" value=\"' + comm.commentCode + '\">' +
					'<input id=\"content-'+ (size + 1) + '\" name=\"contentCode\" type=\"hidden\" value=\"' + document.getElementById('contentCode').value + '\">' + 
					'<input id=\"writer-' + (size + 1) + '\" name=\"writer\" type=\"hidden\" value=\"' + document.getElementById('writer').value + '\">' + 
					'<button type=\"button\" id=\"comment-delete-btn-' + (size + 1) + '\">삭제</button></form>'+
					'</div>';;
					
					list.innerHTML = str;
					document.getElementById('commentList').append(list);
					
					$('#comment-delete-btn-' +(size + 1)).click(function(){
						this.parentNode.submit();
					});
				}
			}
			comment.send(null);
			$('#inputComment').val('');
			loadComment();
		});
		
		$('#comment-load-btn').click(function(){
			loadComment();
		});
		
		$('#comment-load-btn').click();
	});
</script>
<style>
	.commentList{
		height:500px;
		width:500px;
		border:1px solid black;
	}
</style>
</head>
<body>
	${ contentsDetailView.profileImg } <br/>
	${ contentsDetailView.memberId } <br/>
	${ contentsDetailView.contentsImg }<br/>
	${ contentsDetailView.contentsText }<br/>
	${ contentsDetailView.likeCnt }<br/>
	${ contentsDetailView.contentCode }<br/>
	
	hashtag 나타나기<br/>
	<c:forEach items="${ hashtag }" var="var">
		${ var }<br/>
	</c:forEach>
	댓글 검색창<br/>
	<button type="button" id="comment-load-btn">검색</button>
	<input type="hidden" id="memberId" name="memberId" value="id3"> <!-- session의 회원 ID로 value를 변경해야 함 -->
	<input type="hidden" id="writer" name="writer" value="${ contentsDetailView.memberId }">
 	<input type="hidden" id="contentCode" name="contentCode" value="${ contentsDetailView.contentCode }">
	댓글 입력창<br/>
	<input type="text" placeholder="댓글 입력..." id="inputComment" class="inputComment" name="commentText"> 
	<div id="commentList" class="commentList" style="border:1px solid balck">
	</div>
	<button type="button" id="comment-btn">제출</button>
</body>
</html>