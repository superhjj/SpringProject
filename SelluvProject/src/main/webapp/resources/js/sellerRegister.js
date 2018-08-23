$(document).ready(function() {

	$('.sellerRegisterBtn').click(function() {
		//alert("click");
		var repName=$('.repName').val();
	    var sellerRegisterNum=$('.sellerRegisterNum').val();
		
	    var allData = { "repName": repName, "sellerRegisterNum": sellerRegisterNum };
		
		$.ajax({
	          type : "POST",
	          url : "sellerRegister.do",
	          data: allData,
	          error : function(){
	              alert('통신실패!!');
	          },
	          success : function(data){
	        	  var list=$.parseJSON(data);
	        	  if(list.error=="1"){
	        		  alert(list.errorMsg);
	        	  }
	        	  else if(list.error=="2"){
	        		  alert(list.errorMsg);	
	        	  }
	        	  else{
	        		  var registerConfirm=confirm("위 내용으로 사업자 등록을 하시겠습니까?\n사업자 번호: "+list.wrkrRegNo+"\n대표자명: "+list.repNm );
	        		  if(registerConfirm==true){
	        			  $('.sellerRegisterBtn').attr('type','submit');
	        			  $('.sellerRegisterBtn').submit();
	        		  }
	        	  }
	          }
	      });   
	});

});



