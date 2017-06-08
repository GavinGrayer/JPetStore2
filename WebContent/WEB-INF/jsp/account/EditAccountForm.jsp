<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>


<script type="text/javascript">
	
	$(function(){
		
		
	$("#userid").blur(function(){
			
			var userid=$("#userid").val();
			
			console.log("<<<<<<"+userid);
			
			if(userid==""){
			
				$("#useridnullMsg").show();
			}else{
		
				$("#useridnullMsg").hide();
			}
		
		});
		
		
		
		$("#password").blur(function(){
			
			var password=$("#password").val();
			
			console.log("<<<<<<"+password);
			
			if(password==""){
			
				$("#passworderrMsg").show();
			}else{
		
				$("#passworderrMsg").hide();
			}
		
		});
		
		$("#reppassword").blur(function(){
			
			var password=$("#password").val();
			var reppassword=$("#reppassword").val();
			
			console.log("<<<<<<"+password);
			
			if(password==""){
		
				$("#reppassworderrMsg1").show();
			}else if(reppassword!=password){
				$("#reppassworderrMsg1").hide();
				$("#passworderrMsg2").show();
			}else{
				$("#reppassworderrMsg1").hide();
				$("#passworderrMsg2").hide();
			}
		
		});
		
		
	})
	

</script>


<div id="Catalog">

<form method="post" action="<%=basePath %>/edit/tomain">

 

    <h3>账户信息</h3>

    <table>
      <tr>
        <td>账户:</td><td><input type="text" id="userid" name="userid" readonly="readonly" value="j2ee">

        <span id="useridnullMsg" style="color:red;display:none">账户不能为空</span>
        </td>
      </tr><tr>
      <td>新密码:</td><td><input type="password" id="password" name="password" value="j2ee">
      	 <span id="passworderrMsg"  style="color:red;display:none">密码不能为空</span>
      </td>
    </tr><tr>
      <td>重复密码:</td><td><input id="reppassword" type="password">
      	 <span id="reppassworderrMsg1"  style="color:red;display:none">密码不能为空</span>
      <span id="passworderrMsg2"  style="color:red;display:none">密码不一致</span>
      
      </td>
    </tr>
    </table>
    <%@ include file="IncludeAccountFields.jsp" %>

    <input type="submit" name="submit" value="保存账户资料"/>



</form>
  <a href="<%=basePath %>/viewOrder?userid=${sessionScope.username}">我的订单</a>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>


