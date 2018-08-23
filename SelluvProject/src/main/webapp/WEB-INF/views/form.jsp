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
$(document).ready(function() {
   
   
   /*    $.post('./login.action', {
         id : id,
         psd : psd
      }, function(data, status) {
         if (status == "success") {
            alert(data);
         } else {
            alert("실패");
         }
      }); */
      $('#formadd').on('click', function(e){
   /*       $('#formInsert').attr('action','formInsert.do');
         $('#formInsert').attr('method','post');
         $('#formInsert').submit(); */
   /*       var formTitle = $('#title-0').text();
         var formContent = $('#description-0').text();
         var memberId = '${sessionScope.memberId}';
         var periodFlag = $('#itemtype-0').val();
         var formStartDate = $('#start-date').text();
         var formEndDate = $('#end-date').text();
         var formHtml = $('html').html();
         
         alert(periodFlag); */
         
   /*       $.post('formInsert.do',{
            formTitle:formTitle,
            formContent:formContent,
            memberId:memberId,
            periodFlag:periodFlag,
            formStartDate:formStartDate,
            formEndDate:formEndDate,
            formHtml:formHtml
         },function(status){
            if(status=="success"){
               console.log("post ok");   
            }
            else{
               console.log("post fail");
            }
         }); */
         
         $('#memberId').val('${sessionScope.memberId}');
         $('#formHtml').val($('.body-container').html());
         $('#formInsert').attr('method','POST');
         $('#formInsert').attr('action','formInsert.do');
         $('#formInsert').submit();
         
      });
      
      
      if ($("#isopen-check").is(":checked")) {
         $('#start-date-input').attr("disabled", false);
         $('#end-date-input').attr("disabled", false);
      } else {
         $('#start-date-input').attr("disabled", true);
         $('#end-date-input').attr("disabled", true);
      }
      
      
      $(document).on('mouseover', '#form-item-list li div, #form-item-list li div div h1, #form-item-list li div div h4, #form-item-list li div div div input, #form-item-list li div div div textarea,#form-item-list li div div div span, #form-item-list li div div div button', function(event){
         var obj = this;
         var elem = $(obj);
         if (obj == event.target) {
            if(elem.attr('class')== 'container container-items'){
               elem.css('border', '3px solid white');               
            }
            else{
               var findElem = elem.closest('.container-items').css('border', '3px solid white');
               elem=findElem;
            }
         }
         if($('li').length > 2){
         var elemId = elem.attr('id');
         $('#item-remove-'+elemId).css('display','block');
         }
      });

      $(document).on('mouseout', '#form-item-list li,  #form-item-list li div, #form-item-list li div div h1, #form-item-list li div div h4, #form-item-list li div div div input, #form-item-list li div div div textarea, #form-item-list li div div div span, #form-item-list li div div div button', function(event){
         var obj = this;
         var elem = $(obj);
         if (obj == event.target) {
            if(elem.attr('class')== 'container container-items'){
               elem.css('border', '0px solid #ccc');         
            }
            else{
               var findElem = elem.closest('.container-items').css('border', '0px solid #ccc');
               elem=findElem;
            }
         }
         if($('li').length > 2){
         var elemId = elem.attr('id');
         $('#item-remove-'+elemId).css('display','none');
         }
      });
      
      $(document).on('click', '#itemadd', function(event){
         $.ajax({
            url : 'formitemtype/sa_add.jsp',
            type : 'POST',
            datatype : "html",
            success : function(data) {
               var children =  parseInt($('li').last().children('div').attr('id'))+1;   
               
               for(var i=0;i<children; ++i){
                  if($('#setting-'+i).css('display') != 'none'){
                     if(i == 0){
                        $('#form-basic-ok'+i).click();   
                     }else{
                        $('#item-write-ok-'+i).click();               
                     }
                  }
               }
                  $('#form-item-list').append(data);
                  $('#itemli-').attr('id', 'itemli-' + children);
                  $('#i').attr('id', children);
                  $('#necessary-').attr('id', 'necessary-'+children);
                  $('#item-remove-').attr('id', 'item-remove-'+children);
                  $('#title-').attr('id', 'title-'+children);
                  $('#description-').attr('id', 'description-'+children);
                  $('#type-').attr('id', 'type-'+children);
                  $('#change-type-').attr('id', 'change-type-'+children);
                  $('#itemtype-').attr('id', 'itemtype-' +children);
                  $('#inputtype-').attr('id', 'inputtype-' + children);
                  $('#setting-').attr('id', 'setting-'+ children);
                  $('#necessaryflag-').attr('id','necessaryflag-'+children);
                  
                  $('.setting-items').hide();
                  $('.container-items').show();
                  $('#'+children).click();
            }
         });
      });
      
      
      $(document).on('click', '.item-remove-btn', function(event){
         var obj = $(this);
         var objElemId = obj.closest('.container-items').attr('id');
         if($('li').length > 2){
            $('#itemli-'+objElemId).remove();
         }
         /* var findElem = this.closest('.container-items').attr('id');
         alert(findElem); */
      });
      
      $(document).on('click','.ss-delete-btn', function(event){
         var obj = $(this);
         var option = obj.closest('.form-check');
         var optionId = option.attr('id');
         var box = obj.closest('.ss-box');
         
         if(box.children().length>1){
            option.remove();
         }
         
         if(box.children().length == 1){
            box.find('.ss-delete-btn').hide();
         }
      });
      
      $(document).on('click','.ms-delete-btn', function(event){
         var obj = $(this);
         var option = obj.closest('.form-check');
         var optionId = option.attr('id');
         var box = obj.closest('.ms-box');
         
         if(box.children().length>1){
            option.remove();
         }
         
         if(box.children().length == 1){
            box.find('.ms-delete-btn').hide();
         }
      });


      if($("#itemtype-0").val()=='open'){
         $("#type-0").css("display","block");
      }
      else{
         $("#type-0").css("display","none");
      }
      
      
      /* $(document).on('click','#ss-add-btn',function(e) */

      /* $('#ss-add-btn').click(function(e) */
      $(document).on('click','#ss-add-btn',function(e){
         var settingItem = $(this).closest('.setting-items');
         var itemId = settingItem.attr('id').substring(8);
         var box = settingItem.find('.ss-box');
         var sample2= box.children('div').last();
         if(sample2.attr('id') == 'ssoption-'){
            
            sample2.attr('id','ssoption-'+itemId+'-1');
            
            $('#ssoption-val-').attr('id','ssoption-val-'+itemId+'-1');
            $('#ss-delete-btn-').attr('id','ss-delete-btn-'+itemId+'-1');
            
         }
         var sample3 = sample2.attr('id').substring(11);
         var optionNum = parseInt(sample3)+1;
         
         
         box.append('<div class="form-check" id="ssoption-"></div>');
         $('#ssoption-').attr('id','ssoption-'+itemId+'-'+optionNum);
         $('#ssoption-'+itemId+'-'+optionNum).append('<div class="col-sm-1 form-check-label"> <input class="form-check-input" type="radio" name="radios" disabled></div><div class="col-sm-10"><input type="text" class="form-control form-option-input" placeholder="옵션" id="ssoption-val-"></div><div class="col-sm-1 item-option-btn"><span id="ss-delete-btn-" class="glyphicon glyphicon-remove-circle ss-delete-btn"></span></div>');
         $('#ssoption-val-').attr('id','ssoption-val-'+itemId+'-'+optionNum);
         $('#ss-delete-btn-').attr('id','ss-delete-btn-'+itemId+'-'+optionNum);
         
         box.find('.ss-delete-btn').show();
      });
      
      $(document).on('click','#ms-add-btn',function(e){
         
         var settingItem = $(this).closest('.setting-items');
         var itemId = settingItem.attr('id').substring(8);
         var box = settingItem.find('.ms-box');
         var sample2= box.children('div').last();
         if(sample2.attr('id') == 'msoption-'){
            
            sample2.attr('id','msoption-'+itemId+'-1');
            
            $('#msoption-val-').attr('id','msoption-val-'+itemId+'-1');
            $('#ms-delete-btn-').attr('id','ms-delete-btn-'+itemId+'-1');
            
         }
         
         var sample3 = sample2.attr('id').substring(11);
         var optionNum = parseInt(sample3)+1;
         
         
         box.append('<div class="form-check" id="msoption-"></div>');
         $('#msoption-').attr('id','msoption-'+itemId+'-'+optionNum);
         $('#msoption-'+itemId+'-'+optionNum).append('<div class="col-sm-1 form-check-label"> <input class="form-check-input" type="checkbox" name="checkes" disabled></div><div class="col-sm-10"><input type="text" class="form-control form-option-input" placeholder="옵션" id="msoption-val-"></div><div class="col-sm-1 item-option-btn"><span id="ms-delete-btn-" class="glyphicon glyphicon-remove-circle ms-delete-btn"></span></div>');
         $('#msoption-val-').attr('id','msoption-val-'+itemId+'-'+optionNum);
         $('#ms-delete-btn-').attr('id','ms-delete-btn-'+itemId+'-'+optionNum);
         
         box.find('.ms-delete-btn').show();
      });
      
      $.ajax({
         url : 'form_title.jsp',
         type : 'POST',
         datatype : "html",
         success : function(data) {   
            /* var current = $(data).find('form-item'); */
            /* alert(itemtype.val()); */
            /* $('#form-item-list li>div.setting-items').checkshow(); 
                  var formTitle = $('#title-0').text();
         var formContent = $('#description-0').text();
            */
            $('#setting-0').html(data);
            $('#setting-0').hide();
            $('#form-item-title').val($('#title-0').text());
            $('#form-item-description').val($('#description-0').text());
            
            
            console.log('2');
            if($('#itemtype-0').val()=='open'){
               $("#isopen-check").prop('checked', true) ;
               $('#start-date-input').val($('#start-date').text());
               $('#end-date-input').val($('#end-date').text());   
            }
            else if($('#itemtype-0').val()=='not open'){
               $("#isopen-check").prop('checked', false) ;
               $('#start-date').text("");
               $('#end-date').text("");
               
            }

            }
            
         });


   $(document).on('click', '.container-items, .container-items>div .container-items input', function(event){ 

   var obj = this;
   var elem = $(this);
   if(elem.attr('class')!= 'container container-items'){
      elem = elem.closest('.container-items');
   }
   var itemId = elem.attr('id');
   var title = $('#title-' + itemId);
   var description = $('#description-' + itemId);
   var itemtype = $('#itemtype-' + itemId);
   /* alert(itemId +','+title.text()+','+description.text()+','+itemtype.val()); */
   if(itemId != '0'){
   $.ajax({
      url : 'form_item.jsp',
      type : 'POST',
      datatype : "html",
      data : {
         'itemId' : itemId,
         'title' : title.text(),
         'description' : description.text(),
         'itemtype' : itemtype.val()
      },
      success : function(data) {   
         /* var current = $(data).find('form-item'); */
         /* alert(itemtype.val()); */
         /* $('#form-item-list li>div.setting-items').checkshow(); */
         if($('#setting-' + itemId).is(':empty')){
            $('#setting-' + itemId).html(data);
            /* $('#form-item-title-').val(title.text()); */
            /* $('#form-item-description-').val(description.text()); */
            /* $('#form-type-selectbox-').val(itemtype.val()).prop('selected',true); */
            if($('#necessaryflag-'+itemId).val()=='yes'){
               $('#necessary-input-').prop('checked',true);
            }
            else{
               $('#necessary-input-').prop('checked',false);
            }
            
            $('#current-type-').load('formitemtype/' + $('#form-type-selectbox- option:selected').val() + '.jsp');
            
            $('#form-item-title-').attr('id','form-item-title-'+itemId);
            $('#form-item-description-').attr('id','form-item-description-'+itemId);
            $('#form-type-selectbox-').attr('id','form-type-selectbox-'+itemId);
            $('#necessary-input-').attr('id','necessary-input-'+itemId);
            $('#current-type-').attr('id','current-type-'+itemId);
            $('#form-type-selectbox-').attr('id','form-type-selectbox-'+itemId);
            /* $('#item-write-cancel-').attr('id','item-write-cancel-'+itemId); */
            $('#item-write-ok-').attr('id','item-write-ok-'+itemId);
         }


         /* $('#form-type-selectbox').change(function() {
            console.log(select);
         }); */
         /* $(document).on('change','#form-type-selectbox-'+itemId, function(e){ */
         $('#form-type-selectbox-'+itemId).change(function(e){
            
            //같은 것 간의 이벤트 버블 방지
            if(e.stopImmediatePropagation) e.stopImmediatePropagation(); //MOZILLA
            else e.isImmediatePropagationEnabled = false;
            $('#current-type-'+itemId).load('formitemtype/' + $('#form-type-selectbox-'+itemId+' option:selected').val() + '.jsp');
         });
         

         $('#'+itemId).hide();
         $('#setting-' + itemId).show();
         
         
         
         $('#item-write-ok-'+itemId).click(function(e){
            //같은 것 간의 이벤트 버블 방지
            if(e.stopImmediatePropagation) e.stopImmediatePropagation(); //MOZILLA
            else e.isImmediatePropagationEnabled = false;
            
               var newTitle = $('#form-item-title-'+itemId).val();
                 var newDescription = $('#form-item-description-'+itemId).val();
                 var newType = $('#form-type-selectbox-'+itemId+' option:selected').val();
               /* alert('newtype : '+ newType + '  ,itemId' + itemId); */
                 if($('#necessary-input-'+itemId).prop('checked')==true){
                  $('#necessaryflag-'+itemId).val('yes'); 
                  $('#necessary-'+itemId).css('color','red');
               }
               else{
                  $('#necessaryflag-'+itemId).val('no');
                  $('#necessary-'+itemId).css('color','pink');
               }
                 
                 
               if(newTitle==""){
                  newTitle="항목제목";
               }
               if(newDescription==""){
                  $('#description-'+itemId).hide();
               }
               else{
                  $('#description-'+itemId).show();
                  $('#description-'+itemId).text(newDescription);
               }
                 $('#title-'+itemId).text(newTitle);
                 
                 $('#itemtype-'+itemId).val(newType);
                 if(newType == 'ss'){
                    /* var findElem = elem.closest('.container-items').css('border', '3px solid white'); */ 
                    var ssBox = $('#setting-'+itemId).find('.ss-box'); /////////////////////
                   var sample2= ssBox.children('div').last();
                    if(sample2.attr('id') == 'ssoption-'){
                       
                       sample2.attr('id','ssoption-'+itemId+'-1');
                       
                       $('#ssoption-val-').attr('id','ssoption-val-'+itemId+'-1');
                       $('#ss-delete-btn-').attr('id','ss-delete-btn-'+itemId+'-1');
                       
                    }
                   
                   
                   
                   $('#change-type-'+itemId).empty();
                   
                   for(var i=1; i<=ssBox.children().length;++i){
                      $('#change-type-'+itemId).append('<div class="col-sm-1 form-option-btn"> <input class="form-check-input" id="form-radio-" type="radio" name="radios"></div><div class="col-sm-11 formoption-val" id="formoption-"></div>');
                      /* alert('test1'+$('#ssoption-val-'+itemId+'-'+i).val());
                      alert('test3'+ssBox.children().eq(i-1).find($('.form-option-input')).val()); */
                      /* $('#ssoption-val-'+itemId+'-'+i).val() == "" */
                      if(ssBox.children().eq(i-1).find($('.form-option-input')).val() == ""){
                         $('#formoption-').text("옵션"+i);  
                      }
                      else{
                         $('#formoption-').text(ssBox.children().eq(i-1).find($('.form-option-input')).val());
                      }
                      
                      $('#formoption-').attr('id','formoption-'+itemId+'-'+i);
                      $('#form-radio-').attr('name','radios-'+itemId);
                      $('#form-radio-').val($('#formoption-'+itemId+'-'+i).text());
                      $('#form-radio-').attr('id','form-check-input-'+itemId+'-'+i);
                   }
                   
                   
                   /* $('#change-type-'+itemId).append(ssHtml); */
                   /* $('.form-option-input').attr('disabled',true); */
                 }
                 else if(newType=='ms'){
                    var msBox = $('#setting-'+itemId).find('.ms-box'); /////////////////////
                      var sample2= msBox.children('div').last();
                       if(sample2.attr('id') == 'msoption-'){
                          sample2.attr('id','msoption-'+itemId+'-1');
                          $('#msoption-val-').attr('id','msoption-val-'+itemId+'-1');
                          $('#ms-delete-btn-').attr('id','ms-delete-btn-'+itemId+'-1');
                          
                       }
                     
                      $('#change-type-'+itemId).empty();
                      
                      for(var i=1; i<=msBox.children().length;++i){
                         $('#change-type-'+itemId).append('<div class="col-sm-1 form-option-btn"> <input class="form-check-input" id="form-check-" type="checkbox" name="checkes"></div><div class="col-sm-11 formoption-val" id="formoption-"></div>');
                        
                         /* $('#msoption-val-'+itemId+'-'+i).val() == "" */
                         if(msBox.children().eq(i-1).find($('.form-option-input')).val() == ""){
                            $('#formoption-').text("옵션"+i);  
                         }
                         else{
                            $('#formoption-').text(msBox.children().eq(i-1).find($('.form-option-input')).val());
                         }
                         
                         $('#formoption-').attr('id','formoption-'+itemId+'-'+i);
                         $('#form-check-').attr('name','checkes-'+itemId);
                         $('#form-check-').val($('#formoption-'+itemId+'-'+i).text());
                         $('#form-check-').attr('id','form-check-input-'+itemId+'-'+i)
                         
                      }
                 }
                 else{
                       $('#change-type-'+itemId).load('formitemtype/'+newType+'.jsp');
                 }
                 
                 /* $('#setting-' + itemId).empty(); */
                  $('#setting-' + itemId).hide();
                  $('#'+itemId).show();
         });
         
         /* $('#item-write-cancel-'+itemId).click(function(e){
                  //$('#setting-' + itemId).empty(); 
                if(e.stopImmediatePropagation) e.stopImmediatePropagation(); //MOZILLA
            else e.isImmediatePropagationEnabled = false;
                  $('#setting-' + itemId).hide();
                  $('#'+itemId).show();
         }); */
         
         $('.container-items').click(function(e){
            if($('#setting-' + itemId).css("display") != "none") {
                  if(!$('#setting-' + itemId).has(e.target).length) { 
                       /* $('#item-write-ok').click(); */
                      /*  var param_obj = {data : {title: title.text(), description: description.text(), itemtype.val()}};  */
                       /* item_write(param_obj); */
   /*                                 $('#item-write-ok').click(param_obj); */
                        $('#item-write-ok-'+itemId).click();
                   } 
              }
         });
                        
   /*                $('#itemadd').click(function(e){
            $('#item-write-ok-'+itemId).click();
         }) */
      }
   });
   }
   else{
            $('#'+itemId).hide();
            $('#setting-' + itemId).show();

            $("#isopen-check").change(function() {
               if ($("#isopen-check").is(":checked")) {
                  $('#start-date-input').attr("disabled", false);
                  $('#end-date-input').attr("disabled", false);
               } else {
                  $('#start-date-input').attr("disabled", true);
                  $('#end-date-input').attr("disabled", true);
               }
            });
            $('#form-basic-ok').click(function(e){
               
               var start_date = new Date($('#start-date-input').val());
               var end_date = new Date($('#end-date-input').val());
               console.log(start_date);
               console.log(end_date);
               if(end_date - start_date < 0){
                  alert('시작일자가 종료일자보다 클 수 없습니다.');
               }
               else{
                  var newTitle = $('#form-item-title').val();
                    var newDescription = $('#form-item-description').val();
                  var newStartDate = $('#start-date-input').val();
                  var newEndDate = $('#end-date-input').val();
                    
                  if(newTitle==""){
                     newTitle="주문서 제목";
                  }
                  if(newDescription==""){
                     newDescription="주문서 설명";
                  }
                  
                  
                    $('#title-'+itemId).text(newTitle);
                    $('#description-'+itemId).text(newDescription);
                    if($("#isopen-check").is(":checked")){
                     $('#itemtype-'+itemId).val('open');
                     $('#start-date').text(newStartDate);
                     $('#end-date').text(newEndDate);
                     $("#type-0").css("display","block");
                  }
                  else{
                     $('#itemtype-'+itemId).val('not open');
                     $("#type-0").css("display","none");
                  }

                    
                    /* $('#setting-' + itemId).empty(); */
                     $('#setting-' + itemId).hide();
                     $('#'+itemId).show();
               }
            });
            
            $('#form-basic-cancel').click(function(e){
                    /* $('#setting-' + itemId).empty(); */
                     $('#setting-' + itemId).hide();
                     $('#'+itemId).show();
            });
            
            $(".container-items").click(function(e) { 
                 if($('#setting-' + itemId).css("display") != "none") {
                     if(!$('#setting-' + itemId).has(e.target).length) { 
                        $('#form-basic-ok').click();   
                      } 
            }
            });
   }

   /* $('.container-items, .container-items>div .container-items input').off('click'); */

   });

      
      /* $(document).off('click').on('click', '.container-items, .container-items>div .container-items input', function(event){ */

      
   });
