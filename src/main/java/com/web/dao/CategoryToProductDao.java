package com.web.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.entity.Item;
import com.web.entity.Product;

@Repository
public class CategoryToProductDao extends BaseDao{
	
	public List findItemByProductId(String productid){
		
		System.out.println("dao÷–:"+productid);
		
		List itemList=new ArrayList();
		
		List productList=new ArrayList();
		
		try {
			productList=getSqlMapClient().queryForList("queryAllProduct",productid);
			
			for(Object o:productList){
				
				Product p=(Product) o;
				
				itemList=p.getItems();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return itemList;
	}
	
	public static void main(String[] args) {
		CategoryToProductDao dao=new CategoryToProductDao();
		List list=dao.findItemByProductId("K9-BD-01");
		for(Object o:list){
			Item item=(Item) o;
			
			System.out.println(item.getAttr1());
		}
	}
}
