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
    			<h1>员工管理页面</h1>
    			<a href="addEmp.jsp">[添加员工]</a>
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
    			<td><a href="employeeServlet?mark=del&id=${e.id }">删除</a>&nbsp;<a href="employeeServlet?mark=queryForUpdate&id=${e.id }">修改</a></td>
    		</tr>
    	</c:forEach>
    	<tr align="center">
    		<td colspan="6">
    			<c:if test="${page.curPage!=page.firstPage }">
    				<a href="employeeServlet?mark=query&curPage=${page.firstPage }">首页</a>
    				<a href="employeeServlet?mark=query&curPage=${page.prevPage }">上一页</a>
    			</c:if>
    			<!--  begin 和end 单独使用 -->
    			<c:forEach  begin="${page.startNav }" end="${page.endNav }" var="i">
    				<c:choose>
    					<c:when test="${i==page.curPage }">
    						<font color="red">${i }</font>
    					</c:when>
    					<c:otherwise>
    						<a href="employeeServlet?mark=query&curPage=${i}">${i }</a>
    					</c:otherwise>
    				</c:choose>
    			</c:forEach>
    			
    			<c:if test="${page.curPage!=page.lastPage }">
	    			<a href="employeeServlet?mark=query&curPage=${page.nextPage }">下一页</a>
	    			<a href="employeeServlet?mark=query&curPage=${page.lastPage }">尾页</a>
    			</c:if>
    		</td>
    	</tr>
    </table>
  </body>
</html>