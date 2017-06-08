<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<bean:define id="product" name="catalogBean" property="product"/>
<bean:define id="item" name="catalogBean" property="item"/>



<div id="Catalog">
<div id="BackLink">
<a href="<%=basePath%>/toProduct?productid=${productid }&&type=${type }&&name=${product.name }">
    返回到${product.name }</a>

</div>
  <table>
    <tr>
      <td>
       <image src="<%=basePath %>${image }">${infor }
      </td>
    </tr>
    <tr>
      <td>
        <b>${item.itemid }</b>
      </td>
    </tr><tr>
    <td>
      <b><font size="4">
       ${item.attr1 }${product.name }
      </font></b>
    </td></tr>
    <tr><td>
      ${product.name }
    </td></tr>
    <tr><td>
      ${qty }库存.
    
    </td></tr>
    <tr><td>
    $${item.listprice }

    <tr><td>
      <a class="Button" href="<%=basePath %>/cart?itemid=${item.itemid }&&productid=${productid }&&type=${type}">
       添加到购物车</a>
    </td></tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>



