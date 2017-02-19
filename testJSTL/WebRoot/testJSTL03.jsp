<%@page import="com.cdsxt.vo.Address"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("a", "aaa");
	pageContext.setAttribute("address", new Address("a","b","c"));
%>
<c:out value="${a }"></c:out>

<!-- scope  作用域  没有填写的时候默认是page作用域      var 代表键    value 代表值 -->
<c:set value="bbb"  var="b"   ></c:set>
<hr/>
${pageScope.b }
<hr/>
${address.county }
<hr/>
<!-- target 要修改的目标对象  property 代表属性   value  代表值 -->
<c:set target="${address }" property="county" value="金牛区"></c:set> 
${address.county }