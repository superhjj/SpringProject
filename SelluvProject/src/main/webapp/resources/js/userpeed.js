
$(document).ready(function(){	

		/*$(".menu-5").click(function(){
			$.ajax({
		        type : "GET",
		        url : "peed_contents.jsp",
		        dataType : "html",
		        error : function(){
		            alert('통신실패!!');
		        },
		        success : function(data){
		        	$('#user-contents').empty();
		        	$('#user-contents').html(data);
		        	$('.contentsFont').css('font-weight','bold');
		        	$('.contentsFont').css('color','black');
		        	$('.formFont').removeAttr('style');
		        }
		    });	
		});*/
	 $('#form-btn').on('click', function() {
   	  var form = new XMLHttpRequest();
   	  var id = document.getElementById('form_search_id').value;
   	  var myId = document.getElementById('myId').value;
   	  
   	  while(document.getElementById('user-contents').hasChildNodes()){
   		  document.getElementById('user-contents').removeChild(document.getElementById('user-contents').firstChild);
   	  }
   	  
   	  /*form.open('POST', 'searchFormController.do?member_id=' + encodeURIComponent(document.getElementById('form_search_id').value), true);*/
   	  
   	  form.open('POST', 'searchFormController.do?', true);
   	  form.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
   	  //alert(document.getElementById('form_search_id').value);
   	  form.send('member_id=' + encodeURIComponent(document.getElementById('form_search_id').value));
   	  
   	  form.onreadystatechange = function() {
   		  if(form.readyState == 4 && form.status == 200) {
   			  var list = JSON.parse(this.responseText);
   			  var formList = document.createElement('div');
   			  $(formList).attr('class','contents-area-inner');
   			  var str = '';
   			  
   			  console.log(list);
   			  console.log('list[0].peed_id : ' + list[0].peed_id);
   			  console.log('list[0].member_id : ' + list[0].member_id);
   			  if(list[0].peed_id == myId && list[0].member_id == undefined && list.length == 1){
   				  console.log('id : ' + id);
   				  str += '<div class=\'col-md-4 userpeed-forms\'><span class=\'add-form-btn\'><a href=\'form.jsp\' class=\'form-add\'> + </a></span></div>';
   				  
   				  formList.innerHTML = str;
   				  document.getElementById('user-contents').prepend(formList);
   			  }
   			  else if(list[0].member_id == id){
   				  console.log('아이디가 같음');
   				  str += '<div class=\'col-md-4 userpeed-forms\'><span class=\'add-form-btn\'><a href=\'form.jsp\' class=\'form-add\'> + </a></span></div>';
   			  
   				  for(var i = 0; i < list.length; i++) {
   					  str += '<div class=\"col-md-4 userpeed-forms\"><span class=\'form-item\'><a href=orderMemberView.do?form_code=' + list[i].form_code + '>' + list[i].form_title + '</a></span></div>';
   				  }
   			  
   				  formList.innerHTML = str;
   				  document.getElementById('user-contents').prepend(formList);
   			  }
   			  else {
   				  console.log('아이디가 다름');
   				  for(var i = 0; i < list.length; i++) {
   					  str += '<div class=\"userpeed-forms col-md-4\"><span class=\'form-item\'> <a href=orderSheetSearch.do/'+list[i].form_code+'/'+list[i].peed_id+'>' + list[i].form_title + '</a></span></div>';
   				  }
   				/*  alert('test'+list[167].peed_id);*/
   			  
   				  formList.innerHTML = str;
   				  document.getElementById('user-contents').prepend(formList);
   			  }
   			  }
   	  }
     });
	
	$('#plus_btn').click(function(event){
		$.ajax({
	        type : "GET",
	        url : "addcontents.jsp",
	        dataType : "html",
	        error : function(){
	            alert('통신실패!!');
	        },
	        success : function(data){
	        	$('.dataArea').html(data);
	        }
	    });					
	})
	
	
		$('.menu-5').click(function(){
			$(body).find(row).remove();
			var contents = new XMLHttpRequest();
			
			console.log('AJAX 준비중');
			//var cell = document.getElementById('contents-area');
			var cell = document.getElementById('user-contents');
			
			while(cell.hasChildNodes()){
				cell.removeChild(cell.firstChild);
			}
			
			//contents.open('GET', 'contentsSearch.do?job=searchContentList&id=' + encodeURIComponent(document.getElementById('request_id').value), true);
			//contents.open('POST', 'contentsSearch.do?job=searchContentList2&id=' + encodeURIComponent(document.getElementById('memberId').value), true);
			contents.open('POST', 'contentsSearch.do', true);
			contents.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			contents.send('job=searchContentList2&id=' + encodeURIComponent(document.getElementById('memberId').value));
			contents.onreadystatechange = function(){
				if(contents.readyState == 4 && contents.status == 200){
					//alert('AJAX 통신 성공');
					var list = JSON.parse(this.responseText);
					console.log(list);
					console.log(list.length);
					var str = ''; 
					var div = document.createElement('div');
					$(div).attr('class','contents-area-inner');
					for(var i = 0; i < list.length; i++){
						str += '<div class=\"col-md-4 userpeed-contents\"> <form action=\"detailContents.do\" method=\"POST\"> <img class=\'c_img\'src=\'' + list[i].contents_img + '\'> <input type=\"hidden\" name=\"job\" value=\"searchContent\"> <input type=\'hidden\' class=\'contentCode\' value=\'' + list[i].contents_code + '\'/><input type=\"hidden\" id=\"memberId\" name=\"memberId\" value=\''+ list[i].memberId +'\'/></form></div>';
					}
					
					div.innerHTML = str;
					
					document.getElementById('row').append(div);
				}
			}
			
		});
		
		$('.userpeed-contents').click(function() {
			//alert("click");

			var obj = $(this);
	         var formObj = obj.children('form');
	         var inputObj = formObj.children('input:nth-child(3)');
	         //alert(inputObj.val());
	            
	         var contentNum = inputObj.val();
	         
	         var inputObj1 = formObj.children('input:nth-child(4)');
	         //alert(inputObj1.val());
	         var idNum = inputObj1.val();
	         
	         var allData = { "idNum": idNum, "contentNum": contentNum };
			
			$.ajax({
	              type : "POST",
	              url : "detailContents.do",
	              data: allData,
	              error : function(){
	                  alert('통신실패!!');
	              },
	              success : function(data){
	                 $('.dataArea').html(data);
	              }
	          });   
		});
		
		$('#follow_btn').click(function(event){
	         if($('#follow_btn').css('background-color')=='rgb(251, 179, 175)'){
	            $("#follow_btn").css('background-color','rgb(255, 255, 255)');
	            

	            $('#follow_message').fadeIn('fast',function(){
	               $("#follow_message").text(" 팔로우 취소하였습니다.");
	               
	               var followId={"followId":$('.mem-id').text()};
	            
	              // alert(followId);
	               
	               $.ajax({
		 	              type : "POST",
		 	              url : "followSearch.do",
		 	              data: followId,
		 	              error : function(){
		 	                  alert('통신실패!!');
		 	              },
		 	              success : function(data){
		 	                // alert(data);
		 	              }
		 	          });   
	               
	            });
	            $('#follow_message').fadeOut('slow',function(){
	               $("#follow_message").text("");
	            });
	            
	         }
	         else if($('#follow_btn').css('background-color')=='rgb(255, 255, 255)'){
	            $("#follow_btn").css('background-color','rgb(251, 179, 175)');
	           
	            $('#follow_message').fadeIn('fast',function(){
	               $("#follow_message").text(" 팔로우 하였습니다.");
	               
	               var followId={"followId":$('.mem-id').text()};
		            
		              // alert(followId);
		               
		               $.ajax({
			 	              type : "POST",
			 	              url : "followSearch.do",
			 	              data: followId,
			 	              error : function(){
			 	                  alert('통신실패!!');
			 	              },
			 	              success : function(data){
			 	                // alert(data);
			 	              }
			 	          });   
	               
	            });
	            $('#follow_message').fadeOut('slow',function(){
	               $("#follow_message").text("");
	            });
	            
	         }
	      })
	      if($('#form_insert_flag').val()=='insertForm' || $('#form_insert_flag').val()=='orderInsert'){
				$('#form_insert_flag').val('');
				$('#form-btn').click();
			}
	});