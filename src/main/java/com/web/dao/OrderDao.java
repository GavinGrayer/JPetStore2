package com.web.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.web.entity.Orders;

@Repository
public class OrderDao extends BaseDao{
	
	public Long saveOrder(Orders orders){

		System.out.println(orders.getOrderdate()+"----");
		
		
		Long orderid=null;
		
		try {
			orderid=(Long) getSqlMapClient().insert("saveOrders", orders);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("orderid::"+orderid);
		
		
		return orderid;
	}
	
}
