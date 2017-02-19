<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'baidu.jsp' starting page</title>
    
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
  		<img src="baibaihe.png" style="margin-left: 510px;width: 300px"/>
    	<input type="text" onblur="hideDiv()" id="searInp" style="width:400px;margin-left: 430px" onkeyup="getData(this.value,event)" />
	    <input type="button" value="百度一下" onclick="goSearch()" /><br/>
	    <div style="border:1px solid red;width:400px;margin-left: 430px;display:none" id="container">
	    </div>
  </body>
</html>
<script>
		var con=document.getElementById("container");
		var searInp=document.getElementById("searInp");
		var id;
		//获取搜索框中的内容  访问服务器  获取合适的内容  加载到大的div中并显示
		function getData(searVal,event){
			if(id){
				window.clearTimeout(id);
			}
			//当搜索框内有值的时候 才进行搜索
			if(searVal){
				//使用event排除无效的ajax访问
				var evt=event||window.event;
				//有效按键  a-z  65-90    大键盘 0-9 48-57  小键盘 0-9  96-105 backspace  8   考虑中文  空格 32
				var code=evt.keyCode;
				if((code>=65&&code<=90)||(code>=48&&code<=57)||(code>=96&&code<=105)||code==8||code==32){
					//清空div容器
					con.innerHTML="";
					id=window.setTimeout(function(){
						var request;
						if(window.XMLHttpRequest){
							request=new XMLHttpRequest();
						}else if(window.ActiveXObject){
							request=new ActiveXObject("Msxml2.XMLHTTP");
						}
						
						//将要搜索的参数带到服务器去做搜索
						request.open("post","baiduServlet?searVal="+searVal+"&"+new Date().getTime());
						
						request.onreadystatechange=function(){
							var readyState=request.readyState;
							if(readyState==4){
								var status=request.status;
								if(status==200){
									var data=request.responseText;//['aaaa']   []
									eval("var dataArray="+data);
									//判断数组长度是否大于0
									if(dataArray.length>0){
										for(var i=0;i<dataArray.length;i++){
											var newDiv=document.createElement("div");
											newDiv.innerHTML=dataArray[i];
											newDiv.onmouseover=function(){
												this.style.backgroundColor="red";
											};
											newDiv.onmouseout=function(){
												this.style.backgroundColor="white";
											};
											newDiv.onmousedown=function(){
												var val=this.innerHTML;
												searInp.value=val;
											};
											con.appendChild(newDiv);
										}
										con.style.display="block";
									}else{
										//没有数据时 不显示提示框
										con.style.display="none";
									}
								}
							}
						}
						request.send(null);
					}, 500);
				}
			}else{
				//如果搜索内容为空  则不显示div
				con.style.display="none";
			}
		}
	
		//当搜索框失去焦点的时候  让div隐藏
		function hideDiv(){
			con.style.display="none";
		}
		
		//去百度服务器搜索
		function goSearch(){
			//https://www.baidu.com/s?wd=你好啊
			var searVal=searInp.value;
			window.location="https://www.baidu.com/s?wd="+searVal;
		}
	</script>