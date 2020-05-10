package com.mytest.request;

/**
 * Created by Shubham Gupta on Sun, 19/4/20.
 */
public class RegisterRequest {
    private String username;
    private String lastname;
    private String number;
    private String email;
    private String password;

    public RegisterRequest(String username, String lastname, String number, String email, String password) {
        this.username = username;
        this.lastname = lastname;
        this.number = number;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
