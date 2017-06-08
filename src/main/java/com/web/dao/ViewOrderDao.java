package com.web.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.web.entity.Emp;
import com.web.entity.Orders;

@Repository
public class ViewOrderDao extends BaseDao{
	
	public List<Orders> Vieworderlist(String userid){
		
		List<Orders> orderlist=new ArrayList<Orders>();
		
		System.out.println(userid);
		
		try {
			orderlist=getSqlMapClient().queryForList("queryOrderByuserId", userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Orders o:orderlist){
			
			System.out.println(o.getOrderdate()+"::"+o.getTotalprice());
		}
		
		
		return orderlist;
	}
	
	public static void main(String[] args) {
		ApplicationContext a0=new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
	
		
		ViewOrderDao dao=(ViewOrderDao) a0.getBean("viewOrderDao");
		
		List list=dao.Vieworderlist("j2ee");
		
		for(Object o:list){
			
			Orders orders=(Orders) o;
			
			System.out.println(orders.getOrderid()+"::"+orders.getTotalprice());
			
		}
	}
	
	
	
}
