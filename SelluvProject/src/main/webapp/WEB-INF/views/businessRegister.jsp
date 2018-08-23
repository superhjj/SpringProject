<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
 <link rel="stylesheet" href="css/menubar.css">
 
<script src="js/menubar.js"></script>
<script src="js/sellerRegister.js"></script>
<title>Insert title here</title>
<link rel="stylesheet" href="css/businessRegister.css">
<link rel="stylesheet" href="css/businessButton.css">
</head>
<body>
   <jsp:include page="menu.jsp"></jsp:include>
   <h2 style="margin-top: 250px;margin-bottom: 10px">사업자 등록 번호를 입력하세요.</h2>
   <form action="mainPeedView.do" method="post">
   <div class="group">
   		<input type="text" name="repName" class="repName" required> 
   		<span class="highlight"></span>
      	<span class="bar"></span>
      	<label>대표명</label>
   </div>
   <div class="group">
	    <input type="text" name="sellerRegisterNum" class="sellerRegisterNum" required>
	    <span class="highlight"></span>
      	<span class="bar"></span>
      	<label>사업자 등록 번호</label>
   </div>
   		<div class="main">
    <div class="sub-main">
      <button type="button" class="sellerRegisterBtn button-two"><span>등록</span></button>
    </div>
  </div>
   </form>
  
</body>
</html>