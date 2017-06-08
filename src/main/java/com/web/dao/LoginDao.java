package com.web.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.web.entity.Profile;
import com.web.entity.Signon;

@Repository
public class LoginDao extends BaseDao{
	
	public boolean login(Signon signon){
		
		boolean result=false;
		
		Signon signon2=null;
		try {
			signon2 = (Signon) getSqlMapClient().queryForObject("findSignonById", signon.getUserid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(signon2.getPassword().equals(signon.getPassword())){
			
			result=true;
		}
		
		return result;
	}
	
	
	public Profile queryProfileByUserid(String userid){
		
		Profile profile=new Profile();
		try {
			profile = (Profile) getSqlMapClient().queryForObject("queryProfileByUserid", userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profile; 
	
				
	}
	
	
	public static void main(String[] args) {
		
		ApplicationContext a0=new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
		
		LoginDao loginDao=(LoginDao) a0.getBean("loginDao");
		
		Signon signon=new Signon();
		signon.setUserid("j2ee");
		signon.setPassword("j2ee");
		
		System.out.println(loginDao.login(signon));
		
	}
	
}
