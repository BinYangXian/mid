<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String serverName=config.getServletName();
	System.out.println(serverName);
	System.out.println("----------------------------------------");
	String a=config.getInitParameter("a");
	String b=config.getInitParameter("b");
	System.out.println(a);
	System.out.println(b);
	
	Enumeration enums=config.getInitParameterNames();
	while(enums.hasMoreElements()){
		String name=(String)enums.nextElement();
		System.out.println(name);
	}
%>
