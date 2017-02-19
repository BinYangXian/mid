<%@page import="java.io.PrintWriter"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%
	//如果要使用exception对象，必须  page isErrorPage="true" ，默认是false不能使用。
	
%>
<%=exception%>
<hr/>
<%=exception.getMessage()%>
<hr/>
<%
	exception.printStackTrace(new PrintWriter(out));
%>