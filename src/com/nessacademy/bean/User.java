package com.nessacademy.bean;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "user")
public class User{
		
		@Id @GeneratedValue
	    @Column(name = "user_id")
	    private int user_id;
		
		@Column(name = "login", length = 50, unique = true)
		private String login;
	
		@Column(name = "password")
		String password;
		
		@Column(name = "isadmin", columnDefinition = "TINYINT")
		@Type(type = "org.hibernate.type.NumericBooleanType")
		boolean isAdmin;
	
		
		
		public User(){
		}
		
		public int getId() {
			return user_id;
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
		
		        
		        @Override
		public String toString() {
		            /*String rights = "";
		                if (isAdmin==true) rights="yes";
		                else rights="no";*/
			return "User: login = " + login + " .Has Admin rights? " + isAdmin;
		}

				
			
	        
}
