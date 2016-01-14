package com.nessacademy.controller;

import java.util.List;

import com.nessacademy.bean.Order;
import com.nessacademy.bean.User;
import com.nessacademy.dao.OrderDao;

public class OrderService {

	private OrderDao orderDao;
    
    public OrderService(){
    	orderDao = new OrderDao();
    }
    //-------------------------------------------------------------------------
    
    public void add(User user){
            Order order = new Order();
            order.setUser(user);
            orderDao.addOrder(order);
    }
    
    public List<Order> orders() {
	return orderDao.orders();
    }
	
}
