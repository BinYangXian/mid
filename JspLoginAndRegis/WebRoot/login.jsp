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
	<script>
		function goRegis(){
			window.location="regis.jsp";
		}
	
	</script>
  </head>
  
  <body>
    <h1>用户登陆</h1>
    <%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
    <form action="userServlet.jsp" method="get">
    	<input type="hidden" name="mark" value="login" />
    	用户名:<input type="text" name="uname"  /><br/>
    	密码:<input type="password" name="pwd"  /><br/>
    	<input type="submit" value="登陆"  />&nbsp;
    	<input type="button" value="去注册" onclick="goRegis()" />
    	
    </form>
  </body>
</html>
