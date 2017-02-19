<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'AddEmp.jsp' starting page</title>
    
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
    <h1>添加员工</h1>
    ${msg }
    <form action="employeeServlet?mark=add" method="post">
    	编号:<input type="text" name="id" /><br/>
    	姓名:<input type="text" name="name" /><br/>
    	年龄:<input type="text" name="age" /><br/>
		性别:<input type="radio" name="gender" value="1"  checked />男
    		<input type="radio" name="gender" value="0" />女<br/>
    	<input type="submit" value="确认添加" />
    </form>
  </body>
</html>
