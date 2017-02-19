<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--动态引入的 传参        重要! --%>
<%--<jsp:include page="include03.jsp">
	<jsp:param value="zhangsan" name="uname"/>    
	<jsp:param value="123456" name="pwd"/>    
</jsp:include> --%>
<jsp:include page="include03.jsp?uname=lisi&pwd=123"></jsp:include>
<hr/>
<h1>02的内容</h1>