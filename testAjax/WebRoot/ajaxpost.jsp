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
			var request;
			if(window.XMLHttpRequest){
				request=new XMLHttpRequest();
			}else if(window.ActiveXObject){
				request=new ActiveXObject("Msxml2.XMLHTTP");
			}
			
			//访问服务器
			//post方式传参 可以在url的后面
			request.open("post","ajaxServlet2?"+new Date().getTime(),false);
			
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
				}
			};
			
			
			
			//请求带的参数     send方法是 专门给post方式准备滴
			//如果要使用send传参数   必须在前面加一个请求头的编码格式   改成键值对      form表单的enctype默认值
			request.setRequestHeader("content-type", "application/x-www-form-urlencoded");			
			request.send("uname=zzzz&pwd=111");
			
			alert("我是同步还是异步?");
		}
	
	</script>
  </head>
  
  <body>
  	<input type="text" />
    <input type="button" onclick="testAjax()" value="测试ajax" />
  </body>
</html>