</script>
<link href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" rel="stylesheet">
<style>
.container-items {
   margin: 0 auto;
   background-color: pink;
   padding-bottom:20px;
   max-width:950px;
   min-widht:800px;
}

.form-item {
   height: auto;   
}

.col-sm-12>a {
   color: white;
}

.form-check-input {
   color: white;
}

.select {
   display: block;
}


.form-item-num {
   margin: 10px 10px;
}

.curtain {
   display: none;
   left: 0px;
   top: 0px;
   width: 100%;
   height: 100%;
   z-index: 5000;
   background-color: rgba(0, 0, 0, 0.5);
}

ul li {
   list-style-type: none;
}




.isopen-area {
   text-align: right;
}

.isopen-date-title {
   margin: 0 0;
   padding: 0 0;
   width: 70px;
}

.item-menu-btn {
   font-size: 20px;
   color: pink;
   text-align: right;
}

.form-ul-body {
   margin: 0px 0px;
   padding: 0 0;
   font-family: 'Jeju Gothic', cursive;
}

.form-write-btn{
   margin: 15px 15px;
   text-align:center;
}

.items-style{
   padding: 5px 15px;
}

.setting-items {
   display: none;
   padding: 5px 0;
   padding-top: 20px;
   border: 3px solid pink;
      max-width:950px;
   min-widht:800px;
}

