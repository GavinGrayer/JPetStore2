package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.LoginDao;
import com.web.entity.Profile;
import com.web.entity.Signon;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	
	public boolean login(Signon signon){
		
		return loginDao.login(signon);
	}
	
	public Profile queryProfileByUserid(String userid){
		
		
		return loginDao.queryProfileByUserid(userid);
	}
	
}
