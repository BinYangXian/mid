<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("a", "requestaaaaaaaa");
	application.setAttribute("a", "applicationaaaaaaaa");
	session.setAttribute("a", "sessionaaaaaaa");
	pageContext.setAttribute("a", "pageContextaaaaaaaaa");
%>
<!-- var 要删除的键   scope 删除的键的作用域   没有写scope属性  默认全部删除       -->
${a }
<hr/>
<c:remove var="a" />
${a }
