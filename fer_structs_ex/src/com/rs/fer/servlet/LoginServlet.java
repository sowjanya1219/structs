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
import javax.servlet.http.HttpSession;

import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	FERService ferService = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferService = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		int id = ferService.login(username, password);

		PrintWriter out = response.getWriter();

		if (id > 0) {

			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("id", id);

			HTMLUtil.displayHeaderAndLeftFrame(request, response, out, username);
			out.println("welcome to the user:" + username);
			HTMLUtil.displayFooter(request, response);

		} else {
			out.println("login failed...please enter correct details");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");
			requestDispatcher.include(request, response);
		}

	}

	@Override
	public void destroy() {
		ferService = null;
	}
}
