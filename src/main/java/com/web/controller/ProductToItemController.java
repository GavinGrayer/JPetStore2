package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Item;
import com.web.entity.Product;
import com.web.service.ProductToItemService;

@Controller
public class ProductToItemController {
	
	
	@Autowired
	private ProductToItemService service;
	
	@RequestMapping("/ProductToItem")
	public String queryItem(String itemid,@ModelAttribute(value="productid") String productid,@ModelAttribute(value="type")String type,Model model){
		
		
		
		System.out.println(itemid+"::"+productid);
		
		Item item=service.findItemById(itemid);
		
		Product product=service.findProductById(productid);
		
		String infors[]=splitDescn(product.getDescn());
		
		System.out.println(infors[0]+"::"+infors[1]);
		
		Integer qty=service.queryQTY(itemid);
		
		
		model.addAttribute("item", item);
		model.addAttribute("product", product);
		model.addAttribute("infor", infors[0]);
		model.addAttribute("image", infors[1]);
		model.addAttribute("qty", qty);
		
		return "/catalog/Item";

	}
	
	
	public String[] splitDescn(String descn){
		
		String a[]=new String[2];
		
		String aa[]=descn.split(">");

		String image[]=aa[0].split("/");
		
		String images="/".concat(image[1].concat("/".concat(image[2])));
		
		
		a[0]=aa[1];
		a[1]=images;
		
		return a;
	}

}
