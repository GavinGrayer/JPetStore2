package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.CartDao;
import com.web.entity.Cart;

@Service
public class CartService {
	
	@Autowired
	private CartDao dao;
	
	
	public boolean saveCart(Cart cart){
		
		return dao.saveCart(cart);
	}
	
	public List<Cart> findAllCart(){
		
		return dao.findAllCart();
	}
	
	public String queryProductidByItemid(String itemid){
		
		return dao.queryProductidByItemid(itemid);
	}
	
	public boolean delCartByItemid(String itemid){
		
		return dao.delCartByItemid(itemid);
	}
	
	public boolean updateQuantity(Cart cart){
		
		return dao.updateQuantity(cart);
	}
}