.necessary-style{
   font-size:10px;
   text-align:left;
   color:pink;
   height:24px;
}

.item-remove-style{
   color:white;
   text-align:right;
   padding:0 0;
   margin:0 0;
   height:24px;
   display:none;
}

.item-remove-btn{
   color:white;
   background-color:transparent;
   padding:0 0;
   border:0px solid transparent;
}

.item-remove-btn : hover{
   color:red;   
}

.date-title{
   width:80px;
   padding-right: 0px;
    padding-left: 0px;
}

.date-content{
   padding-right: 15px;
    padding-left: 15px;
}

.date-content-input{
   width:150px;
   padding-right: 5px;
    padding-left: 5px;
}

.form-check{
   height: 40px;
}

.form-check-label{
   height: 34px;
   padding: 7px 0px;
}

.item-option-btn{
   height: 34px;
   padding: 7px 0px;
   font-size: 20px;
   color: pink;
   text-align: center;
}
.formoption-val{
   padding: 0 0; 
}

.form-option-btn{
   padding: 0 0;
   margin:0 0;
   text-align: center;
}

.form-check-label{
   text-align: center;
}

.item-menu {
   text-align: right;
   font-size: 20px;
}

.option-button {
   text-align: right;
   margin-bottom:10px;
}

.select-on{
   display:block;
}

