<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="abcdefg" var="str" ></c:set>

${fn:substring(str, 1, 4)}
<hr/>
${fn:toUpperCase(str) }
<hr/>
${fn:substring(str,2,fn:length(str)) }


