package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.service.TypeService;


@Controller
public class MainController {
	
	@Autowired
	private TypeService typeService;
	
	@RequestMapping("/toMain")
	public String toMain(){

		return "/catalog/Main";
	}
	
	@RequestMapping("/type")
	public String categoryByType(@ModelAttribute(value="type")String type,Model model){
		
		System.out.println(type);

		model.addAttribute("typelist", typeService.findProduuctByType(type));
		
		
		return "/catalog/Category";
	}
	
	/**
	 * includetop.jsp
	 * ǰ����¼  
	 * @return
	 */
	@RequestMapping("/toSignonForm")
	public String toLogin(){
		
		return "/account/SignonForm";
	}
	
	
	/**
	 * includetop.jsp
	 * ǰ���ҵ��ʻ�  
	 * @return
	 */
	@RequestMapping("/EditAccountForm")
	public String toEditAccountForm(){
		
		return "/account/EditAccountForm";
	}
	
	/**
	 * includetop.jsp
	 * ǰ��cart 
	 * @return
	 */
	@RequestMapping("/toCart")
	public String toCart(){
		
		return "/cart/Cart";
	}
	
}
