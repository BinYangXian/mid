<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//测试request对象
	//获取请求行信息的六大方法
	//获取请求方式  get或post
	String method=request.getMethod();
	System.out.println(method);
	//获取uri  端口后?之前
	String uri=request.getRequestURI();
	System.out.println(uri);
	//获取url  ?之前所有内容
	String url=request.getRequestURL().toString();
	System.out.println(url);
	//获取协议   http
	String scheme=request.getScheme();
	System.out.println(scheme);
	//获取项目根目录
	String contextPath=request.getContextPath();
	System.out.println(contextPath);
	//获取?之后
	String queryString=request.getQueryString();
	System.out.println(queryString);
	
	//获取请求头
	System.out.println("-----------------------------------------");
	String userAgent=request.getHeader("User-AGENT");
	System.out.println(userAgent);
	
	//获取服务器信息  0-65535   0-1024   http默认80
	System.out.println("-----------------------------------------");
	int port1=request.getLocalPort();
	System.out.println(port1);
	String addr1=request.getLocalAddr();
	System.out.println(addr1);
	
	//获取客户端信息  0-65535   0-1024   http默认80
	System.out.println("-----------------------------------------");
	int port2=request.getRemotePort();
	System.out.println(port2);
	String addr2=request.getRemoteAddr();
	System.out.println(addr2);
	
	
%>