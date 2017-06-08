<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>


<!-- 引入jstl标签库 -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="Catalog">
<div id="BackLink">

  <a href="<%=basePath %>/type?type=${type }">
  返回 ${type }</a>

</div>
  <h2>${name }</h2>

  <table>
    <tr><th>商品编号</th>  <th>产品编号</th>  <th>产品描述</th>  <th>定价</th>  <th>&nbsp;</th></tr>
   
   
   <c:forEach var="item" items="${itemlist }">
      <tr>
        <td><a href="<%=basePath %>/ProductToItem?itemid=${item.itemid }&&productid=${productid }&&type=${type}">${item.itemid }</a></td>
        <td>${productid }</td>
        <td>${item.attr1 }${name }</td>
        <td>$${item.listprice }</td>
        <td><a href="<%=basePath %>/cart?itemid=${item.itemid }&&productid=${productid }&&type=${type}" class="Button"> 添加到购物车</a></td>
      </tr>
   </c:forEach>
   
   
    <tr><td>
      
        <a class="Button" href="javascript:void(0)">&lt;&lt; 上一页</a>
     
        <a class="Button" href="javascript:void(0)">下一页 &gt;&gt;</a>
   
    </td></tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