.select-off{
   display:none;
}

.form-check{
   margin: 5px 5px;
}

.ss-delete-btn{
   display: none;
}

.zip-code-div{
   padding : 0 0;
   margin-bottom : 15px;
}

.item-style-title{
   
   font-size: 20px;
}

.item-style-descript{
   padding-left : 30px;
}
</style>
<link rel="stylesheet" href="css/formbutton.css">
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form id="formInsert">
   <div class="body-outer">
   <div class="body-container">
      <ul class="form-ul-body" id=form-item-list>
         <li class="item-li" id="itemli-0">
            <div id="0" class="container container-items">
               <div class="form-item-num">
                  <div><h1 id="title-0" class="items-style">주문서제목</h1></div>
                  <div><h4 id="description-0" class="items-style">주문서 설명</h4></div>
                  <div id="type-0" class="col-sm-12">
                  <input id="itemtype-0" type="hidden" value="not open"> 
                      <div class="col-sm-2 isopen-date-title"> 
                       시작일자 : 
                       </div>
                       <div class="col-sm-2" id="start-date">
                         </div>
                         <div class="col-sm-2 isopen-date-title">
                         종료일자 : 
                         </div>
                         <div class="col-sm-2" id="end-date">
                         </div>
                  </div>
               </div>
            </div>
            <div id="setting-0" class="container setting-items items-style"></div>
         </li>
         <li class="item-li" id="itemli-1">
   <div id="1" class="container container-items">
      <div class="form-item-num">
         <input id="necessaryflag-1" type="hidden" value="no"> 
         <div id="necessary-1" class="col-sm-1 items-style necessary-style">
            <span class="glyphicon glyphicon-star"></span>
         </div>
         <div id="item-remove-1"
            class="col-sm-11 items-style item-remove-style">
            <button class="btn item-remove-btn">
               <span class="glyphicon glyphicon-remove"></span>
            </button>
         </div>
         <div id="title-1" class="col-sm-12 items-style item-style-title">항목제목</div>
         <div id="description-1" class="col-sm-12 items-style item-style-descript">항목설명</div>
         <div id="type-1" class="col-sm-12 items-style">
            <input id="itemtype-1" type="hidden" value="sa">
            <div id="change-type-1">
               <div class="col-sm-12" id="sa">
                  <input type="text" class="form-control" placeholder="주관식 단답형"
                     disabled>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div id="setting-1" class="container setting-items items-style"></div>
</li>
      </ul>
      <div class="form-write-btn">
<!--          <input type="button" id="itemadd" class="btn item-add" value="추가"/>
         <input type="button" id="formadd" class="btn form-add" value="등록"/> -->
         <div class="buttons">
               <button type="button" class="blob-btn" id="itemadd">
                  ADD ITEM<span class="blob-btn__inner"> <span
                     class="blob-btn__blobs"> <span class="blob-btn__blob"></span>
                        <span class="blob-btn__blob"></span> <span
                        class="blob-btn__blob"></span> <span class="blob-btn__blob"></span>
                  </span>
                  </span>
               </button>
               <button type="button" class="blob-btn" id="formadd">
                  ADD FORM <span class="blob-btn__inner"> <span
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
      <input type="hidden" id="memberId" name="memberId" val=${sessionScope.memberId}>
      <input type="hidden" id="formHtml" name="formHtml">
   </div>
      </form>
</body>
</html>