package com.nessacademy.bean;

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
	
		@OneToMany(mappedBy="user")
		private Set<Order> orders;
		
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
		
		
		

				public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public Set<Order> getOrders() {
			return orders;
		}

		public void setOrders(Set<Order> orders) {
			this.orders = orders;
		}

				@Override
		public String toString() {
		            /*String rights = "";
		                if (isAdmin==true) rights="yes";
		                else rights="no";*/
			return "User: login = " + login + " .Has Admin rights? " + isAdmin;
		}

				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + (isAdmin ? 1231 : 1237);
					result = prime * result + ((login == null) ? 0 : login.hashCode());
					result = prime * result + ((orders == null) ? 0 : orders.hashCode());
					result = prime * result + ((password == null) ? 0 : password.hashCode());
					result = prime * result + user_id;
					return result;
				}

				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (obj == null)
						return false;
					if (!(obj instanceof User))
						return false;
					User other = (User) obj;
					if (isAdmin != other.isAdmin)
						return false;
					if (login == null) {
						if (other.login != null)
							return false;
					} else if (!login.equals(other.login))
						return false;
					if (orders == null) {
						if (other.orders != null)
							return false;
					} else if (!orders.equals(other.orders))
						return false;
					if (password == null) {
						if (other.password != null)
							return false;
					} else if (!password.equals(other.password))
						return false;
					if (user_id != other.user_id)
						return false;
					return true;
				}

				
			
	        
}
