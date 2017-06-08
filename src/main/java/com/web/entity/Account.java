package com.web.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Account {
	
	@NotBlank(message="�ʺŲ���Ϊ��!!")
	private String userid;
	@NotBlank
	private String firstname;
	@NotBlank(message="���䲻��Ϊ��!!")
	@Email(message="�����ʽ����")
	private String email;
	@NotBlank(message="�绰����Ϊ��!!")
	private String phone;
	@NotBlank(message="��ַ����Ϊ��!!")
	private String addr1;
	@NotBlank(message="��ַ����Ϊ��!!")
	private String addr2;
	@NotBlank(message="���в���Ϊ��!!")
	private String city;
	@NotBlank(message="���Ҳ���Ϊ��!!")
	private String state;
	@NotBlank(message="�ʺŲ���Ϊ��!!")
	private String zip;
	@NotBlank(message="�ʱ಻��Ϊ��!!")
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
