package com.cdsxt.vo;

public class Managers {
	private String managerName;
	private String managerPwd;
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPwd() {
		return managerPwd;
	}
	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}
	public Managers(String managerName, String managerPwd) {
		super();
		this.managerName = managerName;
		this.managerPwd = managerPwd;
	}
	
}
