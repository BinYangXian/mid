<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
	<script type="text/javascript">
		function test(value){
			var request;
			if(window.XMLHttpRequest){
				request=new XMLHttpRequest();
			}else if(window.ActiveXObject){
				request=new ActiveXObject("Msxml2.XMLHTTP");
			}
			
			//访问服务器
			//post方式传参 可以在url的后面
			request.open("post","ajaxServlet2?"+new Date().getTime(),true);
			
			//监听响应的状态
			request.onreadystatechange=function(){
				//响应的状态
				var readyState=request.readyState;
				if(readyState==4){
					//数据接收成功后的代码
					//状态码
					var status=request.status;
					if(status==200){
					var div=document.getElementById("msgId");
						//成功的时候获取数据    接收服务器write出来的字符串
						var result=request.responseText;
						div.innerHTML=result;
					}else if(status==404){
						alert("找不到服务器上的地址");
					}else if(status==500){
						alert("服务器内部程序错误");
					}
				}else{
					//数据接收中的代码
				}
			};
			
			
			
			//请求带的参数     send方法是 专门给post方式准备滴
			//如果要使用send传参数   必须在前面加一个请求头的编码格式   改成键值对      form表单的enctype默认值
			request.setRequestHeader("content-type", "application/x-www-form-urlencoded");	
			//alert("发送的参数为："+"uname="+value);	
			request.send("uname="+value);
			
			//alert("我是同步还是异步?");
		}
	</script>
</head>
  <body>
    <h1>员工管理系统</h1>
    ${msg }
     <form action="loginServlet?mark=login" method="post"  >
        <table>
            <tr>
                <th>用户名：</th>
                <th><input type="text" name="uname" onblur="test(this.value)"/></th>
                <td><div id="msgId"></div></td>
            </tr>
            <tr>
                <th>密码：</th>
                <th><input type="password" name="pwd" /></th>
            </tr>
            <tr>
                <th>&nbsp;&nbsp;&nbsp;</th>
                <td><input type="submit" value="添加管理员" >&nbsp;&nbsp;<input type="reset" /></td>
            </tr>
        </table>
    </form>
  </body>
</html>
