<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
	Integer banneropt=(Integer)session.getAttribute("banneropt");

	String favcategory=(String)session.getAttribute("favcategory");
	
	out.println(banneropt);
%>

<html>

<body>

<div id="Footer">

  <div id="PoweredBy">
    <a href="http://ibatis.apache.org"><img src="./images/poweredby.gif"/></a>
  </div>

  
  <%
	if(banneropt!=null&&banneropt!=0){
			
			if(favcategory.equals("CATS")){
	%>		
				<div id="Banner">
	  				<img src="images/banner_cats.gif" />
	  			</div>	
	<% 		
			}
			if(favcategory.equals("DOGS")){
	%>		
				<div id="Banner">
	  				<img src="images/banner_dogs.gif" />
	  			</div>
	<%		
			}
			if(favcategory.equals("FISH")){
	%>		
				<div id="Banner">
	  				<img src="images/banner_fish.gif" />
	  			</div>
			
	<%		
			}
			if(favcategory.equals("BIRD")){
	%>		
				<div id="Banner">
	  				<img src="images/banner_birds.gif" />
	  			</div>		
	<%		
			}
			if(favcategory.equals("REPTILES")){
	%>		
				<div id="Banner">
	  				<img src="images/banner_reptiles.gif" />
	  			</div>
	<%		
			}
	%>	
		
	
<%	
	
	}else{
%>	
	<div id="Banner">
  
  </div>
	
<%	
	}
 %>
  
  
  

</div>

</body>
</html>