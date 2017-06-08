package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.CategoryToProductDao;

@Service
public class CategoryToProductService {
	
	@Autowired
	private CategoryToProductDao dao;
	
	public List itemlList(String productid){
		
		return dao.findItemByProductId(productid);
	}
	
}
