package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Cart;
import com.web.entity.Item;
import com.web.entity.Product;
import com.web.service.CartService;
import com.web.service.ProductToItemService;

@Controller
public class CheckoutController {
	
	
	@Autowired
	private ProductToItemService service;
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping("/tocheck")
	public String toCheckOut(HttpServletRequest request,Model model){
		
		
		/**
		 * 1.判断是否有username
		 */
		HttpSession session=request.getSession();
		
		String username=(String) session.getAttribute("username");
		

		
		if(username==null){
			
			
			model.addAttribute("errorMsg", "请进行登录!!");
			
			return "/account/SignonForm";
		}else{
			
			
			/**
			 * 进行check
			 */
			System.out.println("-----------");
			
		/*重新查list  
		
		通过cart的itemid来查
		*/
			
			
			
			
			List<Cart> cartlist=cartService.findAllCart();
			
			List<Item> itemList=new ArrayList<Item>();
			
			Double sum=0.0;
			
			
			for(Cart c:cartlist){
				
				System.out.println(c.getItemid());
			
				Item item=new Item();
				
				item=queryItemById(c.getItemid());
				//总价格存入item记录
				item.setSumprice(item.getListprice()*c.getQuantity());
				
				System.out.println("sumprice"+item.getSumprice());
				
				
				item.setQuantity(c.getQuantity().toString());
				
				/**
				 * 现根据c.getItemid()查找productid
				 */
				String productidString=cartService.queryProductidByItemid(c.getItemid());
				
				//productid存入item记录绑定
				Product product=new Product();
				product.setProductid(productidString);
				
				
				String name=null;
				name=queryNameById(productidString);
				product.setName(name);
				
				item.setProduct(product);
				
				
				/**
				 * 2.库存查询
				 */
				Integer qty=service.queryQTY(c.getItemid()) - Integer.valueOf(c.getQuantity().toString());
				
				
				
				/**
				 * 判断库存
				 */
				if(qty!=null){
					//model.addAttribute("qty", "有");
					item.setQty("有");
				}else{
					//model.addAttribute("qty", "无");
					item.setQty("无");
				}

				
				/**
				 * 计算sum
				 */
				sum+=item.getSumprice();
				
				
				
				itemList.add(item);
				
				
				//************************
				//创建list带到前台遍历
				
			
			}
			
			model.addAttribute("itemList", itemList);
			model.addAttribute("sum", sum);
			
			return "/cart/Checkout";
		}

	}
	
	
	public Item queryItemById(String itemid){
		
		Item item=new Item();
		
		item=service.findItemById(itemid);
		
		return item;
	}
	
	public String queryNameById(String productid){
		
		String name=null;
		
		Product product=service.findProductById(productid);
		
		name=product.getName();
		
		return name;
	}
	
}
