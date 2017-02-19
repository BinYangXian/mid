package com.cdsxt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AjaxServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
		String searchWord=request.getParameter("searchWord");
		//{"a","aab","aac","aaa","abc","bbd","bbq","bbb","ccc","你好","你好行"，"你不好"}
		System.out.println("接收到的需要搜索的searchWord:"+searchWord);
		ServletContext context=this.getServletContext();
		String[] initInfos=(String[]) context.getAttribute("initInfo");
		List<String> foundInfo=new ArrayList<String>();
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		int i ;
		for ( i = 0; i < initInfos.length; i++) {
			String str=initInfos[i];
			if(str.startsWith(searchWord)){
				sb.append("\""+str+"\",");
			}
		}
		if(i!=0){
			sb=new StringBuilder(sb.substring(0, sb.toString().length()-1));
		}
		sb.append("]");
		System.out.println(sb);
		response.getWriter().write(sb.toString());
	}
}
