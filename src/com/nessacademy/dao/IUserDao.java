package com.nessacademy.dao;

import com.nessacademy.bean.User;
import java.util.List;

public interface IUserDao {
	 	
		public void add(User user);
	    
	    public List<User> users();
	    /*
	    public List<User> admins();
	    
	    public List<User> customers();
	    
	    public void modify(User user);
	    */
	    public void remove(User user);
	    
	    public User findById(int id);
	    
	    public User findByLogin(String login);
}
