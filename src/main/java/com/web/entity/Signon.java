package com.web.entity;

import org.hibernate.validator.constraints.NotBlank;

public class Signon {
	@NotBlank(message="�ʺŲ���Ϊ��!!!")
	private String userid;
	
	@NotBlank(message="���벻��Ϊ��!!!")
	private String password;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
