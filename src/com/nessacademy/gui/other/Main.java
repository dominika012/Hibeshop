package com.nessacademy.gui.other;

import com.nessacademy.bean.User;
import com.nessacademy.controller.OrderService;
import com.nessacademy.controller.UserService;;

public class Main {

	public static void main(String[] args) {
		//OrderService orderService = new OrderService();
		UserService service = new UserService();
		System.out.println(service.findById(1));
		

	}

}
