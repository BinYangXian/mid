<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="http://www.baidu.com" charEncoding="utf-8" var="baidu" scope="page"></c:import>
<h1>本项目的内容</h1>
${baidu}

<%-- 
	<%
	response.sendRedirect("index.jsp?uname=zhangsan");
	%>
--%>

<c:redirect url="index.jsp">
	<c:param name="uname" value="lisi"></c:param>
</c:redirect>