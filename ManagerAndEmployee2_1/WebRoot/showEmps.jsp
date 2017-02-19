<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//验证是否登录
Object manager=session.getAttribute("manager");
if(manager==null){
	request.setAttribute("msg", "<h3>请登陆后再使用本系统</h3>");
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showEmps.jsp' starting page</title>
    
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
  	<h4>欢迎管理者${manager }，使用本系统。</h4>
  	<hr/>
  	
    <table border="1" width="80%" align="center">
    	<tr>
    		<th colspan="5">
    			<h1>员工管理页面</h1>
    			<a href="addEmp.jsp">[添加员工]</a>
    		</th>
    	</tr>
    	<tr>
    		<th>员工编号</th>
    		<th>员工姓名</th>
    		<th>员工年龄</th>
    		<th>员工性别</th>
    		<th>操作</th>
    	</tr>
		<c:forEach items="${empList }" var="e">
			<tr align="center">
				<td>${e.id }</td>
				<td>${e.name }</td>
				<td>${e.age }</td>
				<%--<td>${e.gender==1?"男":"女" }</td> --%>
				<td>
					<c:choose>
						<c:when test="${e.gender==1 }">男</c:when>
						<c:otherwise>女</c:otherwise>
					</c:choose>
				</td>
				<td><a href="employeeServlet?mark=queryForUpdate&id=${e.id }">修改</a>&nbsp;<a href="employeeServlet?mark=del&id=${e.id }">删除</a></td>
			</tr>
		</c:forEach>
    </table>
  </body>
</html>
