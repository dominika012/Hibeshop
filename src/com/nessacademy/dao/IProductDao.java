package com.nessacademy.dao;

import java.util.List;

import com.nessacademy.bean.Product;

public interface IProductDao {
	public void add(Product product);

	public List<Product> products();
        
    public List<String> productNames();
        
	public void remove(Product product);
        
    public Product findById(String id);
        
    public Product findByName(String name);
}
