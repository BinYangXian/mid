package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.vo.Province;
import com.google.gson.Gson;

public class ProServlet2 extends HttpServlet {

	//用于装省份的list
	private List<Province> proList;
	@Override
	public void init() throws ServletException {
		//服务器启动时 初始化省份的信息
		proList=new ArrayList<Province>();
		proList.add(new Province(110000, "北京市"));
		proList.add(new Province(510000,"四川省"));	
		System.out.println("地区信息加载完成!"+proList.size());
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.getWriter().write(new Gson().toJson(proList));
	}

}
