package com.example.demo2.services;

import com.example.demo2.login.LoginCredentials;
import com.example.demo2.models.User;

public interface UserService {
    boolean checkLogin(LoginCredentials loginCredentials, Iterable<User> users);
    User getUser();
}
