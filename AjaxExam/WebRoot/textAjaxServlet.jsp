<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function test(){
		/* var request;
		if(window.XMLHttpRequest){
			request=window.XMLHttpRequest;
		}else if(window.ActiveXObject){
			request=window.ActiveXObject("Msxml2.XMLHTTP");
		}
		request.open("get","ajaxServletTest");
		//请求带的参数
			request.send(null); */ //自己写的有隐藏错误
			var request;
			if(window.XMLHttpRequest){
				request=new XMLHttpRequest();
			}else if(window.ActiveXObject){
				request=new ActiveXObject("Msxml2.XMLHTTP");
			}
			
			//访问服务器
			request.open("get","ajaxServletTest");
			
			//请求带的参数
			request.send(null);
	}
</script>
</head>
<body>
	<input type="text" ><button onclick="test()">测试</button>
</body>
</html>
