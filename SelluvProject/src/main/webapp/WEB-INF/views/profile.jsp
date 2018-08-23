<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="js/profile.js"></script>
  <script src="js/menubar.js"></script>
  <link rel="stylesheet" href="css/registerButton.css">
  <link rel="stylesheet" href="css/menubar.css">
  <link rel="stylesheet" href="css/NewFile.css">
  <link rel="stylesheet" href="css/profile.css">
  
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="outer">
		<div class="login">
			<div class="selluvText">
				<img src="image/img1.jpg" class="img-circle" width="25px" height="20px" id="profile_picture">
				<label class="profilename">roma.emo</label>
				<br>
				<br>
				<input id="fileupload" class="fileupload" type="file" name="contents_image"/>
			</div>
			<div class="form-name">
				 이름 &nbsp;&nbsp;&nbsp;&nbsp;
				   <input type="text" class="search-box" id="name1" name="name1"
					placeholder="NAME" size="30">
			</div>
			
			<div class="form-website">
				웹사이트 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" class="search-box" id="website" name="website"
					placeholder="web-site" size="30">
			</div>
			
			<div class="form-profileIntro">
				프로필 소개 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" class="search-box" id="profileIntro" name="profileIntro"
					placeholder="프로필 소개를 입력해주세요." size="30">
			</div>
			<div class="form-mail">
				이메일 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" class="search-box" id="mail" name="mail"
					placeholder="E-mail" size="30">
			</div>
			<div class="form-phone">
				전화번호 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
				<input type="text" class="search-box" id="phone" name="phone"
					placeholder="Phone" size="30">
			</div>
			<div class="btn2" onclick="location.href='login.jsp'">
				<span>제출</span>
				<div class="dot"></div>
			</div>
			<div class="btn3" onclick="location.href='index.jsp'">
				<span>계정 비활성화</span>
				<div class="dot"></div>
			</div>

		</div>
	</div>
</body>
</html>