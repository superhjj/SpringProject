<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="col-sm-12 select-option" id="ss">
		<div class="ss-box" id="ss-box">
			<div class="form-check">
				<label class="col-sm-1 form-check-label"> <input
					class="form-check-input" type="radio" name="radios" disabled>
				</label>
				<div class="col-sm-11">
					<input type="text" class="form-control" placeholder="옵션">
				</div>
			</div>
			<div class="form-check">
				<label class="col-sm-1 form-check-label"> <input
					class="form-check-input" type="radio" name="radios" disabled>
				</label>
				<div class="col-sm-11">
					<input type="text" class="form-control" placeholder="옵션">
				</div>
			</div>
		</div>
		<div class="option-button">
			<button type="button" id="ss-add-btn" class="btn btn-default">옵션
				추가</button>
			<button type="button" id="ss-remove-btn" class="btn btn-default">옵션
				삭제</button>
		</div>
	</div>
</body>
</html>