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
		 * 查询个人喜好，广告和推荐
		 */
		
		Profile profile1=loginService.queryProfileByUserid(signon.getUserid());
		
		System.out.println(profile1);
		
		Integer mylistopt=profile1.getMylistopt();//推荐
		
		Integer banneropt=profile1.getBanneropt();//广告
		
		String favcategory=profile1.getFavcategory();
		
		
		//需要将userid放入session中
		HttpSession session=request.getSession();

		
		session.setAttribute("mylistopt", mylistopt);
		
		session.setAttribute("banneropt", banneropt);
		
		session.setAttribute("favcategory", favcategory);
		
		
		return "/catalog/Main";
	}
	
	
}
