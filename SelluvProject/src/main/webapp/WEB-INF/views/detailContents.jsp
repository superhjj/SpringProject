<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/NewFile.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/detailContents.js?v=<%=System.currentTimeMillis() %>"></script>

<link rel="stylesheet" href="css/detailContents.css?v=<%=System.currentTimeMillis() %>">
<link rel="stylesheet" href="css/detailContents.css">
</head>

<body>
<form>
<!--  
<input type="hidden" id="memberId" class="memberId" name="memberId" value="${sessionScope.memberId}"/> <!-- session의 memberId를 value로 넣어줘야 한다. -->
	<input type="hidden" id="contentCode" class="contentCode" name="contentCode" value="${contentsDetailView.contentCode }"/> <!-- 게시글 번호를 value에 넣어줘야 한다. -->
	<div class="detailcontainer">
	<div class="curtain">
	<div class="detailContents">
		<div class="detailPic"><img src="${contentsDetailView.contentsImg }" class="pic1"></div>
		<div class="detailEtc">
			<div class="cancel"><span class="glyphicon glyphicon-remove" id="detail-cancel"></span></div>
			<div class="profileLayer">
				<div>
					<img src="${contentsDetailView.profileImg }" class="img-circle" alt="Cinque Terre">
					<div class="userId1">${contentsDetailView.memberId}</div>
					<c:if test="${contentsDetailView.memberId eq sessionScope.memberId }">
						<img src="./image/delete.png" id="deleteContent-btn" class="setting">
					</c:if>
				</div>
			</div>
			<div class="userContent">
				<div class="userItem1">
					<div class="userId2">${contentsDetailView.memberId}</div>
					<div class="userText">${contentsDetailView.contentsText}</div>
				<div>
					<c:forEach items="${ hashtag }" var="var">
						<a href="searchHashtag.do?hashtag=${ var }"># ${ var }</a>
					</c:forEach>
				</div>
				</div>
				<div class="comment">
					<ul id = "commentList" class="commentList">
					</ul>
			</div>
			</div>
	
				<div class="etc">
					<div class="etc-1">
						<span class="${contentsDetailView.contentCode }-tooltiptext" style="display:none;width:80px;height:30px;background-color: #ff0055;color: #fff;text-align: center;border-radius: 6px; padding: 5px 0;position: absolute;z-index: 1; bottom: 20%;left: 64.7%; top:75%;margin-left: -60px;">좋아용~</span>
						<div class="like-area">
							<form action="likeSearch.do" method="post">
								<c:choose>
									<c:when test="${requestScope.isLike eq 'n' }">
										<!-- <span id="like-btn" class="btn-lg glyphicon glyphicon-heart-empty"></span> -->
										<img src="./image/like.png" id="like-btn" class="${contentsDetailView.contentCode}-like" style="cursor: pointer; width: 25px; height: 25px; float: left; margin-top: 9px; margin-left: 5px; margin-right: 10px">
										<img src="./image/liked.png" id="like-btn" class="${contentsDetailView.contentCode}-liked" style="display:none;cursor: pointer; width: 25px; height: 25px; float: left; margin-top: 9px; margin-left: 5px; margin-right: 10px">
									</c:when>
									<c:otherwise>
										<!-- <span id="like-btn" class="btn-lg glyphicon glyphicon-heart"></span> -->
										<img src="./image/like.png" id="like-btn" class="${contentsDetailView.contentCode}-like" style="display:none;cursor: pointer; width: 25px; height: 25px; float: left; margin-top: 9px; margin-left: 5px; margin-right: 10px">
										<img src="./image/liked.png" id="like-btn" class="${contentsDetailView.contentCode}-liked" style="cursor: pointer; width: 25px; height: 25px; float: left; margin-top: 9px; margin-left: 5px; margin-right: 10px">
									</c:otherwise> 
								</c:choose>
								<input type="hidden" id="contentsCode" name="contentsCode" value="${contentsDetailView.contentCode }">
								<input type="hidden" id="memberId" name="memberId" value="${sessionScope.memberId }">
							</form>
						</div>
						
						<div class="comment-area">
							<!-- <span id="comment-load-btn" class="btn-lg glyphicon glyphicon-comment"></span> -->
							 <img src="./image/comment.png" id="comment-load-btn" style="width: 25px; height: 25px; margin-top: 9px; margin-right: 10px">
						</div>
						<div class="retweet-area">
							<!-- <span class="btn-lg glyphicon glyphicon-retweet"></span> -->
							<img src="./image/retweet.png" style="width: 33px; height: 33px; margin-top: 5px"> 
						</div>
						<div class="likeContent">좋아요<span class="likeCnt">${contentsDetailView.likeCnt}</span></div>
					</div>
					
					<div class="etc-2">
						<input type="text" placeholder="댓글 입력..." id="inputComment" class="inputComment" name="inputComment">
						<button type="button" id="comment-btn" class="btn btn-default">입력</button>
					</div>
					</div>
				</div>
		</div>
	</div>
	</div>	
</form>
</body>
</html>