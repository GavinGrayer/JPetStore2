package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Orders;
import com.web.service.ViewOrderService;

@Controller
public class ViewOrderController {

	@Autowired
	private ViewOrderService service;
	
	
	@RequestMapping("/viewOrder")
	public String toViewOrder(String userid,Model model){
		
		List<Orders> orderlist=new ArrayList<Orders>();
		
		
		System.out.println(userid);
		
		orderlist=service.Vieworderlist(userid);
		
		for(Orders o:orderlist){
			
			
			System.out.println(o.getTotalprice());
		}
		
		
		model.addAttribute("orderlist", orderlist);
		
		
		return "/order/ListOrders";
	}
	
	
}
