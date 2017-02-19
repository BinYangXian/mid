package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdsxt.vo.User;

public class SuccessPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		ServletContext context=this.getServletContext();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		PrintWriter pw=response.getWriter();
		pw.write("<h1>欢迎:"+user.getUname()+",使用本系统!<img src='"+user.getPath()+"'  width='100px' /></h1>");
		pw.write("<form action='userServlet?mark=upload' method='post' enctype='multipart/form-data' >");
		pw.write("<input type='file' name='img' /><br/>");
		pw.write("<input type='submit' value='上传图片' />");
		pw.write("</form>");
		pw.write("<hr/>");
		//获取该目录下的资源集合
		Set<String> paths=context.getResourcePaths("/"+user.getUname());
		if(paths!=null&&paths.size()>0){
			for(String path:paths){
				pw.write("<a href='userServlet?mark=show&path="+path+"'>"+path.substring(path.lastIndexOf("/")+1)+"</a>&nbsp;&nbsp;&nbsp;");
				pw.write("<a href='userServlet?mark=down&path="+path+"'>下载</a><br/>");
			}
		}
		pw.flush();
		pw.close();
		
	}

}
