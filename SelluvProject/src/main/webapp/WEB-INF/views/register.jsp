<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/registerButton.css">
  <link rel="stylesheet" href="css/register.css">
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#register_btn').click(function(){
			$('#register_form').submit();
		});
	});
</script>
</head>
<body>

<div class="outer">
	<div class="logo">
		<div class="logoImage">
			<img src="image/selluv.png">
		</div>
	</div>	
	<div class="login">
	<div id="error" class="registererror">${requestScope.error }</div>
	<div class="selluvText"><img src="image/logo.png" class="title"></div>
	<form id="register_form" class="register_form" action="memberInsert.do" method="POST">
		<div class="form-id">
			<input type="text" class="search-box" id="id" name="id" placeholder="ID" size="50">
		</div>
		<div class="form-pwd">
			<input type="password" class="search-box" id="pwd" name="pwd" placeholder="PASSWORD" size="50">
		</div>
		<div class="form-name">
			<input type="text" class="search-box" id="name" name="name" placeholder="NAME" size="50">
		</div>
		<div class="form-mail">
			<input type="text" class="search-box" id="mail" name="mail" placeholder="E-mail" size="50">
		</div>
		<div class="form-address">
			<input type="text" class="search-box" id="address" name="address" placeholder="address" size="50">
		</div>
		<div class="form-phone">
			<input type="text" class="search-box" id="phone" name="phone" placeholder="Phone" size="50">
		</div>
		<div class="btn1">
			<span id="register_btn">가입</span>
		<div class="dot"></div>
	</div>
	</form>
	<div class="move_login"><a href="login.jsp">로그인</a></div>
	</div>

</div>

</body>
</html>