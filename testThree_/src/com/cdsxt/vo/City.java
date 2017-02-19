package com.cdsxt.vo;

public class City {
	//城市的id
	private int cityId;
	//城市的名字
	private String cityName;
	//所属省份的id
	private int provinceId;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public City(int cityId, String cityName, int provinceId) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.provinceId = provinceId;
	}
	public City() {
		super();
	}
	
}
