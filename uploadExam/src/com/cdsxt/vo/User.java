package com.cdsxt.vo;

public class User {
	private String uname;
	private String pwd;
	private String path;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public User(String uname, String pwd, String path) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.path = path;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
