<%@ include file="../common/IncludeTop.jsp" %>
  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!-- 引入jstl标签库 -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="Catalog">
<div id="BackLink">
  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
</div>
<table>
<tr><th align="center" colspan="2">
  订单 号1000 2013/02/21 11:13:31 
</th></tr>
<tr><th colspan="2">
付款详情
</th></tr>
<tr><td>
  信用卡类型:</td><td>
 维萨信用卡
</td></tr>
<tr><td>
信用卡号码:</td><td>999 9999 9999 9999 * 使用假号码!
</td></tr>
<tr><td>
 有效日期 (MM/YYYY):</td><td>12/03
</td></tr>
<tr><th colspan="2">
账单地址
</th></tr>
<tr><td>
  姓名:</td><td>张三</td></tr>

<tr><td>
 地址 1:</td><td>南通市崇川区青年东路
</td></tr>
<tr><td>
地址 2:</td><td>南通市中南世纪花城
</td></tr>
<tr><td>
城市: </td><td>南通
</td></tr>
<tr><td>
区、县:</td><td>崇川区 
</td></tr>
<tr><td>
邮政编码:</td><td>212000 
</td></tr>
<tr><td>
 国籍: </td><td>中国
</td></tr>
<tr><th colspan="2">
收货地址
</th></tr><tr><td>
姓名:</td><td>张三
</td></tr>
<tr><td>
  地址1:</td><td>南通市崇川区青年东路
</td></tr>
<tr><td>
地址2:</td><td>南通市中南世纪花城
</td></tr>
<tr><td>
城市: </td><td>南通
</td></tr>
<tr><td>
区、县:</td><td>崇川区
</td></tr>
<tr><td>
邮政编码:</td><td>212000
</td></tr>
<tr><td>
国籍: </td><td>美国
</td></tr>
<tr><td>
邮政公司: </td><td>汇通快递
</td></tr>
<tr><td colspan="2">
  状态:已付款
</td></tr>
<tr><td colspan="2">
  <table>
    <tr>
      <th>商品编号</th>
      <th>产品描述</th>
      <th>数量</th>
      <th>价格</th>
      <th>总金额</th>
    </tr>
   
     <c:forEach var="item" items="${itemList }">

     
      <tr>
        <td>${item.itemid }</td>
        <td>
           ${item.attr1 }${item.product.name }        
        </td>

        <td>${item.quantity }</td>
        <td>$${item.listprice }</td>
        <td>$${item.sumprice }</td>
      </tr>

   </c:forEach>
   
    <tr>
      <th colspan="5">总金额: $${sum }
      </th>
    </tr>
  </table>
</td></tr>

</table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>



