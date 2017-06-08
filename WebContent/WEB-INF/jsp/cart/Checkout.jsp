<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<!-- 引入jstl标签库 -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="Catalog">
<div id="BackLink">
<a href="<%=basePath %>/cart/Cart.jsp">返回到购物车</a>
</div>

  <table>
    <tr>
      <td>
        <h2>核对信息</h2>

        <table>

          <tr>
            <td><b>商品编号</b></td>  <td><b>产品编号</b></td>  <td><b>产品描述</b></td> <td><b>In Stock?</b></td>
            <td><b>产品数量</b></td>  <td><b>定价</b></td> <td><b>总成本</b></td>
          </tr>

        
        
        <c:forEach var="item" items="${itemList}">
            
            <tr>
              <td><a href="<%=basePath %>/catalog/Product.jsp">${item.itemid }</a></td>
              <td>${item.product.productid }</td>
              <td>${item.attr1 }${item.product.name }</td>
              <td>${item.qty }</td>
              <td>
                ${item.quantity }
              </td>
              <td>$${item.listprice }</td>
              <td>$${item.sumprice }</td>
            </tr>
            
        </c:forEach> 
        
        
        
          <tr>
            <td colspan="7">
              总金额:$${sum }
            </td>
          </tr>
        </table>
        
        
        
          <a href="javascript:void(0);" class="Button">&lt;&lt; 上一页</a>
       
          <a href="javascript:void(0)" class="Button">下一页&gt;&gt;</a>
        
        <a class="Button" href="<%=basePath %>/toNewOrderForm?sum=${sum }">继续</a>
      </td>
  

    </tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





