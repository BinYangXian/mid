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
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
    <h1>欢迎管理员${manager}使用本系统</h1>
    <hr/>
    <table border="1" width="80%" align="center">
    	<tr>
    		<th colspan="6">
    			<h1>年龄段为:${ageArea}的员工显示</h1>
    		</th>
    	</tr>
    	<tr>
    		<th>员工编号</th>
    		<th>员工姓名</th>
    		<th>员工年龄</th>
    		<th>员工邮箱</th>
    		<th>员工性别</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${empList }" var="e">
    		<tr align="center">
    			<td>${e.id }</td>
    			<td>${e.name }</td>
    			<td>${e.age }</td>
    			<td>${e.email }</td>
    			<td>${e.gender==0?"女":"男" }</td>
    			<td><a href="employeeServlet?mark=del&id=${e.id }&flag=age&ageArea=${ageArea}">删除</a>&nbsp;<a href="employeeServlet?mark=queryForUpdate&id=${e.id }">修改</a></td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
