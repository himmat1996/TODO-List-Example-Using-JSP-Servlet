package com.mytest.request;

/**
 * Created by Shubham Gupta on Sun, 19/4/20.
 */
public class LoginRequest {

    private String username ;
    private String password;

    public LoginRequest(String username,String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
