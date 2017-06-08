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
		 * 1.�ж��Ƿ���username
		 */
		HttpSession session=request.getSession();
		
		String username=(String) session.getAttribute("username");
		

		
		if(username==null){
			
			
			model.addAttribute("errorMsg", "����е�¼!!");
			
			return "/account/SignonForm";
		}else{
			
			
			/**
			 * ����check
			 */
			System.out.println("-----------");
			
		/*���²�list  
		
		ͨ��cart��itemid����
		*/
			
			
			
			
			List<Cart> cartlist=cartService.findAllCart();
			
			List<Item> itemList=new ArrayList<Item>();
			
			Double sum=0.0;
			
			
			for(Cart c:cartlist){
				
				System.out.println(c.getItemid());
			
				Item item=new Item();
				
				item=queryItemById(c.getItemid());
				//�ܼ۸����item��¼
				item.setSumprice(item.getListprice()*c.getQuantity());
				
				System.out.println("sumprice"+item.getSumprice());
				
				
				item.setQuantity(c.getQuantity().toString());
				
				/**
				 * �ָ���c.getItemid()����productid
				 */
				String productidString=cartService.queryProductidByItemid(c.getItemid());
				
				//productid����item��¼��
				Product product=new Product();
				product.setProductid(productidString);
				
				
				String name=null;
				name=queryNameById(productidString);
				product.setName(name);
				
				item.setProduct(product);
				
				
				/**
				 * 2.����ѯ
				 */
				Integer qty=service.queryQTY(c.getItemid()) - Integer.valueOf(c.getQuantity().toString());
				
				
				
				/**
				 * �жϿ��
				 */
				if(qty!=null){
					//model.addAttribute("qty", "��");
					item.setQty("��");
				}else{
					//model.addAttribute("qty", "��");
					item.setQty("��");
				}

				
				/**
				 * ����sum
				 */
				sum+=item.getSumprice();
				
				
				
				itemList.add(item);
				
				
				//************************
				//����list����ǰ̨����
				
			
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
