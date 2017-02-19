<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	out.write(((String)request.getAttribute("a")));
	out.write(((String)request.getAttribute("b")));
%>
<hr/>
<%=request.getAttribute("a")%>
<%=request.getAttribute("b")%>