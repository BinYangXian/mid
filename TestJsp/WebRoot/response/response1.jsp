<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//request作为作用域使用
	//存值
	request.setAttribute("a", "aaa");
	request.setAttribute("b", "bbb");
	
	//重定向       302    location
	//response.sendRedirect("response2.jsp");
	//response.sendRedirect(request.getContextPath()+"/response/response2.jsp");

	//模拟重定向
	response.setStatus(302);
	response.setHeader("location", "response2.jsp");
%>