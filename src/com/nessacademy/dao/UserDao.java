package com.nessacademy.dao;


import com.nessacademy.bean.User;
import com.nessacademy.hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository  
public class UserDao implements IUserDao{
	
	private Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
    @Override
    public void add(User user) {
    	session.beginTransaction();
    	session.save(user);
    	session.getTransaction().commit();
    	
    }

    @Override
    public List<User> users() {
    	session.beginTransaction();
    	List<User> users = session.createQuery("from User").list();
    	session.getTransaction().commit();
    	return users;
    }
    
//------------------------------------------
 /*   //FIXME
    @Override
    public List<User> admins() {
    	return this.sessionFactory.getCurrentSession().createQuery("from User where isadmin='yes'").list();
    }
    
    //FIXME
    @Override
    public List<User> customers() {
    	return this.sessionFactory.getCurrentSession().createQuery("from User where isadmin='no'").list();
    }
    
    //FIXME
    @Override
    public void modify(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
  //------------------------------------------
    
    @Override
    public void remove(User user) {
    	//this.sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User findById(int id) {
    	session.beginTransaction();
    	User user = (User) session.createQuery("from User u where u.user_id=:user_id").setInteger("user_id", id).uniqueResult();
    	session.getTransaction().commit();
    	return user;
    }

    @Override
    public User findByLogin(String login) {
    	session.beginTransaction();
    	User user = (User) session.createQuery("from User u where u.login=:login").setString("login", login).uniqueResult();
    	session.getTransaction().commit();
    	return user;
    }
}
