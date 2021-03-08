package com.mvc.Bean;

public class CentralBean {

	private String name;
	private String email;
	private String phone;
	private String disease;
	private String userName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public CentralBean(String name, String email, String phone, String disease, String userName) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.disease = disease;
		this.userName = userName;
	}
	

}
