<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="col-sm-12">
		<div class="form-group row col-sm-12">
			<input type="text" id="form-item-title" class="form-control"
				placeholder="주문서 제목" name="formTitle">
		</div>
		<div class="form-group row col-sm-12">
			<input type="text" id="form-item-description" class="form-control"
				placeholder="주문서 설명" name="formContent">
		</div>
		<div id="date-type" class="form-group row col-sm-12">
			<div class="col-sm-12 form-item">
				<div class="col-sm-2 date-title">시작일자 :</div>
				<div class="col-sm-2 date-content" id="start-date">
					<input class="form-control date-content-input" type="date"
						value="2018-07-18" id="start-date-input" name="formStartDate">
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-2 date-title">종료일자 :</div>
				<div class="col-sm-2 date-content" id="end-date">
					<input class="form-control date-content-input" type="date"
						value="2018-07-20" id="end-date-input" name="formEndDate">
				</div>
				<div class="col-sm-2 isopen-area">
					<input class="form-check-input" type="checkbox" id="isopen-check" value="no" name="periodFlag">
					<label>기간 설정</label>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group row">
				<div class="col-sm-11"></div>
				<div class="col-sm-1 item-menu-btn">
					<span id="form-basic-ok" class="glyphicon glyphicon-ok-circle"></span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>