package com.nessacademy.controller;

import java.util.List;

import com.nessacademy.bean.Product;
import com.nessacademy.dao.ProductDao;


public class ProductService {

	private ProductDao productDao;
    
    public ProductService(){
    	productDao = new ProductDao();
    }
    
    
    
    public void add(Product product){
            productDao.add(product);
    }
    
    public List<Product> products() {
	return productDao.products();
    }
    
    /*
    public List<User> admins() {
	return userDao.admins();
    }
    
    public List<User> customers() {
	return userDao.customers();
    }
    */
    public void removeById(Integer id){
        Product product = productDao.findById(id);
        productDao.remove(product);
    }
    
    public Product findById(Integer id){
    	return productDao.findById(id);
    }
	
}
