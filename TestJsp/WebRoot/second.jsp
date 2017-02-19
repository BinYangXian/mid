<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%!
	//有感叹号 代表声明    用来声明全局变量和方法
	int a=100;
	int b=100;
	public void test(){
		System.out.println(a);
	}
%>
<%
	test();
	int a=200;
	System.out.print(a+b);
%>
