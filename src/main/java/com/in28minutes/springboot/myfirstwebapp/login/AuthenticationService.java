package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isValidUser(String name, String password) {
        boolean isValidUser = name.equals("umang");
        boolean isValidPassword = password.equals("a");

        return isValidPassword && isValidUser;
    }
}
