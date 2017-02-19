<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>员工管理系统</h1>
<form action="changeEmpServlet?mark=change&staIndex=${param.staIndex}" method="post">
	 	<table>
	 	   <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
            </tr>
<c:forEach var="m" items="${employees }" varStatus="sta">
	 	 <tr>
	 	 <c:if test="${sta.index==param.staIndex }" var="result" scope="page">
	<td><input type="text" name="empId" value="${m.empId}"/></td>
	<td><input type="text" name="empName" value="${m.empName}"/></td>
	<td><input type="text" name="empAge" value="${m.empAge}"/></td>
	<td><input type="text" name="empSex" value="${m.empSex}"/></td>
		</c:if>
		<c:if test="${!result }">
                <td>${m.empId}</td>
                <td>${m.empName}</td>
                <td>${m.empAge}</td>
                <td>${m.empSex}</td>
		</c:if>
         </tr>
	 </c:forEach>
	 	</table>
	 	<input type="submit"  value="保存修改">
</form>
</body>
</html>