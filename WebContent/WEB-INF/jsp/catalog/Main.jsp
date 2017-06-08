<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="../common/IncludeTop.jsp" %>



<div id="Welcome" style="background:white">
  <div id="WelcomeContent" >
    
        欢迎 !
    
  </div>
  </div>
<div id="Main">


  <div id="Sidebar">
    <div id="SidebarContent">
  <a href="<%=basePath%>/type?type=FISH">
        <img src="<%=basePath%>/images/fish_icon.gif"/></a>
      <br/>
      海水，淡水
      <br/>
   <a href="<%=basePath%>/type?type=DOGS">
        <img src="<%=basePath%>/images/dogs_icon.gif"/></a>
      <br/>
      不同品种
      <br/>
        <a href="<%=basePath%>/type?type=CATS">
        <img src="<%=basePath%>/images/cats_icon.gif"/></a>
      <br/>
     不同品种，外来品种
      <br/>
      <a href="<%=basePath%>/type?type=REPTILES">
        <img src="<%=basePath%>/images/reptiles_icon.gif"/></a>
      <br/>
   蜥蜴，龟，蛇
      <br/>
          <a href="<%=basePath%>/type?type=BIRDS">
        <img src="<%=basePath%>/images/birds_icon.gif"/></a>
      <br/>外来品种
    </div>
  </div>

  <div id="MainImage">
    <div id="MainImageContent">
      <map name="estoremap"><area alt="Birds" coords="72,2,280,250" href="<%=basePath%>/type?type=BIRDS"
                                  shape="RECT"/>
        <area alt="Fish" coords="2,180,72,250" href="<%=basePath%>/type?type=FISH"/>
        <area alt="Dogs" coords="60,250,130,320" href="<%=basePath%>/type?type=DOGS" shape="RECT"/>
        <area alt="Reptiles" coords="140,270,210,340" href="<%=basePath%>/type?type=REPTILES"
              shape="RECT"/>
        <area alt="Cats" coords="225,240,295,310" href="<%=basePath%>/type?type=CATS" shape="RECT"/>
        <area alt="Birds" coords="280,180,350,250" href="<%=basePath%>/type?type=BIRDS" shape="RECT"/>
      </map>
      <img height="355" src="<%=basePath%>/images/splash.gif" align="center" usemap="#estoremap" width="350"/>
    </div>
  </div>

  <div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>

