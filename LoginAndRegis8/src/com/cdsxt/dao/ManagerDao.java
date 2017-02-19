package com.cdsxt.dao;

import com.cdsxt.base.BaseDao;


public class ManagerDao {

	//验证用户名是否存在  存在则为true  不存在则为false
	public boolean valiUname(String uname){
		return BaseDao.queryCount("select * from manager where uname=?", 
				new Object[]{uname})==0?false:true;
	}
	
	//往数据库中添加管理员
	public void managerRegis(String uname,String pwd){
		BaseDao.change("insert into manager(uname,pwd) values(?,?)", new Object[]{uname,pwd});
	}
	//管理员的登陆
	public boolean managerLogin(String uname,String pwd){
		return BaseDao.queryCount("select count(*) from manager where uname=? and pwd=?", 
				new Object[]{uname,pwd})==0?false:true;
	}
}
