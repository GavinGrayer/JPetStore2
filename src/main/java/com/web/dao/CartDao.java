package com.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.entity.Cart;

@Repository
public class CartDao extends BaseDao{
	
	public boolean saveCart(Cart cart){
		
		boolean result=false;
		
		Object id=null;
		try {
			id=getSqlMapClient().insert("savecart",cart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("±£´æcartµÄid:"+id);
		
		if(id!=null){
			
			result=true;
		}
		
		return result;
	}
	
	
	public List<Cart> findAllCart(){
		
		List<Cart> cartList=null;
		try {
			cartList=getSqlMapClient().queryForList("findAllCart");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cartList;
	}
	
	public String queryProductidByItemid(String itemid){
		
		
		String productid=null;
		try {
			productid = (String) getSqlMapClient().queryForObject("queryProductidByItemid",itemid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productid;
	}
	
	
	public boolean delCartByItemid(String itemid){
		
		boolean result=true;
		
		try {
			getSqlMapClient().delete("delCartByItemid",itemid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean updateQuantity(Cart cart){
		
		boolean result=true;
		
		try {
			getSqlMapClient().update("updateQuantity", cart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return result;
		
	}
	
}
