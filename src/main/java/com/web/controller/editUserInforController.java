package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.dao.editUserInforDao;
import com.web.entity.Account;
import com.web.entity.Profile;
import com.web.entity.Signon;
import com.web.service.LoginService;
import com.web.service.editUserInforService;


@Controller
@RequestMapping("/edit")
public class editUserInforController {
	
	@Autowired
	private editUserInforService service;
	
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/tomain")
	public String toMain(Signon signon,Profile profile,Account account,HttpServletRequest request){
		
		System.out.println(signon.getUserid()+"::"+profile.getFavcategory()+"::"+account.getAddr1());
		
		
		service.updateUserInfor(signon, profile, account);
		
		/**
		 * ��ѯ����ϲ�ã������Ƽ�
		 */
		
		Profile profile1=loginService.queryProfileByUserid(signon.getUserid());
		
		System.out.println(profile1);
		
		Integer mylistopt=profile1.getMylistopt();//�Ƽ�
		
		Integer banneropt=profile1.getBanneropt();//���
		
		String favcategory=profile1.getFavcategory();
		
		
		//��Ҫ��userid����session��
		HttpSession session=request.getSession();

		
		session.setAttribute("mylistopt", mylistopt);
		
		session.setAttribute("banneropt", banneropt);
		
		session.setAttribute("favcategory", favcategory);
		
		
		return "/catalog/Main";
	}
	
	
}
