<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//打印文件夹下所有资源路径
	Set<String> paths=application.getResourcePaths("/request");
	for(String path:paths){
		System.out.println(path);
	}
	System.out.println("------------------------------------------------");
	//获取资源的Mime类型
	//String mimeType=application.getMimeType("/img/cat.jpg");
	String mimeType=application.getMimeType("/aa.txt");
	
	System.out.println(mimeType);
	
%>