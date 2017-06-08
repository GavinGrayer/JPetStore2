package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.editUserInforDao;
import com.web.entity.Account;
import com.web.entity.Profile;
import com.web.entity.Signon;

@Service
public class editUserInforService {

	
	@Autowired
	private editUserInforDao dao;
	
	public boolean updateUserInfor(Signon signon,Profile profile,Account account){
		
		return dao.updateUserInfor(signon, profile, account);
	}
}
