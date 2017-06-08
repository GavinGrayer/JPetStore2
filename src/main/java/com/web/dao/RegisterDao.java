package com.web.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.web.entity.Account;
import com.web.entity.Profile;
import com.web.entity.Signon;

@Repository
public class RegisterDao extends BaseDao{
	
	
	public String judgeUserid(String userid){
		
		String result="false";//不可以使用
		
		Signon signon=null;
		try {
			signon=(Signon) getSqlMapClient().queryForObject("findSignonById", userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(signon==null){
			
			result="true";
		}

	
		
		return result;
	} 
	
	
	
	public boolean saveInfor(Signon signon,Account account,Profile profile){
		
		boolean result=true;
		
		System.out.println(account.getStatus());
		
		try {
			getSqlMapClient().startTransaction();
			
			getSqlMapClient().insert("saveSignon", signon);
			
			getSqlMapClient().insert("saveProfile", profile);
			
			getSqlMapClient().insert("saveAccount", account);
			
			
			
			getSqlMapClient().commitTransaction();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				getSqlMapClient().endTransaction();
				
				result=false;
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext a0=new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
		RegisterDao dao=(RegisterDao) a0.getBean("registerDao");
		
		System.out.println(dao.judgeUserid("j2ee"));
	}
	
}
