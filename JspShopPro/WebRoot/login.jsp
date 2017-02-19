<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String uname="";
String pwd="";
Cookie[] cookies=request.getCookies();
if(cookies!=null&&cookies.length>0){
	for(Cookie cookie:cookies){
		String name=cookie.getName();
		if("uname".equals(name)){
			uname=cookie.getValue();
		}else if("pwd".equals(name)){
			pwd=cookie.getValue();
		}
	}
}

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
    <h1>用户登陆</h1>
    <%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
    <form action="userServlet" method="get">
    	用户名:<input type="text" name="uname" value="<%=uname %>"  /><br/>
    	密码:<input type="password" name="pwd" value="<%=pwd %>"  /><br/>
    	<input type="checkbox" name="save" />是否记住密码<br/>
    	<input type="submit" value="登陆"  />
    </form>
  </body>
</html>
