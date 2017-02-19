<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <h1>管理员注册</h1>
     ${msg }
    <form action="managerServlet" method="get">
    	<input type="hidden" name="mark" value="regis" />
    	用户名:<input type="text" name="uname"   /><br/>
    	密码:<input type="password" name="pwd"  /><br/>
    	<input type="submit" value="注册"  />
    	<a href="login.jsp">登陆</a>
    </form>
  </body>
</html>
