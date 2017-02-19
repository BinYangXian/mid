package com.cdsxt.vo;

public class User {
	private String uId;
	private String PHone;
	private String Abc;
	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getPHone() {
		return PHone;
	}

	public void setPHone(String pHone) {
		PHone = pHone;
	}

	public String getAbc() {
		return Abc;
	}

	public void setAbc(String abc) {
		Abc = abc;
	}

	public User(String uId, String pHone, String abc) {
		super();
		this.uId = uId;
		PHone = pHone;
		Abc = abc;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
