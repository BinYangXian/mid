package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaiduServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
		//默认一些数据  
		String[] data=new String[]{"aaaa","abc","aabb","aaaccc","bbb","bcd","bbcc","你","你好","我","我不好"};
		//获取ajax传入的搜索内容
		String searVal=request.getParameter("searVal");
		PrintWriter pw=response.getWriter();
		/*if(searVal.isEmpty()){
			pw.write("[]");
		}else{
			String result="[";
			for(String d:data){
				if(d.startsWith(searVal)){
					result=result+"'"+d+"',";
				}
			}
			result=result.substring(0,result.length()-1)+"]";
			
			pw.write(result.length()==1?"[]":result);
		}*/
		String result="[";
		for(String d:data){
			if(d.startsWith(searVal)){
				result=result+"'"+d+"',";
			}
		}
		result=result.substring(0,result.length()-1)+"]";
		
		pw.write(result.length()==1?"[]":result);
		pw.flush();
		pw.close();
		
	}

}
