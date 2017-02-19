package com.cdsxt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.vo.City;
import com.cdsxt.vo.Province;
import com.google.gson.Gson;

public class CityServlet extends HttpServlet {
	//用于装城市的list
	private List<City> cityList;
	@Override
	public void init() throws ServletException {
		//服务器启动时 初始化省份的信息
		cityList=new ArrayList<City>();
		cityList.add(new City(110100, "市辖区", 110000));
		cityList.add(new City(110200, "县", 110000));
		cityList.add(new City(510100, "成都市", 510000));
		cityList.add(new City(510700, "绵阳市", 510000));
		System.out.println("地区信息加载完成!"+cityList.size());
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		int provinceId=Integer.parseInt(request.getParameter("provinceId"));
		//用于装符合条件的数据的list
		List<City> resultList=new ArrayList<City>();
		for(City c:cityList){
			if(c.getProvinceId()==provinceId){
				resultList.add(c);
			}
		}
		response.getWriter().write(new Gson().toJson(resultList));
	}

}
