<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/NewFile.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/menubar.css">
<link rel="stylesheet" href="resources/css/userpeed.css">
<link rel="stylesheet" href="resources/css/addcontents.css"> 

<script src="resources/js/userpeed.js"></script>

<script>
function followFunc() {
 
	
	document.getElementById("follow-form").submit();
}

function followerFunc() {
    document.getElementById("follower-form").submit();
}


<!--location.href = document.referrer;-->

</script>
</head>

<body>
<input type="hidden" id="form_search_id" value="${memberInfo.memberId }">
			<input type="hidden" id="form_insert_flag"
				value="${requestScope.insert }">
				<input type="hidden" id="myId" value="${ sessionScope.memberId }">
	<div class="dataArea"></div>
	<jsp:include page="menu.jsp"></jsp:include>
	<link rel="stylesheet" href="css/userpeed.css">
	<div class="body-container peed-body" name="body-container">
		<div class="col-md-12 userpeedbody">
	<div class="body-container" name="body-container">
	<div class="userpeedbody">
		<header class="head">
			<div class="profile-img">
				<img src="${memberInfo.profileImg }" class="img-circle" alt="Cinque Terre"
					width="150" height="150">
			</div>
			<c:if test="${memberInfo.levelName == '판매자회원'}">
			<span style="color:blue">
			Seller
			</span>
			</c:if>
			<div class="profile-text">
				<div class="profile-1"><%-- 
				<input type="hidden" id="request_id" value="${requestScope.id }"> --%>
				<input type="hidden" id="memberId" value="${requestScope.id }">
				
					<div class="profile-id">
						<label class="mem-id">${memberInfo.memberId }</label>
					</div>
					<div class="profile-btn">
											
						<c:if test="${memberInfo.memberId != sessionScope.memberId}">
						<c:choose>
						
						<c:when test="${requestScope.isFollow eq 'N'}">
						<button type="button" class="btn btn-userpeed" id="follow_btn"  >팔로우</button>
						<span id="follow_message"></span>
						</c:when>
						
						<c:when test="${requestScope.isFollow eq 'Y'}">
						<button type="button" class="btn btn-userpeed1" id="follow_btn">팔로우</button>
						<span id="follow_message"></span>
						</c:when>
						
						</c:choose>
						
						</c:if>
						
						
					</div>
				</div>	
				
				<div class="profile-2">
					<div class="profile-2-2">
						<span>게시글</span><label class="content-cnt">${contentsCnt.cnt }</label>
					</div>
					<div class="profile-2-2">
						<form action="followerViewSearch.do" id="follower-form" method="get">
							<span style="color:#262626"><a style="color:#262626" href="followerViewSearch.do?memberId=${memberInfo.memberId }">팔로워</a></span>
							<label class="follower-cnt">${followerCnt.followerCnt }</label>
						</form>	
					</div>
					<div class="profile-2-2">
						<form action="followViewSearch.do" id="follow-form" method="get">
							<span><a style="color:#262626" href="followViewSearch.do?memberId=${memberInfo.memberId }">팔로우</a></span>
							<label class="follow-cnt">${followCnt.followCnt }</label>
						</form>
					</div>
				</div>
				<div>	
					<h4 class="mem-name">${memberInfo.memberName }</h4>
				</div>
				<div>	
					<label class="profile-intro">${memberInfo.profileIntro }</label>
				</div>
				<div>	
					<span class="profile-url"><a href="www.naver.com">${memberInfo.profileWebsite }</a></span>
				</div>
				
			</div>
		</header>
		
		
		<div class="user-menu">
			<c:choose>
			<c:when test="${memberInfo.levelName != '일반회원'}">
			<div class="menu-content" >
				<a href="#" class="menu-5"><span id="contents-btn" class="contentsFont">Contents</span></a>
			</div>
			</c:when>
			<c:when test="${memberInfo.levelName == '일반회원'}">
			<div class="menu-content"style="margin-left:230px;margin-top:10px">
				<a href="#" class="menu-5"><span id="contents-btn" class="contentsFont">Contents</span></a>
			</div>
			</c:when>
			</c:choose>
			<c:if test="${memberInfo.levelName == '판매자회원'}">
			<div class="menu-form">
				<a href="#" class="menu-6"><span class="formFont" id="form-btn">Form</span></a>
			</div>
			</c:if>
		</div>
		<c:if test="${contentsCount != 0 }">
		<div id="user-contents" class="container">
			<div class="peedContents contents-area-inner">
				<div class="row" id="row">
					<c:forEach var="content" items="${contents }">
						<!-- <div class="content contents-area-inner"> -->
							<div class="col-md-4 userpeed-contents" class="content">
								<form action="detailContents.do" method="POST">
									<img src="${content.contentImg }"
										class="content-img" style="width:268px; height:268px">
									<input type="hidden" name="job" value="searchContent">
									<input type="hidden" id="contentNum" name="contentNum" value="${content.contentCode }">
									<input type="hidden" id="idNum" name="idNum" value="${content.memberId }">
									<%-- ${content.contentCode }
									${requestScope.memberId } --%>
								</form>
							</div>
					</c:forEach>	
					
				</div>
				<div class="formList" id="formList"></div>
				<div>&nbsp;</div>
			</div>
		</div>
		<div id="contents-area" class="contents-area-style col-md-12">
			
			<%-- <jsp:include page="peed_contents.jsp">
				<jsp:param name="contents" value="${contents }"/>
			</jsp:include> --%>
		</div>
		</c:if>
	</div>
	</div>
	
	<!--/.container-->
</body>
</html>