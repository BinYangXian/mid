<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="40" var="a"></c:set>
<c:set value="30" var="b"></c:set>
<!-- c:when  替代if语句中的  if和else if    c:otherwise替代else    -->
<c:choose>
	<c:when test="${a>b }">
		a大于b
	</c:when>	
	<c:when test="${b>a }">
		b大于a
	</c:when>
	<c:otherwise>
		b等于a
	</c:otherwise>
</c:choose>
