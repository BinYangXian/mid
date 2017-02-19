<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List list=new ArrayList();
	for(int i=0;i<20;i++){
		list.add("test"+i);
	}
	request.setAttribute("list", list);
	
	Map map=new HashMap();
	for(int i=0;i<20;i++){
		map.put("key"+i, "val"+i);
	}
	request.setAttribute("map", map);
%>

<!-- 
	items 表示要遍历的集合
	var 代表遍历的当前对象
	begin 代表开始的索引
	end  代表索引几结束
	step 代表步长  
	varStatus   
			index  代表当前对象索引
			count  代表当前对象是第几个
			
			
			first  代表当前对象是否是第一个元素
			last   代表当前对象是否是最后一个元素
 -->
<%--
	<c:forEach var="li" items="${list }" varStatus="stu"  >
		${stu.last }

	</c:forEach>
 
 
 
 <c:forEach var="li" items="${list }" varStatus="stu"  >
	${li }
	<c:if test="${stu.count%4==0 }">
		<br/>
	</c:if>
 </c:forEach>
 
 
 --%>
 <%--
  <!-- map的当前对象.key是获取键    .value获取值 -->
	 <c:forEach var="m" items="${map }">
	 	${m.key}--${m.value }
	 </c:forEach>
  --%>

 
 <select>
 	<option>--请选择--</option>
 	<c:forEach var="m" items="${map }">
 		<option value="${m.value }">${m.key }</option>
 	</c:forEach>
 </select>
