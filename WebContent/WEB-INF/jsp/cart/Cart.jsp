
<%@page import="com.web.entity.Item"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%@ include file="../common/IncludeTop.jsp" %>

<!-- 引入jstl标签库 -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="Catalog">

<div id="BackLink" >
  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
</div>
  <div id="Cart">

    <h2>购物车</h2>
    <form  action="<%=basePath %>/updateSumPrice"  method="post">
      <table>
        <tr>
          <th><b>商品编号</b></th>  <th><b>产品编号</b></th>  <th><b>产品描述</b></th> <th><b>有库存?</b></th>
          <th><b>产品数量</b></th>  <th><b>定价</b></th> <th><b>总成本</b></th>  <th>&nbsp;</th>
        </tr>

        <%

        	List<Item> items=(List<Item>)session.getAttribute("itemList") == null ? null : (List<Item>)session.getAttribute("itemList");
        
        	String username=(String)session.getAttribute("username") == null ? null : (String)session.getAttribute("username") ;
        
        	
        	if(username==null){//未登录:::临时购物车
       
		        if(items==null){
		        %>
		        	
		          	
		        	<tr><td colspan="8"><b>你的购物车是空的.</b></td></tr>
		        <%
		        	
		        }else if(items.isEmpty()){
		       
		        %>	
		
		       	     <tr><td colspan="8"><b style="color:red">你的购物车已清空!!请重新添加.</b></td></tr>
		 
		        <%		
		        } else{
		        %>	
		        	 <c:forEach var="item" items="${sessionScope.itemList }">
					   	
					          <tr>
					            <td><a href="<%=basePath %>/ProductToItem?itemid=${item.itemid }&&productid=${productid }&&type=${type}">${item.itemid }</a></td>
					            <td>${item.product.productid }</td>
					            <td>${item.attr1 }${item.product.name }</td>
					            <td>${item.qty }</td>
					            <td><input type="text" name="inStock" size="5" value="1"/> </td>
					            <td> 	$${item.listprice }	</td>
					            <td>$${item.sumprice }</td>
					            <td><a Class="Button" href="<%=basePath %>/del/delitem?itemid=${item.itemid }">
					              取消</a></td>
					          </tr>
					    </c:forEach>
		        <%	
		        }      
     	
        	}else{//已登录:::cart表购物车
        		
        		
        		List<Item> items2=(List<Item>)request.getAttribute("itemListByName") == null ? null : (List<Item>)request.getAttribute("itemListByName");
        	
        		if(items2==null){
        	%>		
        			<tr><td colspan="8"><b>你的购物车是空的.</b></td></tr>
        	<%		
        		}else if(items2.isEmpty()){
        	%>	
        	
        			
        			 <tr><td colspan="8"><b style="color:red">你的购物车已清空!!请重新添加.</b></td></tr>
        	
        	
        			
        	<%		
        		}else{
        			out.println("haha");
        	%>		
        			
        				<c:forEach var="item" items="${itemListByName }">
					   	
					          <tr>
					            <td><a href="<%=basePath %>/ProductToItem?itemid=${item.itemid }&&productid=${productid }&&type=${type}">${item.itemid }</a></td>
					            <td>${item.product.productid }</td>
					            <td>${item.attr1 }${item.product.name }</td>
					            <td>${item.qty }</td>
					            <td><input type="text" name="inStock" size="5" value="${item.quantity }"/> </td>
					            <td> 	$${item.listprice }	</td>
					            <td>$${item.sumprice }</td>
					            <td><a Class="Button" href="<%=basePath %>/del/delitem?itemid=${item.itemid }">
					              取消</a></td>
					          </tr>
					    </c:forEach>
        			
        	<%		
        		}
        		
        %>
        		
        		
        		
        	
        		
        		
        <%		
        	}
        
        %>
        
        
        
        

        		

			   
        		

    
   
    
    

    
        
        <tr>
          <td colspan="7">
            总金额: 
            <input type="submit" name="update" value="更新购物车" class="Button" />

          </td>
          <td>&nbsp;</td>
        </tr>
      </table>
      
        <a class="Button" href="javascript:void(0);">&lt;&lt; 上一页</a>
      
      
        <a class="Button" href="javascript:void(0);">下一页 &gt;&gt;</a>


    </form>



			<a class="Button" href="<%=basePath %>/tocheck" >付款</a>



  </div>
    <div id="MyList" style="margin-top:10px;">
    <%@ include file="IncludeMyList.jsp" %>
    </div>
  <div id="Separator">&nbsp;</div>

</div>


<%@ include file="../common/IncludeBottom.jsp" %>



