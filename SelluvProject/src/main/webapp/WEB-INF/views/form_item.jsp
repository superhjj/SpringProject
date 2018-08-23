<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="form-item">
		<div class="col-sm-9">
			<div class="form-group row">
				<div class="col-sm-12">
					<input type="text" id="form-item-title-" class="form-control"
						placeholder="항목 제목">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-12">
					<input type="text" id="form-item-description-" class="form-control"
						placeholder="항목 설명">
				</div>
			</div>
			<div id="current-type-" class="form-group row"></div>
		</div>
	</div>
	<div class="col-sm-3">
		<select class="form-control" id="form-type-selectbox-">
			<option selected value="sa">주관식 단답형</option>
			<option value="sn">주관식 서술형</option>
			<option value="ss">단일 선택형</option>
			<option value="ms">복수 선택형</option>
			<option value="ti">연락처 입력형</option>
			<option value="ai">주소 입력형</option>
			<option value="mm">금액&숫자 입력형</option>
		</select>
	</div>
	<div class="col-sm-12">
		<div class="form-group row">
			<div class="col-sm-12 item-menu-btns">
				<div class="col-sm-11">
					<input type="checkbox" id="necessary-input-"><label>&nbsp 필수 체크</label>
				</div>
				 <div class="col-sm-1 item-menu-btn">
					<span id="item-write-ok-" class="glyphicon glyphicon-ok-circle"></span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>