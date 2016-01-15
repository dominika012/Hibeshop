package com.nessacademy.authentification;

import com.nessacademy.controller.UserService;
import com.nessacademy.bean.User;

public class LoginAuthInstance {
	public static final LoginAuthInstance INSTANCE = new LoginAuthInstance();
    
    
    static private LoginAuthInstance loginAuthInstance = new LoginAuthInstance();

    static private UserService userService = new UserService();
    
    private LoginAuthInstance() {
    }
    
    public static LoginAuthInstance getLoginAuthSingletonFactory(){
        return loginAuthInstance;
    }
    
    public boolean isAuthentificated(String login, String password){
        for(User user:userService.users())
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                return true;
                
            }
        return false;
    }
}
