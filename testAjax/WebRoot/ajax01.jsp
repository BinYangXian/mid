<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script>
		function testAjax(){
			var div1=document.getElementById("div1");
			//创建一个ajax请求对象   
			//window.XMLHttpRequest  原来是火狐支持的，ie在高版本也支持了这个内置对象
			//alert(window.XMLHttpRequest);
			//window.XMLHttpRequest  IE支持，火狐不支持
			//alert(window.ActiveXObject);
			var request;
			if(window.XMLHttpRequest){
				request=new XMLHttpRequest();
			}else if(window.ActiveXObject){
				request=new ActiveXObject("Msxml2.XMLHTTP");
			}
			
			//访问服务器
			request.open("get","ajaxServlet?"+new Date().getTime());
			
			//监听响应的状态
			request.onreadystatechange=function(){
				//响应的状态
				var readyState=request.readyState;
				if(readyState==4){
					//数据接收成功后的代码
					//状态码
					var status=request.status;
					if(status==200){
						//成功的时候获取数据    接收服务器write出来的字符串
						var result=request.responseText;
						alert(result);
					}else if(status==404){
						alert("你懂的");
					}else if(status==500){
						alert("服务器不给力");
					}
				}else{
					//数据接收中的代码
					div1.innerHTML="<img src='loading.gif' />";
				}
			};
			
			
			//请求带的参数
			request.send(null);
		}
	
	</script>
  </head>
  
  <body>
  	<input type="text" />
    <input type="button" onclick="testAjax()" value="测试ajax" />
    <div id="div1"></div>
  </body>
</html>
