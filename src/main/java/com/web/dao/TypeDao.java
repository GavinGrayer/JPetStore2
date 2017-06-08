package com.web.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.web.entity.Emp;
import com.web.entity.Product;

@Repository 
public class TypeDao extends BaseDao{
	
	public List findProduuctByType(String type){
		
		List list=null;
		try {
			list=getSqlMapClient().queryForList("finProductById",type);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		ApplicationContext a0=new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
	
		
		TypeDao dao=(TypeDao) a0.getBean("typeDao");
		
		List list=dao.findProduuctByType("FISH");
		
		for(Object o:list){
			
			Product product=(Product) o;
			
			System.out.println(product.getCategory()+"::"+product.getName());
			
		}
	}
	
}
