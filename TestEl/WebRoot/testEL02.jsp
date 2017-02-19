<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//el表达式的默认取值顺序  按作用域 从小到大取值      pageContext-->request-->session-->application
	request.setAttribute("a", "requestaaaaaaaa");
	application.setAttribute("a", "applicationaaaaaaaa");
	session.setAttribute("a", "sessionaaaaaaa");
	pageContext.setAttribute("a", "pageContextaaaaaaaaa");
%>
${a}
<hr/>
指定作用域取值(作用域别名基础上加上Scope):
<hr/>
${requestScope.a }
<hr/>
${sessionScope.a }
<hr/>
${applicationScope.a }
<hr/>
${pageScope.a }
<hr/>
取表单参数：
<hr/>
用户名${param.uname}&nbsp;密码${param.pwd }
<hr/>
<!-- paramValues获取的结果是  数组   用下标可以取出值 -->
${paramValues.fav[0] }
${paramValues.fav[1] }


