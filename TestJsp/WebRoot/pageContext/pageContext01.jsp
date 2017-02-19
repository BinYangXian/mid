<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//pageContext  对象   是page作用域   作用范围   本页面
	pageContext.setAttribute("a", "aaa");
	pageContext.setAttribute("c", "ccc");
	
	String a=(String)pageContext.getAttribute("a");
	String b=(String)pageContext.getAttribute("c");
	
	System.out.println(a);
	System.out.println(b);
	//request.getRequestDispatcher("pageContext02.jsp").forward(request, response);
	response.sendRedirect("pageContext02.jsp");
%>
