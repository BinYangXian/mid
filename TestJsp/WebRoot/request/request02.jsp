<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//获取表单参数
	//获取单个值
	String uname=request.getParameter("uname");
	System.out.println(uname);
	
	//获取多个值
	String[] favs=request.getParameterValues("fav");
	System.out.println(favs.length);
	
	//获取表单域的键的集合
	Enumeration enums=request.getParameterNames();
	while(enums.hasMoreElements()){
		String name=(String)enums.nextElement();
		System.out.println(name);
	}
	
%>