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
		 * 1.�ж��Ƿ���username
		 */
		HttpSession session=request.getSession();
		
		String username=(String) session.getAttribute("username");
		
		System.out.println("����session�е��û���:"+username);
		
		/**
		 * 2.����ѯ
		 */
		Integer qty=service.queryQTY(itemid);
		
		
		
		/**
		 * 3.�ж�username�����в�ͬ��list�洢
		 */
		if(username==null){//δ��¼
			
			
			/**
			 * ������ֱ�ӵ�����ﳵ��
			 *������itemid��productid
			 */
			
			if(itemid!=null&&productid!=null){
				
				
				
			
			
				Item item=new Item();
				
				item=queryItemById(itemid);
				//�ܼ۸����item��¼
				item.setSumprice(item.getListprice());
				
				//productid����item��¼��
				Product product=new Product();
				product.setProductid(productid);
				
				String name=null;
				name=queryNameById(productid);
				product.setName(name);
				
				item.setProduct(product);
				
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
				
			
			
			
				/*	���ν�����ȡsession�е�list
				if(list==null){
					
					����list����item����list
					
				}else{
					
					��ȡsession�е�list,����add
					
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
					 * ������ֱ�ӵ�����ﳵ��
					 *δ������itemid��productid
					 *
					 *
					 *ֱ�ӵ�ȡsession�е�list
					 */
					
					List<Item> itemNewList=(List<Item>) session.getAttribute("itemList");
					
					session.setAttribute("itemList", itemNewList);
					
				}
	
				//model.addAttribute("itemList", itemList);
				
			
				model.addAttribute("type", type);
				
				
			
				
				/**
				 * 1.�ٲ�һ���Ʒ����Ʒ��Ϣ   product-->> item  ��productToItemController �е�queryItemһ��
				 * queryItemById�����Ѳ��
				 */
				
				//��item����list���У�����session��
			
			
		}else{//�ѵ�¼***********************************8
			
			/**
			 * ����Ϣ����cart����
			 */
			System.out.println(itemid+"::"+productid);
			
			

			/**
			 * ������ֱ�ӵ�����ﳵ��
			 *������itemid��productid
			 */
			
			if(itemid!=null&&productid!=null){
			
			
			
			Cart cart=new Cart();

			cart.setItemid(itemid);
			
			
			
			cart.setQuantity(Long.valueOf("1"));

			boolean result=cartService.saveCart(cart);
			
					if(result==true){//����ɹ�
						
						List<Cart> cartlist=cartService.findAllCart();
						
						List<Item> itemList=new ArrayList<Item>();
						
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
							 * �жϿ��
							 */
							if(qty!=null){
								//model.addAttribute("qty", "��");
								item.setQty("��");
							}else{
								//model.addAttribute("qty", "��");
								item.setQty("��");
							}
		
							itemList.add(item);
		
						}
					
					model.addAttribute("itemListByName", itemList);
					request.setAttribute("itemListByName", itemList);
					
				}

			}else{//ֱ�ӵ�����ﳵ
				
				List<Cart> cartlist=cartService.findAllCart();
				
				List<Item> itemList=new ArrayList<Item>();
				
				for(Cart c:cartlist){
					
					System.out.println(c.getItemid());
				
					Item item=new Item();
					
					item=queryItemById(c.getItemid());
					//�ܼ۸����item��¼
					item.setSumprice(item.getListprice()*c.getQuantity());
					
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
					 * �жϿ��
					 */
					if(qty!=null){
						//model.addAttribute("qty", "��");
						item.setQty("��");
					}else{
						//model.addAttribute("qty", "��");
						item.setQty("��");
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
	 * δ��¼�ĸ��¹��ﳵ
	 * @param itemid
	 * @return
	 */
	@RequestMapping("/updateSumPrice")
	public String updateSumPrice(String inStock[],String listprice,HttpServletRequest request,Model model){
		
		/**
		 * 1.�ж��Ƿ���username
		 */
		HttpSession session=request.getSession();
		
		String username=(String) session.getAttribute("username");
		
		System.out.println("����session�е��û���:"+username);
		
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
		
		
		}else{//�ѵ�¼
			
			System.out.println("--------------");
			
			List<Cart> cartlList=cartService.findAllCart();
			
			int i=0;
			
			System.out.println(inStock[0]+":::::"+inStock[1]);
			
			List<Item> itemList=new ArrayList<Item>();
			
			for(Cart cart:cartlList){
				
				Item item=new Item();
				
				item=queryItemById(cart.getItemid());
				
				System.out.println(item.getListprice()+":::::"+Double.valueOf(inStock[i]));
				
				//�ܼ۸����item��¼
				Double sum=null;
				
				sum=Double.valueOf(inStock[i])*item.getListprice();
				
				System.out.println("sum::"+sum);
				
				item.setSumprice(sum);
				
				System.out.println(item.getSumprice()+"----");
				
				item.setQuantity(inStock[i]);
				
				
				/**
				 * ����cart�������
				 */
				cart.setQuantity(Long.valueOf(inStock[i]));
				
				cartService.updateQuantity(cart);
				
				
				
				/**
				 * 2.����ѯ
				 */
				Integer qty=service.queryQTY(cart.getItemid()) - Integer.valueOf(cart.getQuantity().toString());
				
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
