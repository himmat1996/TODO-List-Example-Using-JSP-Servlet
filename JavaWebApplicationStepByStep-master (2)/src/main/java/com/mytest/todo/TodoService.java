package com.mytest.todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoService {

	public List<Todo> retrieveTodos() {
		List<Todo> todos = new ArrayList<Todo>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspservlet", "pmmp", "pmmp123");
			//here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			String q = "select * from todo";
			ResultSet rs = stmt.executeQuery(q);
			while (rs.next()){
				todos.add(new Todo(rs.getString(2),rs.getString(3)));
			}

		} catch (Exception e) {
			System.out.println("failed to get list");
		}
		return todos;
	}

	public void addTodo(Todo todo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspservlet", "pmmp", "pmmp123");
			//here sonoo is database name, root is username and password
			PreparedStatement ps=con.prepareStatement(
					"insert into todo(id,name,category) values (?,?,?)");
			ps.setString(1, String.valueOf(UUID.randomUUID()));
			ps.setString(2,todo.getName());
			ps.setString(3,todo.getCategory());
			ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("failed to get list");
		}
	}

	public void deleteTodo(Todo todo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspservlet", "pmmp", "pmmp123");
			//here sonoo is database name, root is username and password
			PreparedStatement ps=con.prepareStatement(
					"delete from todo where name=?");
			ps.setString(1, todo.getName());
			ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("failed to get list");
		}
	}

}
