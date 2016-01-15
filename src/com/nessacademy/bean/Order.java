package com.nessacademy.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order{


	@Id 
	@GeneratedValue
    @Column(name = "order_id")
	private int order_id;
	
	
	@ManyToOne
    @JoinColumn(name="user_id")
    private User user;
	
	@Column(name = "datetime")
	private String datetime;
	
	
	@ManyToMany(mappedBy = "orders")  
	private Set<Product> products = new HashSet<Product>();  
	
	
	public Order() {
		super();
		setDatetime();
	}

	
	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getDatetime() {
		return datetime;
	}


	private void setDatetime() {
		Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yy  hh:mm");
        String datetime = ft.format(dNow);
        this.datetime=datetime;
	}



	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user=" + user + ", datetime=" + datetime + "]";
	}
	
	
	
}
