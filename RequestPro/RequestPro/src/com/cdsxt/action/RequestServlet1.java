package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		testRequestLine(request, response);
//		testRequestHead(request,response);
		testRequestNetMsg(request,response);
	}
	
	//测试获取请求行信息
	public void testRequestLine(HttpServletRequest request, HttpServletResponse response){
		String method=request.getMethod();
		String uri=request.getRequestURI();
		String url=request.getRequestURL().toString();
		String queryString=request.getQueryString();
		String scheme=request.getScheme();
		String contextPath=request.getContextPath();
		System.out.println("method："+method);
		System.out.println("uri："+uri);
		System.out.println("url："+url);
		System.out.println("queryString："+queryString);
		System.out.println("scheme："+scheme);
		System.out.println("contextPath："+contextPath);
	}
	
	//获取请求头信息
	public void testRequestHead(HttpServletRequest request, HttpServletResponse response){
		//获取请求头信息  可以忽略大小写
//		String userAgent=request.getHeader("User-Agent");
//		System.out.println(userAgent);
		String connection=request.getHeader("CoNNecTion");
		System.out.println(connection);
	}
	
	//获取网络信息
	public void testRequestNetMsg(HttpServletRequest request, HttpServletResponse response){
		//客户端的ip
		String remoteAddr=request.getRemoteAddr();
		//客户端的端口号
		int remotePort=request.getRemotePort();
		//服务器的ip
		String localAddr=request.getLocalAddr();
		//服务器的端口号
		int localPort=request.getLocalPort();
		
		System.out.println("客户端的ip"+remoteAddr);
		System.out.println("客户端的端口号"+remotePort);
		System.out.println("服务器的ip"+localAddr);
		System.out.println("服务器的端口号"+localPort);
	}
}
