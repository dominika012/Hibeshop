package com.nessacademy.controller;

import java.util.List;

import com.nessacademy.bean.User;
import com.nessacademy.dao.UserDao;

public class UserService {
	 private UserDao userDao;
	    
	    public UserService(){
	    userDao = new UserDao();
	    }
	    
	    public boolean canAdd(String login, String password){
	        if (login.isEmpty() || password.isEmpty()) 
	            for(User user : userDao.users())
	                if(user.getLogin().compareTo(login)==0)
	            return false;
	        return true;
	    }
	    
	    //-------------------------------------------------------------------------
	    
	    public void add(String login, String password){
	        if(canAdd(login, password)==true){
	            User user = new User();
	            user.setLogin(login);
	            user.setPassword(password);
	            user.setAdmin(false);
	            userDao.add(user);
	        }
	    }
	    
	    public List<User> users() {
		return userDao.users();
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
	        User user = userDao.findById(id);
	        userDao.remove(user);
	    }
	    public void removeByLogin(String login){
	        User user = userDao.findByLogin(login);
	        userDao.remove(user);
	    }
	    
	    public User findByLogin(String login){
	    	return userDao.findByLogin(login);
	    }
	    
	    public User findById(Integer id){
	    	return userDao.findById(id);
	    }
	    
}
