package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	FERService ferService = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferService = new FERServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setFirstName(request.getParameter("firstname"));
		user.setMiddleName(request.getParameter("middlename"));
		user.setLastName(request.getParameter("lastname"));
		user.setMail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setMobile(request.getParameter("mobile"));
		
		PrintWriter out = response.getWriter();
		String nextPath = null;
		boolean isRegister = ferService.registration(user);
		if (isRegister) {
			out.println("User registered successfully.please try using login<br>");
			nextPath = "Login.html";
			
		} else {
			out.println("user registered failed.Please try again<br>");
			nextPath = "Registration.html";
			
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPath);
		requestDispatcher.include(request, response);
	}

	@Override
	public void destroy() {
		ferService = null;
	}
}
