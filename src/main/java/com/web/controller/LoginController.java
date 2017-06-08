package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Profile;
import com.web.entity.Signon;
import com.web.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	
	
	/**
	 * 前往注册
	 * @return
	 */
	@RequestMapping("/toNewAccountForm")
	public String toRegister(){
		
		return "/account/NewAccountForm";
	}
	
	@RequestMapping("/login")
	public String login(Signon signon,Model model,HttpServletRequest request){
		
		System.out.println(signon.getUserid()+"::"+signon.getPassword());
		
		boolean result=loginService.login(signon);
		
		if(result==false){
			
			model.addAttribute("errorMsg", "帐号或密码错误，请重试");
			
			return "/account/SignonForm";
		}else{//登录成功
			
			
			/**
			 * 查询个人喜好，广告和推荐
			 */
			
			Profile profile=loginService.queryProfileByUserid(signon.getUserid());
			
			System.out.println(profile);
			
			Integer mylistopt=profile.getMylistopt();//推荐
			
			Integer banneropt=profile.getBanneropt();//广告
			
			String favcategory=profile.getFavcategory();
			
			//需要将userid放入session中
			HttpSession session=request.getSession();
			
			session.setAttribute("username", signon.getUserid());
			
			session.setAttribute("mylistopt", mylistopt);
			
			session.setAttribute("banneropt", banneropt);
			
			session.setAttribute("favcategory", favcategory);
			
			return "/catalog/Main";
		}
		
		
	}
	
}
