package com.web.entity;

public class Profile {
	
	private String userid;
	private String langpref;
	private String favcategory;//喜爱的动物种类
	private Integer mylistopt;//是否允许mylist  推荐
	private Integer banneropt;//是否允许广告
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
