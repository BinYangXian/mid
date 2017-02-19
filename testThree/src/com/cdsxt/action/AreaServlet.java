package com.cdsxt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.vo.Area;
import com.cdsxt.vo.City;
import com.google.gson.Gson;

public class AreaServlet extends HttpServlet {
	//用于装地区的list
	private List<Area> areaList;
	@Override
	public void init() throws ServletException {
		//服务器启动时 初始化地区的信息
		areaList=new ArrayList<Area>();
		areaList.add(new Area(110101, "东城区", 110100));
		areaList.add(new Area(110102, "西城区", 110100));
		areaList.add(new Area(110105, "朝阳区", 110100));
		
		areaList.add(new Area(110228, "密云县", 110200));
		areaList.add(new Area(110229, "庆云县", 110200));
		
		areaList.add(new Area(510104,"锦江区",510100));
		areaList.add(new Area(510106,"金牛区",510100));
		areaList.add(new Area(510105,"青羊区",510100));
		areaList.add(new Area(510108,"成华区",510100));
		
		areaList.add(new Area(510722,"三台县",510700));
		areaList.add(new Area(510723,"盐亭县",510700));
		areaList.add(new Area(510781,"江油市",510700));
		System.out.println("地区信息加载完成!"+areaList.size());
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		int cityId=Integer.parseInt(request.getParameter("cityId"));
		//用于装符合条件的数据的list
		List<Area> resultList=new ArrayList<Area>();
		for(Area a:areaList){
			if(a.getCityId()==cityId){
				resultList.add(a);
			}
		}
		response.getWriter().write(new Gson().toJson(resultList));
	}

}
