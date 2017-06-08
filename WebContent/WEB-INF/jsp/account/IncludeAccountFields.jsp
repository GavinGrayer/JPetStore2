

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!-- 引入spring的标签库 -->
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>


<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	
	$(function(){
		//姓名
		$("#firstname").blur(function(){
			var username=$("#firstname").val();
			if(username==""){
				$("#usernameerrMsg").show();
			}else{
				$("#usernameerrMsg").hide();
			}
		});
		
	//邮箱
		$("#email").blur(function(){
			var username=$("#email").val();
			if(username==""){
				$("#emailerrMsg").show();
			}else{
				$("#emailerrMsg").hide();
			}
		});
		
			//联系电话
		$("#phone").blur(function(){
			var username=$("#phone").val();
			if(username==""){
				$("#mobileerrMsg").show();
			}else{
				$("#mobileerrMsg").hide();
			}
		});
	
		
			//地址1
		$("#add1").blur(function(){
			var username=$("#add1").val();
			if(username==""){
				$("#add1errMsg").show();
			}else{
				$("#add1errMsg").hide();
			}
		});
		//地址2
			$("#add2").blur(function(){
			var username=$("#add2").val();
			if(username==""){
				$("#add2errMsg").show();
			}else{
				$("#add2errMsg").hide();
			}
		});
		
				//city
			$("#city").blur(function(){
			var username=$("#city").val();
			if(username==""){
				$("#cityerrMsg").show();
			}else{
				$("#cityerrMsg").hide();
			}
		});
		
		
			//area  区、县
			$("#state").blur(function(){
			var username=$("#state").val();
			if(username==""){
				$("#areaerrMsg").show();
			}else{
				$("#areaerrMsg").hide();
			}
		});
		
		
			//mail  邮政编码
			$("#zip").blur(function(){
			var username=$("#zip").val();
			if(username==""){
				$("#mailerrMsg").show();
			}else{
				$("#mailerrMsg").hide();
			}
		});
		
			//country  国籍
			$("#country").blur(function(){
			var username=$("#country").val();
			if(username==""){
				$("#countryerrMsg").show();
			}else{
				$("#countryerrMsg").hide();
			}
		});
		
		
		
	})
	
	
</script>




<h3>客户基本信息</h3>

<table>
  <tr>
    <td>姓名:</td><td><input type=text id="firstname" name="firstname" value="张三"/>
    <span id="usernameerrMsg"  style="color:red;display:none">姓名不能为空</span>
    <form:errors path="account.userid" cssStyle="color:red"></form:errors>
    </td>
  </tr><tr>
  <td>邮箱:</td><td><input type=text id="email" name="email" size="40" value="yourname@yooho.com">
    	<span id="emailerrMsg"  style="color:red;display:none">邮箱不能为空</span>
    	<form:errors path="account.email" cssStyle="color:red"></form:errors>
  </td>
</tr><tr>
  <td>联系电话:</td><td><input type=text id="phone" name="phone" size="40" value="13775357882"/>
    <span id="mobileerrMsg"  style="color:red;display:none">电话不能为空</span>
     <form:errors path="account.phone" cssStyle="color:red"></form:errors>
  </td>
</tr><tr>
  <td>地址1:</td><td><input type=text size="40" id="add1" name="addr1" value="南通市崇川区青年东路11号"/>
    <span id="add1errMsg"  style="color:red;display:none">地址不能为空</span>
     <form:errors path="account.addr1" cssStyle="color:red"></form:errors>
  </td>
</tr><tr>
  <td>地址2:</td><td><input type=text  size="40" id="add2" name="addr2" value="南通市崇川区中南世纪花城">
     <span id="add2errMsg"  style="color:red;display:none">地址不能为空</span>
      <form:errors path="account.addr2" cssStyle="color:red"></form:errors>
  </td>
</tr><tr>
  <td>城市:</td><td><input type=text  id="city" name="city" value="南通市"/>
     <span id="cityerrMsg"  style="color:red;display:none">城市不能为空</span>
     <form:errors path="account.city" cssStyle="color:red"></form:errors>
  </td>
</tr><tr>
  <td>区、县</td><td><input type=text size="4" id="state" name="state" value="崇川区"/>
    	<span id="areaerrMsg"  style="color:red;display:none">区县不能为空</span>
    	<form:errors path="account.state" cssStyle="color:red"></form:errors>
  </td>
</tr><tr>
  <td>邮政编码:</td><td><input type=text size="10" id="zip" name="zip" value="212000"/>
    <span id="mailerrMsg"  style="color:red;display:none">邮政不能为空</span>
    <form:errors path="account.zip" cssStyle="color:red"></form:errors>
  </td>
</tr><tr>
  <td>国籍:</td><td><input type=text  size="15" id="country" name="country" value="中国"/>
    <span id="countryerrMsg"  style="color:red;display:none">国籍不能为空</span>
    <form:errors path="account.country" cssStyle="color:red"></form:errors>
  </td>
</tr>
</table>

<h3>个人喜好</h3>

<table>
  <tr>
    <td>喜爱的语言:</td><td>
          <select id="langpref" name="langpref">
       <option>ENGLISH</option>
        <option>CHINESE</option>
 
      </select></td>
  </tr><tr>
  <td>喜欢的动物类别:</td><td>
     <select id="favcategory" name="favcategory">
         <option >CATS</option>
         <option>DOGS</option>
         <option>FISH</option>
         <option>REPTILES</option>
           <option>BIRD</option>
     </select></td>
</tr><tr>
  <td>根据喜爱动物类别为您推荐</td><td><input id="mylistopt" name="mylistopt" type="radio" value="1" checked="checked"/>是
  									<input id="mylistopt" name="mylistopt" type="radio" value="0" />否
  </td>
</tr><tr>
  <td>是否植入广告</td><td><input id="banneropt" name="banneropt" type="radio" value="1" checked="checked"/>是
  						<input id="banneropt" name="banneropt" type="radio" value="0" />否
  </td>
</tr>
</table>