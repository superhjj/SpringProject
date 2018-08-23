<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>구매 정보 상세 조회</title>
</head>
<style>
	.container{
		font-size:30px;
	}
	
	.itemList{
		float:left;
	}
	
	.totalList{
		height:1500px;
		width:900px;
		margin:auto;
	}
	
	.col-lg-3{
		width:600px;
		font-size:30px;
	}

	
</style>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="totalList">
<div class="itemList">
	<c:forEach items="${ orderTitle.answer }" var="orderItem">
		<c:forEach items="${ orderItem }" var="item" varStatus="status">
		<table class="table">
			<tr>
				<td>
					<div class="col-lg-3" style="width:400px; font-size:20px; font-weight:bold" >${ item }</div>
				</td>
			</tr>
		</table>
		</c:forEach>
	</c:forEach>
</div>
<div class="itemList">
	<c:forEach items="${ order.answer }" var="orderResponse">
	<table class="table">
		<tr>
			<td>
				<div class="col-lg-3" style="width:400px; font-size:20px"> ${ orderResponse } </div>
			</td>		
		</tr>
	</table>
	</c:forEach>
</div>
</div>
</body>
</html>