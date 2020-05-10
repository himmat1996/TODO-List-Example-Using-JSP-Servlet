package com.mytest.login;

import com.mytest.request.LoginRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginService {

	boolean isUserValid(LoginRequest loginRequest) {
		boolean loginResult = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspservlet", "pmmp", "pmmp123");
			//here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			String q = "select * from user";
			ResultSet rs = stmt.executeQuery(q);
            while (rs.next())
                if (rs.getString(2).equals(loginRequest.getUsername()) && rs.getString(3).equals(loginRequest.getPassword()))
                    loginResult=  true;
		} catch (Exception e) {
			System.out.println("login failed");
		}
		return loginResult;

	}

}
