<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!-- 引入jstl标签库 -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div id="Catalog">
<h2>我的订单</h2>

<table >
  <tr><th>订单编号</th>  <th>日期</th>  <th>总金额</th></tr>


	
	<c:forEach var="orders" items="${orderlist}">
	
	
	

    <tr>		
      <td><a href="<%=basePath %>/order/ViewOrder.jsp">${orders.orderid } </a></td>
      <td>${orders.orderdate } </td>
      <td>$${orders.totalprice }</td>
    </tr>
    
    
    </c:forEach>
  
</table>


  <a href="javascript:void(0);" class="Button">&lt;&lt; 上一页</a>

  <a href="javascript:void(0);" Class="Button">下一页 &gt;&gt;</a>

</div>
<%@ include file="../common/IncludeBottom.jsp" %>


