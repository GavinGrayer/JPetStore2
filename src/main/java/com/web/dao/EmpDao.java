package com.web.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.web.entity.Emp;

@Repository 
public class EmpDao extends BaseDao{
	
	public List findAllEmp(){
		
		List list=null;
		try {
			list=getSqlMapClient().queryForList("findAllEmp");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public boolean delEmp(Integer empno){
		
		boolean result=true;
		
		try {
			int i=getSqlMapClient().delete("delEmpByEmpno",empno);
	
			if(i<=0){
				
				result=false;
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		ApplicationContext a0=new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
	
		
		EmpDao dao=(EmpDao) a0.getBean("empDao");
		
		List list=dao.findAllEmp();
		
		for(Object o:list){
			
			Emp emp=(Emp) o;
			
			System.out.println(emp.getEmpno()+"::"+emp.getEname());
			
		}
	}
	
}
