
 	$(document).ready(function(){
 		$(function(){
 			$('#fileupload').on('change', function(){
 				readURL(this);
 			});
 		});
 		
 		function readURL(input){
 			if(input.files && input.files[0]){
 				var reader = new FileReader();
 				
 				reader.onload = function(e){
 					$('#preview').attr('src', e.target.result);
 				}
 				
 				reader.readAsDataURL(input.files[0]);
 			}
 		}
 		
 		$('#addcancel').click(function(){
 			$('.addcontentsbody').css('display', 'none');
 		});
 		
 		$('#addregister').click(function(){
 			//사진 업로드 하지 않았을 시
 			if($('.fileupload').val()==''){
 				alert("사진을 업로드 해주십시오.")
 			}
 			//사진 업로드 하였을 시
 			else{
 				//alert("컨텐츠를 성공적으로 업로드 하였습니다.")
 				$('.addcontentsbody').css('display', 'none');
 				$('#addregister').attr('type','submit');
 			}
 		})
 	});