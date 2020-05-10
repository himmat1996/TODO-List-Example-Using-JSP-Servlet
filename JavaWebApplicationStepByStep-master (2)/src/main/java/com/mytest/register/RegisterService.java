package com.mytest.register;

import com.mytest.request.RegisterRequest;

import javax.validation.Valid;
import java.sql.*;
import java.util.UUID;

/**
 * Created by Shubham Gupta on Sun, 19/4/20.
 */
public class RegisterService {

    public boolean isUserExist(RegisterRequest registerRequest) {
        boolean registerResult = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jspservlet", "pmmp", "pmmp123");
            //here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            String q = "select * from user";
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()){
                if (rs.getString(2).equals(registerRequest.getUsername()) && rs.getString(3).equals(registerRequest.getPassword())){
                    registerResult=  false;
                }
            }

        } catch (Exception e) {
            System.out.println("login failed");
            registerResult=  false;
        }
        if (registerResult){
             registerResult = createUser(registerRequest);
        }

        return registerResult;

    }

    public Boolean createUser(RegisterRequest registerRequest){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jspservlet", "pmmp", "pmmp123");
            //here sonoo is database name, root is username and password
            PreparedStatement ps=con.prepareStatement(
                    "insert into user(id,username,password,lastname,number,email) values (?,?,?,?,?,?)");
            ps.setString(1, String.valueOf(UUID.randomUUID()));
            ps.setString(2,registerRequest.getUsername());
            ps.setString(3,registerRequest.getPassword());
            ps.setString(4,registerRequest.getLastname());
            ps.setString(5,registerRequest.getNumber());
            ps.setString(6,registerRequest.getEmail());
            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println("failed to get list");
            return false;
        }
        return true;

    }
}
