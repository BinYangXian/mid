<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	//普通青年的写法
	<%
	int a=11;
	int b=10;
	if(a>b){
		out.write("a大于b");
	}else{
		out.write("b大于等于a");
	}
	%>

 --%>
<%--
<%
	//某B青年的写法
	int a=5;
	int b=10;
	if(a>b){
%>
	某B青年的写法：a大于b
<%
	}else{
%>
	某B青年的写法：b大于等于a
<%
	}
%>
 --%>
<c:set value="20" var="a"></c:set>
<c:set value="30" var="b"></c:set>
<!-- test代表要判断的boolean   var代表判断的结果  scope 结果保存的作用域 -->
<%--pageContext.setAttribute("result",true) --%>
<!-- c:if 模拟  if else效果 -->
<c:if test="${a>b }" var="result" scope="page">
	a大于b
</c:if>
<c:if test="${!result }">
	a小于等于b
</c:if>
<hr/>
${pageScope.result }




