package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.OrderDao;
import com.web.entity.Orders;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderDao dao;
	
	
	public Long saveOrder(Orders orders){
		
		
		return dao.saveOrder(orders);
	}
	
	
}
