package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.dao.EmployeeDao;
import com.cdsxt.po.Employee;
import com.cdsxt.util.PageUtil;
import com.cdsxt.vo.AgeArea;
import com.google.gson.Gson;

public class EmployeeServlet extends HttpServlet {
	private EmployeeDao employeeDao=new EmployeeDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mark=request.getParameter("mark");
		if(mark==null){
			queryEmps(request,response);
		}else if("add".equals(mark)){
			addEmp(request,response);
		}else if("del".equals(mark)){
			delEmp(request,response);
		}else if("queryForUpdate".equals(mark)){
			queryForUpdate(request,response);
		}else if("update".equals(mark)){
			updateEmp(request,response);
		}else if("queryAgeArea".equals(mark)){
			queryAgeArea(request,response);
		}else if("queryByAge".equals(mark)){
			queryByAge(request,response);
		}
	}
	
	//数据库查询所有员工并且返回到显示员工的页面
	public void queryEmps(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取当前页
		int curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage"));
		//查询总条数
		int count=employeeDao.queryEmps().size();
		//创建一个PageUtil对象   需要当前页  前面传入   数据总条数 从数据查
		PageUtil pageUtil=new PageUtil(curPage, count);
		List<Employee> empList=employeeDao.queryByPage(pageUtil.getStartRow(),pageUtil.getPageRow());
		request.setAttribute("page", pageUtil);
		request.setAttribute("empList", empList);
		request.getRequestDispatcher("showEmps.jsp").forward(request, response);
	}
	
	//添加员工
	public void addEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int age=Integer.parseInt(request.getParameter("age"));
		int gender=Integer.parseInt(request.getParameter("gender"));
		//将数据添加进数据库
		employeeDao.addEmp(name,email,age,gender);
		//调用查询方法  查询新的结果返回显示页面
		queryEmps(request,response);
	}
	
	//根据获取的id删除员工
	public void delEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag=request.getParameter("flag");
		int id=Integer.parseInt(request.getParameter("id"));
		//调用dao层  根据id删除
		employeeDao.delEmp(id);
		if(flag==null){
			//调用查询方法  查询新的结果返回显示页面
			queryEmps(request,response);
		}else if("age".equals(flag)){
			//走按年龄查询
			queryByAge(request,response);
		}
	}   
	//根据id查询数据库对应数据返回到修改页面
	
	public void queryForUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		//调用dao层  根据id查询该员工信息
		Employee employee=employeeDao.queryForUpdate(id);
		request.setAttribute("emp", employee);
		request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
	}
	
	//根据传入的值 修改对应员工
	public void updateEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int age=Integer.parseInt(request.getParameter("age"));
		int id=Integer.parseInt(request.getParameter("id"));
		int gender=Integer.parseInt(request.getParameter("gender"));
		employeeDao.updateEmp(id,name,age,gender,email);
		queryEmps(request, response);
	}
	
	//查询年龄段分布  返回数据给ajax
	public void queryAgeArea(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<AgeArea> ageList=employeeDao.queryAgeArea();
		response.getWriter().write(new Gson().toJson(ageList));
	}
	
	//根据传入的年龄段  查询对应年龄的员工
	public void queryByAge(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ageArea=request.getParameter("ageArea");
		String[] ages=ageArea.split("-");
		List<Employee> empList=null;
		if(ages.length==2){
			int minAge=Integer.parseInt(ages[0]);
			int maxAge=Integer.parseInt(ages[1]);
			empList=employeeDao.queryByAge(minAge,maxAge);
		}else if(ages.length==1){
			//xx以上
			int minAge=Integer.parseInt(ageArea.replaceAll("以上", ""));
			empList=employeeDao.queryByAge(minAge);
		}
		request.setAttribute("empList",empList);
		request.setAttribute("ageArea", ageArea);
		request.getRequestDispatcher("showEmpsByAge.jsp").forward(request, response);
	}
}
