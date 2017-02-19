<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>员工管理系统</h1>
	 	<table>
	 	   <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
            </tr>
<c:forEach var="m" items="${employees }" varStatus="sta">
	 	 <tr>
                <td>${m.empId}</td>
                <td>${m.empName}</td>
                <td>${m.empAge}</td>
                <td>${m.empSex}</td>
                <td><a href="changeEmpServlet?mark=delete&staIndex=${sta.index }">删除该员工</a></td>
                <td><a href="changeEmpInfo.jsp?staIndex=${sta.index }">修改信息</a></td>
         </tr>
	 </c:forEach>
	 	</table>
</body>
</html>