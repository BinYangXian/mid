<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
	//page session="true"   session的开关   默认是true   设为false时，不能使用内置对象session
	//session作为作用域使用
	//存值
	session.setAttribute("a", "aaa");
	session.setAttribute("b", "bbb");
	
	//request.getRequestDispatcher("session02.jsp").forward(request, response);
	//response.sendRedirect("session02.jsp");
%>