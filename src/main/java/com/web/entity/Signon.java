package com.web.entity;

import org.hibernate.validator.constraints.NotBlank;

public class Signon {
	@NotBlank(message="帐号不能为空!!!")
	private String userid;
	
	@NotBlank(message="密码不能为空!!!")
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
