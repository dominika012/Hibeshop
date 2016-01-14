package com.nessacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.nessacademy.bean.Order;
import com.nessacademy.bean.User;
import com.nessacademy.hibernate.HibernateUtil;

@Repository  
public class OrderDao implements IOrderDao{

	private Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	@Override
	public void addOrder(Order order) {
		session.beginTransaction();
    	session.save(order);
    	session.getTransaction().commit();
	}

	@Override
	public List<Order> orders() {
		session.beginTransaction();
    	List<Order> orders = session.createQuery("from Order").list();
    	session.getTransaction().commit();
    	return orders;
	}

	@Override
	public void remove(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> userOrders(String login) {
		session.beginTransaction();
    	List<Order> orders = session.createQuery("from Order join User where order.user_id = user.user_id").list();
    	session.getTransaction().commit();
    	return orders;
	}

	
	
}
