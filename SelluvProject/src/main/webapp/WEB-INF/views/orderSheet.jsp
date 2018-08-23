<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/NewFile.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script>
/* 'form/'+'${requestScope.memberId}'+'/'+'${requestScope.formCode}'+'.jsp' */
	$(document).ready(function(){

		//alert("test");
		$.ajax({
			url : 'form/'+'${requestScope.memberId}'+'/'+'${requestScope.formCode}'+'/'+'${requestScope.formCode}'+'.jsp',
			type : 'POST',
			datatype : "html",
			contentType: 'text/html; charset=UTF-8',
			success : function(data) {
				var dataHtml = data;
				//alert(dataHtml);

				/* 				
var bodyOuter = dataHtml.find('.body-outer');
				alert(bodyOuter);  */
				$('.body-container').prepend(dataHtml); 
				$('.form-write-btn').empty();
				$('.order-write-btn').show();
				$('.form-control').attr("disabled",false);	
			}
		});
		
		$('#itemadd').on('click', function(e) {
			
			var cnt = parseInt($('.item-li').length);
			var titleAry = new Array();
			var resAry = new Array();
			
			alert(cnt);
		
			for(var i=1; i<cnt; i++) {
				titleAry[i] = $('#title-'+i).text();
				resAry[i] = '';
				var type = $('#itemtype-'+i).val();
				
				if(type == 'ss') {
					resAry[i] = $("input[name='radios-"+i+"']:checked").val();
				}
				else if(type == 'ms') {
					$("input[name='checkes-"+i+"']:checked").each(function() {
						resAry[i] += $(this).val() + ", ";
					})
				}
				else if(type == 'ai') {
					var ai1 = $('#change-type-'+i).children('div').children('div').children('input').val();
					var ai2 = $('#change-type-'+i).children('div').children('div:nth-child(3)').children('input').val();
					
					resAry[i] = ai1 + " , " + ai2;
				}
				else if(type == 'sn') {
					resAry[i] = $('#change-type-'+i).children('div').children('textarea').val();
				}
				else {
					resAry[i] = $('#change-type-'+i).children('div').children('input').val();
				}
			}
			
			var str = '';
			var str2 = '';
			for(var i=1; i<cnt; i++) {
				str += resAry[i] + "/";
				str2 += titleAry[i] + "/";
			}
			
			
			$('#itemInsert').val(str);
			$('#titleInsert').val(str2);
			
			$('#orderInsert').submit();
			
		});
		
		
	});
</script>
<link href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
<link rel="stylesheet" href="css/formbutton.css">
<style>
.order-write-btn{
display:none;
}
</style>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form id="orderInsert" method="post" action="orderResponseInsert.do">
<div class="body-outer">
<div class="body-container">

<div class="order-write-btn">
         <div class="buttons">
               <button type="button" class="blob-btn" id="itemadd">
                  ADD ORDER<span class="blob-btn__inner"> <span
                     class="blob-btn__blobs"> <span class="blob-btn__blob"></span>
                        <span class="blob-btn__blob"></span> <span
                        class="blob-btn__blob"></span> <span class="blob-btn__blob"></span>
                  </span>
                  </span>
               </button>
               
            </div>

            <svg xmlns="http://www.w3.org/2000/svg" version="1.1"> <defs>
            <filter id="goo"> <feGaussianBlur in="SourceGraphic"
               result="blur" stdDeviation="10"></feGaussianBlur> <feColorMatrix
               in="blur" mode="matrix"
               values="1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 21 -7" result="goo"></feColorMatrix>
            <feBlend in2="goo" in="SourceGraphic" result="mix"></feBlend> </filter> </defs> </svg>

         </div>
</div>
</div>
   <input type="hidden" id="itemInsert" name="itemInsert">
   <input type="hidden" id="titleInsert" name="titleInsert">
   <input type="hidden" name="formCode" value="${requestScope.formCode }">
   <input tyep="hidden" name="memberId" value="${requestScope.memberId }">
</form>
</body>
</html>