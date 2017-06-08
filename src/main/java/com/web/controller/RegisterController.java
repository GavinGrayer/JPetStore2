package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.entity.Account;
import com.web.entity.Profile;
import com.web.entity.Signon;
import com.web.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	/**
	 * 账户ajax验证是否存在
	 * @param signon
	 * @return
	 */
	@RequestMapping("/judge")
	@ResponseBody
	public String judgeUserid(Signon signon){
		
		//String result="false";//存在不能使用
		
		System.out.println(signon.getUserid());
		
		
		String result=registerService.judgeUserid(signon.getUserid());
		
		System.out.println("判断结果:"+result);
		
		return result;
	}
	
	@RequestMapping("/saveInfor")
	public String saveInfor(Profile profile,@Validated Signon signon,BindingResult bindingResult,@Validated Account account,BindingResult bindingResult2){
		
		
		System.out.println("-----------");
		
		System.out.println(signon.getUserid()+"::"+account.getAddr2()+"::"+profile.getUserid());
		
		
		
		boolean result=registerService.saveInfor(signon, account, profile);
		
		if(result==true&&!bindingResult.hasErrors()&&!bindingResult2.hasErrors()){

			return "/account/SignonForm";
		}else{
			
			return "/account/NewAccountForm";
		}
		
		
	}
	
}
