package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.RegisterDao;
import com.web.entity.Account;
import com.web.entity.Profile;
import com.web.entity.Signon;

@Service
public class RegisterService {

	@Autowired
	private RegisterDao registerDao;
	
	
	
	public String judgeUserid(String userid){
		
		return registerDao.judgeUserid(userid);
	}
	
	
	public boolean saveInfor(Signon signon,Account account,Profile profile){
		
		return registerDao.saveInfor(signon, account, profile);
	}
	
}
