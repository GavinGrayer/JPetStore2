package com.web.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.entity.Item;
import com.web.entity.Product;

@Repository
public class ProductToItemDao extends BaseDao{
	
	/**
	 * 商品信息
	 * @param itemid
	 * @return
	 */
	public Item findItemById(String itemid){
		
		//List itemlList=new ArrayList();
		Item item=new Item();
		
		try {
			item=(Item) getSqlMapClient().queryForObject("findItemById",itemid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return item;
	}
	
	/**
	 * 产品信息
	 * @param productid
	 * @return
	 */
	public Product findProductById(String productid){
		
		//List proList=new ArrayList();
		Product p=new Product();
		
		try {
			p=(Product) getSqlMapClient().queryForObject("findProductById", productid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
	}
	
	/**
	 * 库存
	 */
	public Integer queryQTY(String itemid){
		
		Integer qty=null;
		
		try {
			qty=(Integer) getSqlMapClient().queryForObject("queryQTY", itemid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return qty; 
	}
}	
