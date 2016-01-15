package com.nessacademy.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "user")
public class User{
		

		@Id @GeneratedValue
	    @Column(name = "user_id")
	    private int user_id;
		
		
		@Column(name = "login", length = 30, unique = true)
		private String login;
	
		
		@Column(name = "password")
		String password;
		
		
		@Column(name = "isadmin", columnDefinition = "TINYINT")
		@Type(type = "org.hibernate.type.NumericBooleanType")
		boolean isAdmin;
	
		
		 @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
		 private Set<Order> userOrders = new HashSet<Order>();
		

		 
		public int getUser_id() {
			return user_id;
		}



		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}



		public String getLogin() {
			return login;
		}



		public void setLogin(String login) {
			this.login = login;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public boolean isAdmin() {
			return isAdmin;
		}



		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}



		public Set<Order> getUserOrders() {
			return userOrders;
		}



		public void setUserOrders(Set<Order> userOrders) {
			this.userOrders = userOrders;
		}



				@Override
		public String toString() {
			return "User: login = " + login + " .Has Admin rights? " + isAdmin;
		}


}
