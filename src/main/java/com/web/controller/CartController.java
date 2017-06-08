package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Cart;
import com.web.entity.Item;
import com.web.entity.Product;
import com.web.service.CartService;
import com.web.service.ProductToItemService;

@Controller
public class CartController {
	
	@Autowired
	private ProductToItemService service;
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping("/cart")
	public String cart(String itemid,String productid,String type,HttpServletRequest request,Model model){
		
		System.out.println(itemid+"::"+productid+"::"+type);
		
		/**
		 * 1.判断是否有username
		 */
		HttpSession session=request.getSession();
		
		String username=(String) session.getAttribute("username");
		
		System.out.println("存在session中的用户名:"+username);
		
		/**
		 * 2.库存查询
		 */
		Integer qty=service.queryQTY(itemid);
		
		
		
		/**
		 * 3.判断username，进行不同的list存储
		 */
		if(username==null){//未登录
			
			
			/**
			 * 若不是直接点击购物车，
			 *带参数itemid和productid
			 */
			
			if(itemid!=null&&productid!=null){
				
				
				
			
			
				Item item=new Item();
				
				item=queryItemById(itemid);
				//总价格存入item记录
				item.setSumprice(item.getListprice());
				
				//productid存入item记录绑定
				Product product=new Product();
				product.setProductid(productid);
				
				String name=null;
				name=queryNameById(productid);
				product.setName(name);
				
				item.setProduct(product);
				
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
				
			
			
			
				/*	二次进入先取session中的list
				if(list==null){
					
					创建list，将item存入list
					
				}else{
					
					提取session中的list,对其add
					
				}*/
				List<Item> itemNewList=(List<Item>) session.getAttribute("itemList");
				
				if(itemNewList==null){
					
					List<Item> itemList=new ArrayList<Item>();
					itemList.add(item);
					
					session.setAttribute("itemList", itemList);
				}else{
					
					itemNewList=(List<Item>) session.getAttribute("itemList");
					itemNewList.add(item);
					
					session.setAttribute("itemList", itemNewList);
				}
				
				}else{
					
					/**
					 * 若不是直接点击购物车，
					 *未带参数itemid和productid
					 *
					 *
					 *直接调取session中的list
					 */
					
					List<Item> itemNewList=(List<Item>) session.getAttribute("itemList");
					
					session.setAttribute("itemList", itemNewList);
					
				}
	
				//model.addAttribute("itemList", itemList);
				
			
				model.addAttribute("type", type);
				
				
			
				
				/**
				 * 1.再查一遍产品和商品信息   product-->> item  和productToItemController 中的queryItem一样
				 * queryItemById方法已查好
				 */
				
				//将item存入list表中，存入session里
			
			
		}else{//已登录***********************************8
			
			/**
			 * 将信息存入cart表中
			 */
			System.out.println(itemid+"::"+productid);
			
			

			/**
			 * 若不是直接点击购物车，
			 *带参数itemid和productid
			 */
			
			if(itemid!=null&&productid!=null){
			
			
			
			Cart cart=new Cart();

			cart.setItemid(itemid);
			
			
			
			cart.setQuantity(Long.valueOf("1"));

			boolean result=cartService.saveCart(cart);
			
					if(result==true){//保存成功
						
						List<Cart> cartlist=cartService.findAllCart();
						
						List<Item> itemList=new ArrayList<Item>();
						
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
							 * 判断库存
							 */
							if(qty!=null){
								//model.addAttribute("qty", "有");
								item.setQty("有");
							}else{
								//model.addAttribute("qty", "无");
								item.setQty("无");
							}
		
							itemList.add(item);
		
						}
					
					model.addAttribute("itemListByName", itemList);
					request.setAttribute("itemListByName", itemList);
					
				}

			}else{//直接点击购物车
				
				List<Cart> cartlist=cartService.findAllCart();
				
				List<Item> itemList=new ArrayList<Item>();
				
				for(Cart c:cartlist){
					
					System.out.println(c.getItemid());
				
					Item item=new Item();
					
					item=queryItemById(c.getItemid());
					//总价格存入item记录
					item.setSumprice(item.getListprice()*c.getQuantity());
					
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
					 * 判断库存
					 */
					if(qty!=null){
						//model.addAttribute("qty", "有");
						item.setQty("有");
					}else{
						//model.addAttribute("qty", "无");
						item.setQty("无");
					}

					itemList.add(item);

				}
				
				model.addAttribute("itemListByName", itemList);
				request.setAttribute("itemListByName", itemList);
				
			}	
			
			
		}
		
		
		
		return "/cart/Cart";
	}
	

	
	/**
	 * 未登录的更新购物车
	 * @param itemid
	 * @return
	 */
	@RequestMapping("/updateSumPrice")
	public String updateSumPrice(String inStock[],String listprice,HttpServletRequest request,Model model){
		
		/**
		 * 1.判断是否有username
		 */
		HttpSession session=request.getSession();
		
		String username=(String) session.getAttribute("username");
		
		System.out.println("存在session中的用户名:"+username);
		
		if(username==null){
			
			
			
		
		
			
			List<Item> itemList=(List<Item>) session.getAttribute("itemList");
			
			int i=0;
			
			for(Item item:itemList){
				
				Double sum=null;
				
				sum=Double.valueOf(inStock[i])*item.getListprice();
				
				item.setSumprice(sum);
				
				i++;
				
			}

			session.setAttribute("itemList", itemList);

			return "redirect:/cart";
		
		
		}else{//已登录
			
			System.out.println("--------------");
			
			List<Cart> cartlList=cartService.findAllCart();
			
			int i=0;
			
			System.out.println(inStock[0]+":::::"+inStock[1]);
			
			List<Item> itemList=new ArrayList<Item>();
			
			for(Cart cart:cartlList){
				
				Item item=new Item();
				
				item=queryItemById(cart.getItemid());
				
				System.out.println(item.getListprice()+":::::"+Double.valueOf(inStock[i]));
				
				//总价格存入item记录
				Double sum=null;
				
				sum=Double.valueOf(inStock[i])*item.getListprice();
				
				System.out.println("sum::"+sum);
				
				item.setSumprice(sum);
				
				System.out.println(item.getSumprice()+"----");
				
				item.setQuantity(inStock[i]);
				
				
				/**
				 * 更新cart表的数量
				 */
				cart.setQuantity(Long.valueOf(inStock[i]));
				
				cartService.updateQuantity(cart);
				
				
				
				/**
				 * 2.库存查询
				 */
				Integer qty=service.queryQTY(cart.getItemid()) - Integer.valueOf(cart.getQuantity().toString());
				
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
				
				itemList.add(item);
				i++;
			}
			
			model.addAttribute("itemListByName", itemList);
			
			return "redirect:/cart";
			
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
