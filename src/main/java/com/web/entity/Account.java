package com.web.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Account {
	
	@NotBlank(message="帐号不能为空!!")
	private String userid;
	@NotBlank
	private String firstname;
	@NotBlank(message="邮箱不能为空!!")
	@Email(message="邮箱格式不对")
	private String email;
	@NotBlank(message="电话不能为空!!")
	private String phone;
	@NotBlank(message="地址不能为空!!")
	private String addr1;
	@NotBlank(message="地址不能为空!!")
	private String addr2;
	@NotBlank(message="城市不能为空!!")
	private String city;
	@NotBlank(message="国家不能为空!!")
	private String state;
	@NotBlank(message="帐号不能为空!!")
	private String zip;
	@NotBlank(message="邮编不能为空!!")
	private String country;
	private String status;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
