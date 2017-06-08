package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Item;
import com.web.service.CartService;

@Controller
@RequestMapping("/del")
public class DelCartController {
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping("/delitem")
	public String delCartItemById(String itemid,HttpServletRequest request){
		
		/**
		 * 1.判断是否有username
		 */
		HttpSession session=request.getSession();
		
		String username=(String) session.getAttribute("username");
		
		System.out.println("存在session中的用户名:"+username);
		
		
		if(username==null){//未登录状态
			
			System.out.println("del::-->>"+itemid);

			
			List<Item> itemList=(List<Item>) session.getAttribute("itemList");
			
			Item item1=new Item();
			
			for(Item item:itemList){
				
				//Item item=(Item) o;
				
				System.out.println(item.getItemid());
				
				if(item.getItemid().equals(itemid)){
					
					item1=item;
					
				}
			}
			
			/**
			 * ConcurrentModificationException::
			 * 不可在遍历里面进行增加或删除，否则会报错
			 */
			
			itemList.remove(item1);
			
			session.setAttribute("itemList", itemList);
			
			
			return "redirect:/cart";
			
		}else{//登录状态
			
			cartService.delCartByItemid(itemid);
			
			
			
			
			return "redirect:/cart";
		}
		
		
	}
}
