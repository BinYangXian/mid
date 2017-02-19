<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String str="abcddddddd";
	//response.getWriter().write(str);
	//out.write(str);
	String a=request.getParameter("a");
%>
<h1><%=str%></h1>
<hr/>
<!--  html标签的注释    对jsp引擎 可见   所以 不能注释java的内容 -->
<!-- <h1>hello</h1> -->
<!--  jsp的注释    对jsp引擎 不可见   所以 能注释java的内容 -->
<%-- <h1>hello</h1> --%>
<!-- 
	<%
		System.out.print(a);
	%> 
-->

<%-- 
	<%
	System.out.print(str);
	%>
--%>