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
    
    <title>My JSP 'showStus.jsp' starting page</title>
    
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
    <table border="1" width="700px" align="center" id="tab1">
    	<tr>
    		<th colspan="4">
    			<h1>学生信息</h1>
    		</th>
    	</tr>
    	<tr align="center">
    		<td colspan="4">
    			<a href="javascript:void(0)" onclick="getStudents(1)">一班</a>
    			<a href="javascript:void(0)" onclick="getStudents(2)">二班</a>
    			<a href="javascript:void(0)" onclick="getStudents(3)">三班</a>
    		</td>
    	</tr>
    	<tr>
    		<th>学号</th>
    		<th>姓名</th>
    		<th>年龄</th>
    		<th>班级</th>
    	</tr>
    	<c:forEach items="${stuList }" var="stu">
    		<c:if test="${stu.classId==1 }">
    			<tr>
					<td>${stu.id }</td>    			
					<td>${stu.name }</td>    			
					<td>${stu.age }</td>    			
					<td>${stu.classId }</td>    			
    			</tr>
    		</c:if>
    	</c:forEach>
    </table>
  </body>
</html>
<script src="ajaxUtil.js"></script>
<script>
	var tab1=document.getElementById("tab1");
	//获取学生信息
	function getStudents(classId){
		//保留前三行
		for(var i=3;i<tab1.rows.length;i++){
			tab1.deleteRow(i);
			i--;
		}
		ajax("post","studentServlet","classId="+classId,function(data){
			eval("var stusArray="+data);
			for(var i=0;i<stusArray.length;i++){
				var newTr=tab1.insertRow(tab1.rows.length);
				newTr.insertCell(0).innerHTML=stusArray[i].id;
				newTr.insertCell(1).innerHTML=stusArray[i].name;
				newTr.insertCell(2).innerHTML=stusArray[i].age;
				newTr.insertCell(3).innerHTML=stusArray[i].classId;
			}
		});
		/*var request;
		if(window.XMLHttpRequest){
			request=new XMLHttpRequest();
		}else if(window.ActiveXObject){
			request=new ActiveXObject("Msxml2.XMLHTTP");
		}
		
		request.open("post","studentServlet?classId="+classId+"&"+new Date().getTime());
		
		request.onreadystatechange=function(){
			var readyState=request.readyState;
			if(readyState==4){
				var status=request.status;
				if(status==200){
					var data=request.responseText;
					eval("var stusArray="+data);
					for(var i=0;i<stusArray.length;i++){
						var newTr=tab1.insertRow(tab1.rows.length);
						newTr.insertCell(0).innerHTML=stusArray[i].id;
						newTr.insertCell(1).innerHTML=stusArray[i].name;
						newTr.insertCell(2).innerHTML=stusArray[i].age;
						newTr.insertCell(3).innerHTML=stusArray[i].classId;
					}
				}
			}
		};
		request.send(null);*/
	}
</script>