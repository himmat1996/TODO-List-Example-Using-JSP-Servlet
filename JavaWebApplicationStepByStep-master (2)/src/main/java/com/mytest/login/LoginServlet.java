package com.mytest.login;


import com.mytest.register.RegisterService;
import com.mytest.request.LoginRequest;
import com.mytest.request.RegisterRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/*

 // Method descriptor #15 ()V
 public void init() throws javax.servlet.ServletException;

 // Method descriptor #37 (Ljavax/servlet/ServletRequest;Ljavax/servlet/ServletResponse;)V
 public void service(javax.servlet.ServletRequest arg0, javax.servlet.ServletResponse arg1) throws javax.servlet.ServletException, java.io.IOException;

 // Method descriptor #15 ()V
 public void destroy();

 */
@WebServlet(urlPatterns = "/")
public class LoginServlet extends HttpServlet {

	private LoginService userValidationService = new LoginService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String last= request.getParameter("last");

		if (last == null){
			LoginRequest loginRequest = new LoginRequest(request.getParameter("name"),request.getParameter("password"));
			boolean isUserValid = userValidationService.isUserValid(loginRequest);

			if (isUserValid) {
				request.getSession().setAttribute("name", loginRequest.getUsername());
				response.sendRedirect("/list-todos.do");
			} else {
				request.setAttribute("errorMessage", "Invalid Credentials!");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
						request, response);
			}


		}else {
			RegisterRequest registerRequest = new RegisterRequest(request.getParameter("name"),request.getParameter("last"),request.getParameter("number"),request.getParameter("email"),request.getParameter("password"));

			RegisterService registerService= new RegisterService();
			if (registerService.isUserExist(registerRequest)) {
				request.setAttribute("errorMessage", "SuccessFully Register");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
						request, response);
			} else {
				request.setAttribute("errorMessage", "Failed Register");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
						request, response);
			}

		}


	}

}