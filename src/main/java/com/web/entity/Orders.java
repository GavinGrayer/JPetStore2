package com.web.entity;

import java.util.Date;

public class Orders {
	
	private Long orderid;
	private String userid;
	private Date orderdate;
	private String shipaddr1;
	private String shipcity;
	private String shipstate;
	private String shipzip;
	private String shipcountry;
	private String billaddr1;
	private String billcity;
	private String billstate;
	private String billzip;
	private String billcountry;
	private String courier;
	private Double totalprice;
	private String billtofirstname;
	private String shiptofirstname;
	private String creditcard;
	private String exprdate;
	private String cardtype;
	
	private Account account;
	
	
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getShipaddr1() {
		return shipaddr1;
	}
	public void setShipaddr1(String shipaddr1) {
		this.shipaddr1 = shipaddr1;
	}
	public String getShipcity() {
		return shipcity;
	}
	public void setShipcity(String shipcity) {
		this.shipcity = shipcity;
	}
	public String getShipstate() {
		return shipstate;
	}
	public void setShipstate(String shipstate) {
		this.shipstate = shipstate;
	}
	public String getShipzip() {
		return shipzip;
	}
	public void setShipzip(String shipzip) {
		this.shipzip = shipzip;
	}
	public String getShipcountry() {
		return shipcountry;
	}
	public void setShipcountry(String shipcountry) {
		this.shipcountry = shipcountry;
	}
	public String getBilladdr1() {
		return billaddr1;
	}
	public void setBilladdr1(String billaddr1) {
		this.billaddr1 = billaddr1;
	}
	public String getBillcity() {
		return billcity;
	}
	public void setBillcity(String billcity) {
		this.billcity = billcity;
	}
	public String getBillstate() {
		return billstate;
	}
	public void setBillstate(String billstate) {
		this.billstate = billstate;
	}
	public String getBillzip() {
		return billzip;
	}
	public void setBillzip(String billzip) {
		this.billzip = billzip;
	}
	public String getBillcountry() {
		return billcountry;
	}
	public void setBillcountry(String billcountry) {
		this.billcountry = billcountry;
	}
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public String getBilltofirstname() {
		return billtofirstname;
	}
	public void setBilltofirstname(String billtofirstname) {
		this.billtofirstname = billtofirstname;
	}
	public String getShiptofirstname() {
		return shiptofirstname;
	}
	public void setShiptofirstname(String shiptofirstname) {
		this.shiptofirstname = shiptofirstname;
	}
	public String getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	public String getExprdate() {
		return exprdate;
	}
	public void setExprdate(String exprdate) {
		this.exprdate = exprdate;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	
	
	
	
}
