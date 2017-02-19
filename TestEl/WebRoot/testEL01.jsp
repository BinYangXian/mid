<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.cdsxt.vo.Address"%>
<%@page import="com.cdsxt.vo.Person"%>
<% 
	Person person=new Person("张三",new Address("四川","成都","锦江区"));
	pageContext.setAttribute("person", person);
	pageContext.setAttribute("a", "aaa");
%>
<%=((Person)pageContext.getAttribute("person")).getName()%>
<hr/>
<%=((Person)pageContext.getAttribute("person")).getAddress().getProvince()%>
<hr/>
<%=((Person)pageContext.getAttribute("person")).getAddress().getCity()%>
<hr/>
<%=((Person)pageContext.getAttribute("person")).getAddress().getCounty()%>
<hr/>
${person.name}
<hr/>
${person.address.province}
<hr/>
${person.address.city}
<hr/>
${person.address.county}
<hr/>
${a}