package com.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.service.CategoryToProductService;

@Controller
public class CategoryController {
	
	
	@Autowired
	private CategoryToProductService service;
	
	@RequestMapping("/toProduct")
	public String toProduct(@ModelAttribute(value="productid")String productid,@ModelAttribute(value="type")String type,String name,Model model){
		
		try {
			name=new String(name.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(productid+"::"+type+"::"+name);
		
		List itemlList=service.itemlList(productid);
		
		model.addAttribute("itemlist", itemlList);
		
		model.addAttribute("name", name);
		
		return "/catalog/Product";
	}
}
