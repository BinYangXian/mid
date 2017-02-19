<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%!
	//用户登陆
	public void userLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ServletContext context=this.getServletContext();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		if(uname.isEmpty()||pwd.isEmpty()){
			request.setAttribute("msg", "<h3>登陆信息填写不完整</h3>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			String rightPwd=(String)context.getAttribute(uname);
			if(!pwd.equals(rightPwd)){
				request.setAttribute("msg", "<h3>用户名或密码错误</h3>");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				request.getSession().setAttribute("user", uname);
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}
			
		}
	}

	//用户注册
	public void userRegis(PageContext pageContext) throws Exception{
		HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
		HttpServletResponse response=(HttpServletResponse)pageContext.getResponse();
		//ServletContext application=this.getServletContext();
		ServletContext application=pageContext.getServletContext();
		//获取页面参数
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String repwd=request.getParameter("repwd");
		
		if(uname.isEmpty()||pwd.isEmpty()||repwd.isEmpty()){
			request.setAttribute("msg", "<h3>注册信息填写不完整</h3>");
			request.getRequestDispatcher("regis.jsp").forward(request, response);
		}else if(!pwd.equals(repwd)){
			request.setAttribute("msg", "<h3>两次密码输入不一致</h3>");
			request.getRequestDispatcher("regis.jsp").forward(request, response);
		}else{
			Object user=application.getAttribute(uname);
			if(user!=null){
				request.setAttribute("msg", "<h3>好账号被用了</h3>");
				request.getRequestDispatcher("regis.jsp").forward(request, response);
			}else{
				application.setAttribute(uname, pwd);
				request.setAttribute("msg", "<h3>注册成功请登陆</h3>");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
%>

<%
	request.setCharacterEncoding("utf-8");
	String mark=request.getParameter("mark");	
	if("login".equals(mark)){
		userLogin(request,response);	
	}else if("regis".equals(mark)){
		userRegis(pageContext);
	}
%>
