package com.web.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.web.entity.Account;
import com.web.entity.Profile;
import com.web.entity.Signon;

@Repository
public class editUserInforDao extends BaseDao{
	
	public boolean updateUserInfor(Signon signon,Profile profile,Account account){
		
		try {
			getSqlMapClient().update("updatesignon", signon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			getSqlMapClient().update("updateprofile", profile);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		try {
			getSqlMapClient().update("updateaccount", account);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
			
		
		
		return true;
	}
	
}
