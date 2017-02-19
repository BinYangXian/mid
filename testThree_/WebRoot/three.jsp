<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  		<script src="jsUtil.js"></script>
		<script src="ajaxUtil.js"></script>
    <base href="<%=basePath%>">
    
    <title>My JSP 'three.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  <body>
    	省:<select id="pro" onchange="getCity(this.value)">
    		<option value="0">--请选择--</option>
    		<c:forEach items="${proList }" var="li" >
    		<option value="${li.provinceId }" >${li.provinceName }</option>
    		</c:forEach>
    	</select>
    	市:<select id="city" onchange="getArea(this.value)">
    		<option value="0">--请选择--</option>
    	</select>
    	县/区:<select id="area">
    		<option value="0">--请选择--</option>
    	</select>
  </body>
  <script>
  	function getCity(provinceId){
  		ajax("post","cityServlet","provinceId="+provinceId,function(data){
	                eval("var cities="+data)
	                var citySelObj=$("#city");
	                citySelObj.options.length=1;
	                for ( var city in cities) {
						var option=document.createElement("option");
						option.value=cities[city].cityId;
						option.innerHTML=cities[city].cityName;
						citySelObj.appendChild(option);
					}
	            }) ; 
  	}
  	function getArea(cityId){
  		ajax("post","areaServlet","cityId="+cityId,function(data){
	                eval("var areas="+data);
	                var areaSelObj=$("#area");
	                areaSelObj.options.length=1;
	                for ( var area in areas) {
						var option=document.createElement("option");
						option.value=areas[area].areaId;
						option.innerHTML=areas[area].areaName;
						areaSelObj.appendChild(option);
					}
	            }) ; 
  	}
  </script>
</html>