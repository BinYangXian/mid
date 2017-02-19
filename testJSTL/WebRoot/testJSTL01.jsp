<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--taglib表示导入标签库   prefix  代表 标签库名字的缩写   uri 标签库地址 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setAttribute("a", "aaa");
	request.setAttribute("q", "<h1>qqqqqqqqq</h1>");
%>
${a }
<hr/>
<!--  default  默认值   escapeXml 是否避开xml   默认是true  设为false的时候则解析    -->
<c:out value="${a }" ></c:out>
<hr/>
<c:out value="${p}" default="ppppp"></c:out>
<hr/>
${p==null?"ppppp":p}
<hr/>
${q }
<hr/>
<c:out value="${q }" escapeXml="false" ></c:out>
