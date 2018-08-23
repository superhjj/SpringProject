	/* 댓글 로드하는 함수 */
	function loadComment(){
		
		console.log('댓글 목록 가져오기');
		var comment = new XMLHttpRequest();
		
		while(document.getElementById('commentList').hasChildNodes()){
			document.getElementById('commentList').removeChild(document.getElementById('commentList').firstChild);
		}
		
		console.log('contentCode : ' + document.getElementById('contentCode').value);
		
		comment.open('GET', 'commentSearch.do?contentCode='+encodeURIComponent(document.getElementById('contentCode').value), true);
		
		comment.onreadystatechange = function(){
			if(comment.readyState == 4 && comment.status == 200){
				var comm = JSON.parse(this.responseText);
				if (comm == null || comm.no_data == '등록된 댓글이 없습니다.'){
					var err = document.createElement('div');
					err.innerHTML = comm.no_data;
					console.log(err);
					document.getElementById('contentList').append(err);
				}
				else {
					var list = document.createElement('div');
					var str = '';
					
					for(var i = 0; i < comm.length; i++){
						str += '<li><div><div>' + comm[i].memberId + '</div></div><div><div>' + comm[i].commentText + '</div></div>';
					}
					
					list.innerHTML = str;
					document.getElementById('commentList').append(list);
				}
			}
		}
		
		comment.send(null);
	}
	
	$(document).on('click','#like-btn',function() {
	/*$('#like-btn').one('click',function(){*/
		var contents = new XMLHttpRequest();
		var like = $(this).attr('class');
		var content = $('#contentCode').val();
		console.log('AJAX 준비중');
		
		contents.open('POST', 'likeSearch.do', true);
		contents.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		contents.send('job=likeSearch&memberId=' 
				+ encodeURIComponent(document.getElementById('memberId').value)
				+'&contentsCode='+encodeURIComponent(document.getElementById('contentsCode').value));
		
		contents.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200){
				var obj = JSON.parse(contents.responseText);
				
				if(obj.flag == "y") {
					//$('#like-btn').attr('class', content+'-liked');
					$('.'+like).css('display','none');
					$('.'+like+'d').css('display','inline');
					like = like.substring(0,like.length-5);
					$('.'+like+'-tooltiptext').fadeIn("slow").css('display','inline');
					$('.'+like+'-tooltiptext').fadeOut();
				}
				else if(obj.flag=="n") {
					//$('#like-btn').attr('class', content+'-like');
					$('.'+like).css('display','none');
					like = like.substring(0,like.length-1);
					$('.'+like).css('display','inline');
				}
			}
		}
	});
	
	/* 댓글 작성 시 동작해야 하는 함수 */
	$(document).ready(function(){
		$('#deleteContent-btn').click(function(){
			var contents_code = document.getElementById('contentCode').value;
			document.location.href="contentsDelete.do?contentCode=" + contents_code;
		});

		
		$('#detail-cancel').click(function(){
			$('.curtain').css('display','none');
		});
		
		/*$('#like-btn').click(function() {
			var contents = new XMLHttpRequest();
			
			console.log('AJAX 준비중');
			
			contents.open('POST', 'likeSearch.do', true);
			contents.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			contents.send('job=likeSearch&memberId=' 
					+ encodeURIComponent(document.getElementById('memberId').value)
					+'&contentsCode='+encodeURIComponent(document.getElementById('contentsCode').value));
			
			contents.onreadystatechange = function() {
				if(contents.readyState == 4 && contents.status == 200){
					var obj = JSON.parse(contents.responseText);
					
					if(obj.flag == "y") {
						$('#like-btn').attr('class', 'btn-lg glyphicon glyphicon-heart');
					}
					else if(obj.flag == "n") {
						$('#like-btn').attr('class', 'btn-lg glyphicon glyphicon-heart-empty');
					}
				}
			}
		});*/

		
		$('#comment-load-btn').click(function(){
			console.log('로드 버튼 클릭');
			loadComment();
		});
		
		$('#comment-btn').click(function(){
			var comment = new XMLHttpRequest();
			comment.open('POST', 'commentInsert.do?commentText=' + encodeURIComponent(document.getElementById('inputComment').value) + 
					'&contentCode='+encodeURIComponent(document.getElementById('contentCode').value), true);
			//$('#inputComment').val('');
			comment.onreadystatechange = function(){
				if(comment.readyState == 4 && comment.status == 200){
					var comm = JSON.parse(this.responseText);
					var str = '';
					var list = document.createElement('div');
					
					str += '<li><div><div>' + comm.memberId + '</div></div><div><div>' + comm.commentText + '</div></div>';
					
					list.innerHTML = str;
					document.getElementById('commentList').append(list);
				}
			}
			comment.send(null);
			$('#inputComment').val('');
		});
		
		$('#comment-load-btn').click();
	});