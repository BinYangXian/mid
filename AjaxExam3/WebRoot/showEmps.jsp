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
	<script>
		//页面加载的时候 通过ajax获取员工信息
		function getEmps(){
			var tab1=document.getElementById("tab1");
			var request;
			if(window.XMLHttpRequest){
				request=new XMLHttpRequest();
			}else if(window.ActiveXObject){
				request=new ActiveXObject("Msxml2.XMLHTTP");
			}
			
			request.open("get","employeeServlet");
			
			request.onreadystatechange=function(){
				var readyState=request.readyState;
				if(readyState==4){
					var status=request.status;
					if(status==200){
						//[{},{},{}]
						var data=request.responseText;
						eval("var empArray="+data);
						for(var i=0;i<empArray.length;i++){
							//在表格最后一行添加
							var newTr=tab1.insertRow(tab1.rows.length);
							newTr.insertCell(0).innerHTML=empArray[i].id;
							newTr.insertCell(1).innerHTML=empArray[i].name;
							newTr.insertCell(2).innerHTML=empArray[i].age;
							newTr.insertCell(3).innerHTML=empArray[i].gender;
						}
					}
				}
			};
			request.send(null);
		}
	
	</script>
  </head>
  
  <body onload="getEmps()">
  	<h4>欢迎管理者${manager }，使用本系统。</h4>
  	<hr/>
  	
    <table border="1" width="80%" align="center" id="tab1">
    	<tr>
    		<th colspan="5">
    			<h1>员工管理页面</h1>
    		</th>
    	</tr>
    	<tr>
    		<th>员工编号</th>
    		<th>员工姓名</th>
    		<th>员工年龄</th>
    		<th>员工性别</th>
    	</tr>
    </table>
  </body>
</html>
