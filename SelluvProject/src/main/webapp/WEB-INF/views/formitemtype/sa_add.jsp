<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<li class="item-li" id="itemli-">
   <div id="i" class="container container-items">
      <!--  --><input type="hidden" id="i-" name="itemNums">
      <div class="form-item-num">
         <input id="necessaryflag-" type="hidden" value="N" name="necessaries">
         <div id="necessary-" class="col-sm-1 items-style necessary-style"><span class="glyphicon glyphicon-star"></div>
         <div id="item-remove-" class="col-sm-11 items-style item-remove-style"><button class="btn item-remove-btn"><span class="glyphicon glyphicon-remove"></span></button></div>      
         <div id="title-" class="col-sm-12 items-style item-style-title">항목제목</div>
            <!--  --><input type="hidden" name="titles" id="title-hidden-">
         <div id="description-" class="col-sm-12 items-style item-style-descript"></div>
            <!--  --><input type="hidden" name="descripts" id="descript-hidden-">
            <div id="type-" class="col-sm-12 items-style">
            <input id="itemtype-" type="hidden" value="sa" name="types"> 
            <div id="change-type-">
               <div class="col-sm-12" id="sa">
                  <input id="inputtype-" type="text" class="form-control" placeholder="주관식 단답형"
               disabled>
               </div>
            </div>
            </div>
            <input type="hidden" value="N" name="options" id="printOption-">
         </div>
      </div>
   <div id="setting-" class="container setting-items items-style"></div>
</li>   
</body>
</html>