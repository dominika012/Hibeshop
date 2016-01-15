package com.nessacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.nessacademy.bean.Product;
import com.nessacademy.hibernate.HibernateUtil;



@Repository  
public class ProductDao implements IProductDao{

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public void add(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
    	session.save(product);
    	session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> products() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
    	List<Product> products = session.createQuery("from Product").list();
    	session.getTransaction().commit();
    	return products;
	}

	@Override
	public List<String> productNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product findById(int product_id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
    	Product product = (Product) session.createQuery("from Product p where p.product_id=:product_id").setInteger("product_id", product_id).uniqueResult();
    	session.getTransaction().commit();
    	return product;
	}

	@Override
	public Product findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
    	Product product = (Product) session.createQuery("from Product p where p.name=:name").setString("name", name).uniqueResult();
    	session.getTransaction().commit();
    	return product;
	}

	
	
}
