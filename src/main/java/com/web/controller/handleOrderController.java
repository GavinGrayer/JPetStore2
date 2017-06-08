package com.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Account;
import com.web.entity.Cart;
import com.web.entity.Item;
import com.web.entity.Orders;
import com.web.entity.Product;
import com.web.service.CartService;
import com.web.service.OrderService;
import com.web.service.ProductToItemService;

@Controller
public class handleOrderController {

	@Autowired
	private OrderService service;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductToItemService productToItemService;
	
	private Orders orders1=new Orders();
	
	private Double sum1=null;
	
	@RequestMapping("/toNewOrderForm")
	public String toNewOrderForm(Double sum){
		
		sum1=sum;
		
		System.out.println("sum:::::"+sum1);
		
		return "/order/NewOrderForm";
	}
	
	
	
	
	/**
	 * 判断是否更改地址
	 * @param flag
	 * @param orders
	 * @return
	 */
	@RequestMapping("/judgeFlag")
	public String judgeFlag(String flag,Orders orders,Model model){
		
		if(flag.equals("1")){
			
			
			String timeString=caltime();
			
			SimpleDateFormat s=new SimpleDateFormat("yyyy/MM/dd h:m:s");
			
			Date time=null;
			
				try {
					time = s.parse(timeString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			System.out.println(orders.getBillcity()+"111");
				
			orders.setOrderdate(time);
			orders.setCourier("中国邮政");
			orders.setShipcity(orders.getBillcity());//3		
			orders.setShipcountry(orders.getBillcountry());//4
			
			orders.setTotalprice(sum1);//6
			
			orders.setBilltofirstname(orders.getAccount().getUserid());//7
			
			orders.setShiptofirstname(orders.getAccount().getUserid());//8
			
			orders.setUserid(orders.getAccount().getUserid());
			
			//Long orderid=service.saveOrder(orders);
			
			orders1=orders;
			
			
			
			return "/order/ShippingForm";
		}else{//订购成功
			
			System.out.println(orders.getBilladdr1()+"::"+orders.getAccount().getStatus());
			
			String timeString=caltime();
			
			SimpleDateFormat s=new SimpleDateFormat("yyyy/MM/dd h:m:s");
			
			Date time=null;
			
				try {
					time = s.parse(timeString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			System.out.println(orders.getBillcity()+"111");
				
			orders.setOrderdate(time);
			orders.setCourier("中国邮政");
			orders.setShipcity(orders.getBillcity());//3		
			orders.setShipcountry(orders.getBillcountry());//4
			
			orders.setTotalprice(sum1);//6
			
			orders.setBilltofirstname(orders.getAccount().getUserid());//7
			
			orders.setShiptofirstname(orders.getAccount().getUserid());//8
			
			orders.setUserid(orders.getAccount().getUserid());
			
			Long orderid=service.saveOrder(orders);
			
			
			
			List<Cart> cartlist=cartService.findAllCart();
			
			List<Item> itemList=new ArrayList<Item>();
			
			Double sum1=0.0;
			
			for(Cart c:cartlist){
				
				System.out.println(c.getItemid());
			
				Item item=new Item();
				
				item=queryItemById(c.getItemid());
				//总价格存入item记录
				item.setSumprice(item.getListprice()*c.getQuantity());
				
				item.setQuantity(c.getQuantity().toString());
				
				//总价格存入item记录
				Double sum=null;
				
				sum=Double.valueOf(c.getQuantity()*item.getListprice());
				
				System.out.println("sum::"+sum);
				
				item.setSumprice(sum);
				
				
				
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
				 * 计算sum
				 */
				sum1+=item.getSumprice();

				itemList.add(item);

			}
			
			
			
			
		
			model.addAttribute("sum", sum1);
			
			model.addAttribute("itemList", itemList);
			
			
			return "/order/ViewOrder";
		}

	}
	
	
	
	/**
	 * 更改地址
	 * @param orders
	 * @return
	 */
	@RequestMapping("/updateorders")
	public String updateInfor(Orders orders,Model model){
		
		orders1.setShipaddr1(orders.getShipaddr1());
		
		orders1.setBilladdr1(orders.getBilladdr1());
		
		orders1.setBillcity(orders.getBillcity());
		
		Account account=new Account();
		account.setStatus(orders.getAccount().getStatus());
		orders1.setAccount(account);
		orders1.setShipzip(orders.getShipzip());
		orders1.setBillcountry(orders.getBillcountry());
		
		
		Long orderid=service.saveOrder(orders1);
		
		
		
List<Cart> cartlist=cartService.findAllCart();
		
		List<Item> itemList=new ArrayList<Item>();
		
		Double sum1=0.0;
		
		for(Cart c:cartlist){
			
			System.out.println(c.getItemid());
		
			Item item=new Item();
			
			item=queryItemById(c.getItemid());
			//总价格存入item记录
			item.setSumprice(item.getListprice()*c.getQuantity());
			
			item.setQuantity(c.getQuantity().toString());
			
			//总价格存入item记录
			Double sum=null;
			
			sum=Double.valueOf(c.getQuantity()*item.getListprice());
			
			System.out.println("sum::"+sum);
			
			item.setSumprice(sum);
			
			
			
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
			 * 计算sum
			 */
			sum1+=item.getSumprice();

			itemList.add(item);

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		model.addAttribute("sum", sum1);
		
		
		model.addAttribute("itemList", itemList);
		
		
		return "/order/ViewOrder";
	}
	
	
	
	//************************************************************8
	public String caltime(){
		
		Date d=new Date();
		
		String year=String.valueOf(d.getYear()+1900);
		
		int month1=d.getMonth();
		String month=String.valueOf(month1);
		int date1=d.getDate();
		String date=String.valueOf(date1);
		int hour1=d.getHours();
		String hour=String.valueOf(hour1);
		int minute1=d.getMinutes();
		String minute=String.valueOf(minute1);
		int second1=d.getSeconds();
		String second=String.valueOf(second1);
		
		String time=year.concat("/".concat(month.concat("/".concat(date.concat(" ".concat(hour.concat(":".concat(minute.concat(":".concat(second))))))))));
	
		return time;
	}
	

	
	public Item queryItemById(String itemid){
		
		Item item=new Item();
		
		item=productToItemService.findItemById(itemid);
		
		return item;
	}
	
	public String queryNameById(String productid){
		
		String name=null;
		
		Product product=productToItemService.findProductById(productid);
		
		name=product.getName();
		
		return name;
	}
}
