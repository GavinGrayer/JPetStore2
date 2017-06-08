<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>



<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	
	$(function(){
		
			$("#username").blur(function(){
				var username=$("#username").val();

				if(username==""){
					
					$("#unerr").show();
				}
				
			});
		
			$("#password").blur(function(){
				
				var password=$("#password").val();
				
				if(password==""){

					$("#pwderr").show();
				}
			
			})
		
	})
	

</script>




<div id="Catalog">
  <form action="<%=basePath %>/login" method="POST">

    <p>请输入您的用户名和密码.</p>
    
    <table text-align="center" align="center">
    	<tr>
    		<td>用户名:</td>
    		<td><input type="text" id="username" name="userid" value="j2ee"/>
    			<span id="unerr" style="color:red;display:none">用户名不能为空</span>
    		</td>
			
    	</tr>
    
    	<tr>
    		<td>密&nbsp;码:</td>
    		<td><input type="password" id="password" name="password" value="j2ee"/>
    		<span id="pwderr" style="color:red;display:none">密码不能为空</span></td>
    	</tr>

    	
    
    </table>

      <input type="submit" name="submit" value="登录"/>
      <span style="color:red">${errorMsg }</span>
    
    
    

  </form>

需要用户名和密码？
  <a href="<%=basePath %>/toNewAccountForm">立即注册!</a>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>

