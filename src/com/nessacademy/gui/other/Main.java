package com.nessacademy.gui.other;



import com.nessacademy.bean.Order;
import com.nessacademy.bean.Product;
import com.nessacademy.bean.User;
import com.nessacademy.controller.OrderService;
import com.nessacademy.controller.ProductService;
import com.nessacademy.controller.UserService;;

public class Main {

	public static void main(String[] args) {
		OrderService orderService = new OrderService();
		UserService userService = new UserService();
		ProductService productService = new ProductService();
		
		//ok
		/*System.out.println(userService.findById(1));
		System.out.println(userService.users());
		
		User user = userService.findById(1);
		System.out.println(user);
		
		orderService.add(user);
		
		for(Order order : orderService.orders()){
			System.out.println(order.toString());
		}
		*/
		
		
		
		/*Product product = new Product();
		product.setName("krompac");
		product.setDescription("netusim na co to je");
		product.add(product);
		for(Product product : productService.products()){
			System.out.println(product.toString());
		}
		*/
		
		Order order = orderService.findById(1);
		System.out.println(order);
		
		Product product = productService.findById(1);
		System.out.println(product);
		
		User user = userService.findById(1);
		System.out.println(user);
		
	}

}
