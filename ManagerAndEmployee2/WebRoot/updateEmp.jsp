<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateEmp.jsp' starting page</title>
    
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
  		
     	<h1>修改员工信息</h1>
	    <form action="employeeServlet?mark=update" method="post">
	    	编号:<input type="text" name="id" value="${emp.id }" readonly /><br/>
	    	姓名:<input type="text" name="name" value="${emp.name }" /><br/>
	    	年龄:<input type="text" name="age" value="${emp.age }" /><br/>
			性别:<input type="radio" name="gender" value="1" ${emp.gender==1?"checked":"" }/>男
	    		<input type="radio" name="gender" value="0" ${emp.gender==0?"checked":"" } />女<br/>
	    	<input type="submit" value="确认修改" />
	    </form>
  </body>
</html>
