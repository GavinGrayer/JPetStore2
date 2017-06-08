<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<!-- 引入jstl标签库 -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<div id="Catalog">

<div id="BackLink">

  <a href="<%=basePath%>/toMain">返回主菜单</a>

</div>
  <h2>${type }</h2>

  <table>
    <tr>
    	<th>产品编号</th>  
    	<th>产品名称</th>
    </tr>
   
   <c:forEach var="product" items="${typelist }">
   
    <tr>
   		<td><a href="<%=basePath%>/toProduct?productid=${product.productid }&&type=${type }&&name=${product.name }">${product.productid }</a></td>
   		<td>${product.name }</td>
    </tr>
   </c:forEach>
   
    <tr>
   		<td>
      
        <a class="Button" href="javascript:void(0)">&lt;&lt; 上一页</a>
     
        <a class="Button" href="javascript:void(0)">下一页 &gt;&gt;</a>
   
   		</td>
    </tr>
  </table>
  

</div>

<%@ include file="../common/IncludeBottom.jsp" %>


