<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
    		<c:forEach items="${proList }" var="p">
    			<option value="${p.provinceId}">${p.provinceName }</option>
    		</c:forEach>
    	</select>
    	市:<select id="city" onchange="getArea(this.value)">
    		<option value="0">--请选择--</option>
    	</select>
    	县/区:<select id="area">
    		<option value="0">--请选择--</option>
    	</select>
  </body>
</html>
<script src="ajaxUtil.js"></script>
<script src="util.js"></script>
<script>
	var pro=$("#pro");
	var city=$("#city");
	var area=$("#area")
	function getCity(provinceId){
		city.length=1;
		area.length=1;
		ajax("post","cityServlet","provinceId="+provinceId,function(data){
			eval("var cityArray="+data);
			for(var i=0;i<cityArray.length;i++){
				var newOpt=document.createElement("option");
				newOpt.value=cityArray[i].cityId;
				newOpt.innerHTML=cityArray[i].cityName;
				city.appendChild(newOpt);
			}
		});
	}
	
	function getArea(cityId){
		area.length=1;
		ajax("post","areaServlet","cityId="+cityId,function(data){
			eval("var areaArray="+data);
			for(var i=0;i<areaArray.length;i++){
				var newOpt=document.createElement("option");
				newOpt.value=areaArray[i].areaId;
				newOpt.innerHTML=areaArray[i].areaName;
				area.appendChild(newOpt);
			}
		});
	}
</script>