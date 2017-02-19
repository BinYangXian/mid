<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regis.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		function goLogin(){
			window.location="login.jsp";
		}
	
	</script>
  </head>
  
  <body>
    <h1>用户注册</h1>
    <%--
    	<%
    	String msg=(String)request.getAttribute("msg");
    	out.write(msg==null?"":msg);
    	%>
     --%>
     <%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
    <form action="userServlet.jsp?mark=regis" method="post">
    	用户名:<input type="text" name="uname"  /><br/>
    	密码:<input type="password" name="pwd"  /><br/>
    	重复密码:<input type="password" name="repwd"  /><br/>
    	<input type="submit" value="注册"  />&nbsp;
    	<input type="button" value="去登陆" onclick="goLogin()" />
    	
    </form>
  </body>
</html>
