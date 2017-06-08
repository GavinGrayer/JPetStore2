package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.ProductToItemDao;
import com.web.entity.Item;
import com.web.entity.Product;

@Service
public class ProductToItemService {
	
	@Autowired
	private ProductToItemDao dao;
	
	public Item findItemById(String itemid){
		
		return dao.findItemById(itemid);
	}
	
	public Product findProductById(String productid){
		
		return dao.findProductById(productid);
	}
	
	public Integer queryQTY(String itemid){
		
		return dao.queryQTY(itemid);
	}
}
