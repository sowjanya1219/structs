package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.util.HTMLUtil;

@WebServlet("/displayExpenseReport")
public class DisplayExpenseReport extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			
			PrintWriter out = response.getWriter();
			HTMLUtil.displayHeaderAndLeftFrame(request,response,out,session.getAttribute("username").toString());
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ExpenseReport.html");
			requestDispatcher.include(request, response);
			HTMLUtil.displayFooter(request,response);
			
	}
}
