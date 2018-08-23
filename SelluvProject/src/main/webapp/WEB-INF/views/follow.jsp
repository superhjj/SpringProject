<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/NewFile.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
</script>

	<link rel="stylesheet" href="css/follow.css">
<link rel="stylesheet" href="css/NewFile.css">
<link rel="stylesheet" href="css/menubar.css">
<script src="js/menubar.js"></script>
<script src="js/follow.js"></script>
<style>
	
</style>
<title>팔로우 서비스</title>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>
	<div class="follow-container">
		<div class="followbody">
				<div id="follow" class="follow">
					<table class="table">
						<tbody>
						
						<c:if test="${noFollow  eq 'Y'}">
							팔로우 목록이 없습니다.
						</c:if>
						
						<c:forEach items="${followList}" var="follow" step="1">
							<tr class="follow-tr">
								<!-- 팔로워/팔로우한 사람들의 프로필 사진과 소개(시작) -->
								<td class="follow-img"><img src="${follow.profile_img }"
									class="img-circle" />
									<!-- 프로필 사진 출력 --></td>
								<td class="follow-name">
									<div id="id&name" class="id&name">
										<div id="id" class="id">${follow.follow_id }</div>
										<!-- id 출력 -->
										<div id="name" class="name">${follow.member_name }</div>
										<!-- 이름 출력 -->
									</div>
								</td>
							</tr>
							<%-- <!-- 팔로워/팔로우한 사람들의 프로필 사진과 소개(끝) -->
							<tr>
								<td><img src="./images/apple.png" class="rounded-circle"
									style="height: 30px" style="width:30px" /></td>
								<td>
									<div id="id&name" class="id&name">
										<div id="id" class="id">{follow}</div>
										<div id="name" class="name">${follow.memberId }</div>
									</div>
								</td>
							</tr> --%>
						
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<footer>
			<p>© Company 2014</p>
		</footer>
</body>
</html>