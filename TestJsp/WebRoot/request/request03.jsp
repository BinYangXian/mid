<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//request作为作用域使用
	//存值
	request.setAttribute("a", "aaa");
	request.setAttribute("b", "bbb");
	
	//取值
	String a=(String)request.getAttribute("a");
	String b=(String)request.getAttribute("b");
	System.out.println(a);
	System.out.println(b);
	
	//移除值
	//request.removeAttribute("a");
	//System.out.println(request.getAttribute("a"));
	
	//获取作用域所有键的集合
	Enumeration enums=request.getAttributeNames();
	while(enums.hasMoreElements()){
		String name=(String)enums.nextElement();
		System.out.println(name);
	}
	
	System.out.println("----------------------------------------------");
	//request.getRequestDispatcher("request04.jsp").forward(request, response);
	request.getRequestDispatcher("/request/request04.jsp").forward(request, response);
	
%>