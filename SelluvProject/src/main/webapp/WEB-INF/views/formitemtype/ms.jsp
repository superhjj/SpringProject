<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="ms-box" id="ms-box">
		<div class="form-check" id="msoption-">
			<div class="col-sm-1 form-check-label">
				<input class="form-check-input" type="checkbox" name="checkes" disabled>
			</div>
			<div class="col-sm-10">
				<input type="text" class="form-control form-option-input"
					placeholder="옵션" id="msoption-val-">
			</div>
			<div class="col-sm-1 item-option-btn">
				<span id="ms-delete-btn-"
					class="glyphicon glyphicon-remove-circle ms-delete-btn"></span>
			</div>
		</div>
	</div>
	<div class="option-button">
		<button type="button" id="ms-add-btn" class="btn btn-default">옵션
			추가</button>
	</div>
</body>
</html>