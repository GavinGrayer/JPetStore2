package com.web.entity;

public class Profile {
	
	private String userid;
	private String langpref;
	private String favcategory;//ϲ���Ķ�������
	private Integer mylistopt;//�Ƿ�����mylist  �Ƽ�
	private Integer banneropt;//�Ƿ�������
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLangpref() {
		return langpref;
	}
	public void setLangpref(String langpref) {
		this.langpref = langpref;
	}
	public String getFavcategory() {
		return favcategory;
	}
	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}
	public Integer getMylistopt() {
		return mylistopt;
	}
	public void setMylistopt(Integer mylistopt) {
		this.mylistopt = mylistopt;
	}
	public Integer getBanneropt() {
		return banneropt;
	}
	public void setBanneropt(Integer banneropt) {
		this.banneropt = banneropt;
	}
	
	
	
	
	
}
