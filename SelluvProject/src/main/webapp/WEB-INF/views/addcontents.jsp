<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	
<link rel="stylesheet" href="css/addcontents.css">


<script src="js/addcontents.js"></script>

</head>

<body>
	<div class="addcontentsbody">
		<div class="addbody">
		<div id="curtain" class="addcurtain">
		<div id="inputDiv" class="inputDiv">
		
	<form id="inputContents" action="contentsInsert.do" method="post" class="inputContents"  enctype="multipart/form-data">

			<div class="thumnail">
				<img id="preview" class="preview" src="./image/notitle.png" /> <!-- 컨텐츠의 이미지가 들어가는 칸 -->
			</div>
			<div class="upload">
				<input id="fileupload" name="addcontents_img" class="fileupload" type="file" />
				
			</div>
			<div class="caption1" style="margin:10px"> 
				<textarea cols="56" rows="5" name="addcontents_text"></textarea> <!-- 컨텐츠의 내용이 들어가는 칸 -->
			</div>
			<div class="caption2">
				<p style="margin:10px" style="height:100px" style="width:400px">사진은 10장까지 등록가능합니다.</p>
			</div>
			<div class="alert1" style="text-align:left">
				<button type="button" class="btn btn-default">사진</button>
				<button type="button" class="btn btn-default">동영상</button>
			</div>
			
			<div class="alert2" style="text-align:right">
				<button type="button" id="addregister" class="btn btn-default">등록</button>
				<button type="button" id="addcancel" class="btn btn-default">취소</button>
			</div>

	</form>
</div>
</div>
</div>
	</div>
	<!--/.container-->
</body>
</html>