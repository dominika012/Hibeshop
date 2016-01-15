package com.nessacademy.bean;

import java.util.HashSet;  
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;  
import javax.persistence.Table;  


@Entity
@Table(name = "product")
public class Product {

	
		@Id @GeneratedValue
	    @Column(name = "product_id")
		private int product_id;
		
		
		@Column(name = "name", length = 30, unique = true)
		private String name;
		
		
		@Column(name = "description")
		private String description;
		
		
		@Column(name = "price")
		private double price;

		
		@ManyToMany(cascade = { CascadeType.ALL })  
		@JoinTable(name = "products_orders", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })  
		private Set<Order> orders = new HashSet<Order>();  
		
		public int getProduct_id() {
			return product_id;
		}


		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		
		
		public Set<Order> getOrders() {
			return orders;
		}


		public void setOrders(Set<Order> orders) {
			this.orders = orders;
		}


		@Override
		public String toString() {
			return "Product [product_id=" + product_id + ", name=" + name + ", description=" + description + ", price="
					+ price + "]";
		}
		
		
		
	
}
