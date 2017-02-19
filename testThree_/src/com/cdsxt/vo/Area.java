package com.cdsxt.vo;

public class Area {
	//地区id
	private int areaId;
	//地区名字
	private String areaName;
	//所属城市id
	private int cityId;
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public Area(int areaId, String areaName, int cityId) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.cityId = cityId;
	}
	public Area() {
		super();
	}
	
}
