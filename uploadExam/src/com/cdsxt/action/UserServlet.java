package com.cdsxt.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.cdsxt.vo.User;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mark=request.getParameter("mark");
		if("regis".equals(mark)){
			userRegis(request,response);
		}else if("login".equals(mark)){
			userLogin(request,response);
		}else if("upload".equals(mark)){
			userUpload(request,response);
		}else if("show".equals(mark)||"down".equals(mark)){
			showOrDown(request,response);
		}
	}
	
	//用户注册
	public void userRegis(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// upload就是解析请求的对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		List<FileItem> items = null;
		
		try {
			items=upload.parseRequest(request);
			if(items!=null&&items.size()>0){
				//用来保存表单域的值
				String uname=null;
				String pwd=null;
				String path=null;
				for(FileItem item:items){
					//获取用户名和密码
					if(item.isFormField()){
						//获取表单域的name值
						String fieldName=item.getFieldName();
						if("uname".equals(fieldName)){
							uname=item.getString("utf-8");//获取表单域的值
						}else if("pwd".equals(fieldName)){
							pwd=item.getString("utf-8");
						}
					}else{
						//获取图片名
						String photoName=new Date().getTime()+item.getName();
						//给path设置值
						path="photo/"+photoName;
						//查找存放头像的文件夹
						File photoDir=new File(servletContext.getRealPath("/photo"));
						//如果该文件夹不存在，则创建
						if(!photoDir.exists()){
							photoDir.mkdir();
						}
						//在新建的文件夹下上传图片
						item.write(new File(photoDir,photoName));
					}
				}
				//完成注册的逻辑
				//查看该用户是否已经注册
				User user=(User) servletContext.getAttribute(uname);
				if(user!=null){
					//用户已注册   则返回注册页面
					request.setAttribute("msg", "<h3>该用户名已经被用了!</h3>");
					request.getRequestDispatcher("regisPage").forward(request, response);
				}else{
					//如果没有注册  则将值保存在servletContext作用域中
					servletContext.setAttribute(uname, new User(uname,pwd,path));
					//创建该用户的对应图片文件夹
					File dir=new File(servletContext.getRealPath(uname));
					if(!dir.exists()){
						dir.mkdirs();
					}
					//跳转到登陆页面
					request.setAttribute("msg", "<h3>注册成功，请登陆!</h3>");
					request.getRequestDispatcher("loginPage").forward(request, response);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//用户登陆的逻辑
	public void userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context=this.getServletContext();
		//获取登陆的用户名和密码
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		//通过用户名去获取用户信息
		User user=(User) context.getAttribute(uname);
		if(user!=null){
			String rightPwd=user.getPwd();
			if(rightPwd.equals(pwd)){
				//登陆成功的逻辑
				request.getSession().setAttribute("user",user);
				response.sendRedirect("successPage");
				return;
			}
		}
		//跳转到登陆页面
		request.setAttribute("msg", "<h3>用户名或密码错误</h3>");
		request.getRequestDispatcher("loginPage").forward(request, response);
		return;
	}
	
	//用户上传图片
	public void userUpload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// upload就是解析请求的对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		List<FileItem> items = null;
		try {
			items=upload.parseRequest(request);
			if(items!=null&&items.size()==1){
				//上传的图片
				FileItem item=items.get(0);
				//判断是否有上传的文件
				if(!item.getName().isEmpty()){
					//文件的名字
					String fileName=new Date().getTime()+item.getName();
					//从session作用域中取出用户信息
					User user=(User)request.getSession().getAttribute("user");
					item.write(new File(servletContext.getRealPath(user.getUname())+"/"+fileName));
				}
			}
			request.getRequestDispatcher("successPage").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//显示图片或下载图片
	public void showOrDown(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mark=request.getParameter("mark");
		String path=request.getParameter("path");
		String fileName=new String(path.substring(path.lastIndexOf("/")+1).getBytes("utf-8"),"iso8859-1");
		//如果是下载  添加响应头 
		if("down".equals(mark)){
			response.setHeader("content-disposition", "attachment;fileName="+fileName);
		}
		OutputStream out=response.getOutputStream();
		InputStream in=this.getServletContext().getResourceAsStream(path);
		int temp=0;
		byte[] b=new byte[8192];
		while((temp=in.read(b))!=-1){
			out.write(b, 0, temp);
		}
		out.flush();
		out.close();
		in.close();
	}
}
