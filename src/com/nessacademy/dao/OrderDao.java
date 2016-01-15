package com.nessacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nessacademy.bean.Order;
import com.nessacademy.bean.User;
import com.nessacademy.hibernate.HibernateUtil;

@Repository  
public class OrderDao implements IOrderDao{

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public void addOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
    	session.save(order);
    	session.getTransaction().commit();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Order> orders() {
		Session session = sessionFactory.getCurrentSession();
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
	public Order findById(int order_id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
    	Order order = (Order) session.createQuery("from Order o where o.order_id=:order_id").setInteger("order_id", order_id).uniqueResult();
    	session.getTransaction().commit();
    	return order;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Order> userOrders(String login) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
    	List<Order> orders = session.createQuery("from Orders join User where order.user_id = user.user_id").list();
    	session.getTransaction().commit();
    	return orders;
	}

	
	
}
