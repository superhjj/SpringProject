	/* 댓글 로드하는 함수 */
	function loadComment(){
		while(document.getElementById('commentList').hasChildNodes()){
			document.getElementById('commentList').removeChild(document.getElementById('commentList').firstChild);
		}
		var comment = new XMLHttpRequest();
		
		comment.open('GET', 'commentSearch.do?contentCode=' + encodeURIComponent(document.getElementById('contentCode').value), true);
		
		comment.onreadystatechange = function() {
			if(comment.readyState == 4 && comment.status == 200){
				var comm = JSON.parse(comment.responseText);
				var list = document.createElement('div');
				var str = '';
				
				for(var i = 0; i < comm.length; i++){
					str += '<li><div><div>' + comm[i].memberId + '</div></div><div><div>' + comm[i].commentText + '</div></div>' + 
					'<form id=\"comment-form-' + i + '\" action=\"../commentDelete.do\" method=\"GET\"> <input id=\"member-' + i + '\" name=\"memberId\" type=\"hidden\" value=\"'+ comm[i].memberId + '\">' +
					'<input id=\"comment-' + i + '\" name=\"commentCode\" type=\"hidden\" value=\"' + comm[i].commentCode + '\">' +
					'<input id=\"content-'+ i + '\" name=\"contentCode\" type=\"hidden\" value=\"' + document.getElementById('contentCode').value + '\">' + 
					'<input id=\"writer-' + i + '\" name=\"writer\" type=\"hidden\" value=\"' + document.getElementById('writer').value + '\">' + 
					'<button type=\"button\" id=\"comment-delete-btn-' + i + '\">삭제</button></form>'+
					'</div>';
				}
				
				list.innerHTML = str;
				document.getElementById('commentList').append(list);
				
				for(var i = 0; i < comm.length; i++){
					$('#comment-delete-btn-' + i).click(function(){
						this.parentNode.submit();
					});
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
			var memberId = document.getElementById('writer').value;
			document.location.href="contentsDelete.do?contentCode=" + contents_code + "&memberId=" + memberId;
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

		$('#comment-btn').click(function(){
			console.log('추가 버튼 클릭');
			var comment = new XMLHttpRequest();
			comment.open('POST', 'commentInsert.do?commentText=' + encodeURIComponent(document.getElementById('inputComment').value) + 
					'&contentCode='+encodeURIComponent(document.getElementById('contentCode').value) + "&memberId=" + encodeURIComponent(document.getElementById('memberId').value), true);
			/* 마지막에 memberId를 삭제해야 함 */
			comment.onreadystatechange = function(){
				if(comment.readyState == 4 && comment.status == 200){
					var comm = JSON.parse(this.responseText);
					var str = '';
					var list = document.createElement('div');
					
					var size = document.getElementById('commentList').firstChild.childNodes.length;
					console.log('댓글의 개수 : ' + size);
					
					str += '<li><div><div>' + comm.memberId + '</div></div><div><div>' + comm.commentText + '</div></div>' + 
					'<form id=\"comment-form-' + (size + 1) + '\" action=\"../commentDelete.do\" method=\"GET\"> <input id=\"member-' + (size + 1) + '\" name=\"memberId\" type=\"hidden\" value=\"'+ comm.memberId + '\">' +
					'<input id=\"comment-' + (size + 1) + '\" name=\"commentCode\" type=\"hidden\" value=\"' + comm.commentCode + '\">' +
					'<input id=\"content-'+ (size + 1) + '\" name=\"contentCode\" type=\"hidden\" value=\"' + document.getElementById('contentCode').value + '\">' + 
					'<input id=\"writer-' + (size + 1) + '\" name=\"writer\" type=\"hidden\" value=\"' + document.getElementById('writer').value + '\">' + 
					'<button type=\"button\" id=\"comment-delete-btn-' + (size + 1) + '\">삭제</button></form>'+
					'</div>';;
					
					list.innerHTML = str;
					document.getElementById('commentList').append(list);
					
					$('#comment-delete-btn-' +(size + 1)).click(function(){
						this.parentNode.submit();
					});
				}
			}
			comment.send(null);
			$('#inputComment').val('');
			loadComment();
		});
		
		$('#comment-load-btn').click(function(){
			loadComment();
		});
		
		$('#comment-load-btn').click();
	});