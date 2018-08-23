<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/NewFile.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" href="css/menubar.css?v=<%=System.currentTimeMillis() %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구매자 목록 조회</title>
<style>
	.img-circle{
		width:60px;
		height:60px;       
		radius:30px;
	}
	
	.order_member_list{
		height:1500px;
		width:600px;
		margin:0 auto;
	}
	
	.order_item{
		width:250px;
		margin-left:20px;
		font-size:15px;
	}
	

	/* th{
		margin-left:25px;
		font-size:20px;
	} */
	
</style>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class = "order_member_list">
		<table class="table">
		<c:forEach items="${ list }" var="var">
			<tr>
				<td>
					<img src="${var.profile_img}" class="img-circle"/>
				</td>
				<td>
					<div class="order_item">
						<!-- 구매자의 응답을 보여주는 controller(.do)로 연결을 해야한다. -->
						<a href="orderMemberDetail.do?form_code=${ var.form_code }&member_id=${ var.member_id }"> ${ var.form_title }</a>
					</div>
				</td>
				<td>
					<div id="order_member_id" class="order_item">
						${ var.member_id }
					</div>
				</td>
				<td>
					<div id="order_date" class="order_item">
						${ var.order_date }
					</div>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>