<%@page import="com.cdsxt.vo.Person"%>
<%@page import="com.cdsxt.vo.Address"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Person person=new Person("张三",new Address("四川","成都","锦江区"));
	pageContext.setAttribute("person", person);
	Address address=new Address("四川","绵阳","三台");
	pageContext.setAttribute("address", address);
	request.setAttribute("city","county" );
%>
${address.province }
<hr/>
${address[city] }
<hr/>
${address["county"] }
<hr/>
${address[param.show]}
<hr/>
${person.address["county"]}


