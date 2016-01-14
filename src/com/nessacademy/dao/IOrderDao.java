package com.nessacademy.dao;

import java.util.List;

import com.nessacademy.bean.Order;

public interface IOrderDao {
	 public void addOrder(Order order);
     
     public List<Order> orders();
     
     public void remove(Order order);
     
     public Order findById(String id);
     
     //public List<Order> userOrders(String login);
}
