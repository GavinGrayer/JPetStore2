package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.ViewOrderDao;
import com.web.entity.Orders;

@Service
public class ViewOrderService {
	
	@Autowired
	private ViewOrderDao dao;
	
	public List<Orders> Vieworderlist(String userid){
		
		
		return dao.Vieworderlist(userid);
	}
	
}
