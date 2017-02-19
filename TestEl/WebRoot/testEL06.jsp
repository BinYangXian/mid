<%@page import="com.cdsxt.vo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	User user=new User("9527","13558832140","abc");
	pageContext.setAttribute("user", user);
%>
${user.uId }
<hr/>
${user.PHone }
<hr/>
${user.Abc }

