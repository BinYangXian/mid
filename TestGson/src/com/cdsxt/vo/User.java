package com.cdsxt.vo;

public class User {
	private int id;
	private String name;
	private String[] fav;
	private Address address;
	
	public User(int id, String name, String[] fav, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.fav = fav;
		this.address = address;
	}
	public String[] getFav() {
		return fav;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setFav(String[] fav) {
		this.fav = fav;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String[] fav) {
		super();
		this.id = id;
		this.name = name;
		this.fav = fav;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
