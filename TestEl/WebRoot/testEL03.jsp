<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//el表达式取list的元素  通过 下标取
	List<String> list=new ArrayList<String>();
	list.add("a");
	list.add("b");
	list.add("c");
	request.setAttribute("list", list);
	
	//el表达式取map的元素  通过map的键  取
	Map map=new HashMap();
	map.put("a", "aaa");
	map.put("b", "bbb");
	map.put("c", "ccc");
	pageContext.setAttribute("map", map);
%>
${list[0]}
<hr/>
${map.b}