package com.nessacademy.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order{

	@Id 
	@GeneratedValue
    @Column(name = "order_id")
	private int order_id;
	
	//private List<Product> products;
	
	@ManyToOne
    @JoinColumn(name="user_id")
    private User user;
	
	@Column(name = "datetime")
	private String datetime;
	
	
	public Order() {
		super();
		setDateTime();
	}

	public int getOrder_id() {
		return order_id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private void setDateTime() {
		Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yy  hh:mm");
        String datetime = ft.format(dNow);
        this.datetime=datetime;
	}
	
	public String getDate() {
		return this.datetime;
	}

	@Override
	public String toString() {
		return "Order [user_id=" + user.getLogin() + ", datetime=" + datetime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + order_id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Order))
			return false;
		Order other = (Order) obj;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (order_id != other.order_id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
}
