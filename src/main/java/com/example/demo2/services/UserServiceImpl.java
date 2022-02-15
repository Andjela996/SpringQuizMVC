package com.example.demo2.services;

import com.example.demo2.login.LoginCredentials;
import com.example.demo2.models.User;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class UserServiceImpl implements UserService{

    private User user;

    @Override
    public boolean checkLogin(LoginCredentials loginCredentials, Iterable<User> users) {
        //check if user exists
        boolean check = false;
        User u = null;
        Iterator iterator = users.iterator();
        User u1;
        while(iterator.hasNext()){
            u1 = (User) iterator.next();
            System.out.println("USER:"+u1.getUsername());
            user = u1;
            if(u1.getUsername().equals(loginCredentials.getUsername()) && u1.getPassword().equals(loginCredentials.getPassword())){

                check=true;
                break;
            }

        }
        return check;
    }

    @Override
    public User getUser() {
        return user;
    }
}
