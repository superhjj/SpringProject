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
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	</br>
	</br>
	<h2>사업자 등록 번호를 입력하세요.</h2>
	<form action="mainPeedView.do" method="post">
	<span>대표명</span>
	<input type="text" name="repName" class="repName"> 
	<span>사업자 등록 번호</span>
	<input type="text" name="sellerRegisterNum" class="sellerRegisterNum">
	<button type="button" class="sellerRegisterBtn">확인</button>
	</form>
	</div>
</body>
</html>