package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/displayEditExpense")
public class DisplayEditExpenseServlet extends HttpServlet {
	FERService ferService = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ferService = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		int expenseid = Integer.parseInt(request.getParameter("id").toString());
		session.setAttribute("expenseid", expenseid); 
		
		Expense expense = ferService.getExpense(expenseid);
	//	session.setAttribute("expenseobject", expense);

		out.println("<table align='center'border='1'  >");
		out.println("<tr>");
		out.println("<td colspan='2' align ='center'>Edit Expense</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>ExpenseType</td>");
		out.println("<td><input type='text' name='type' value='" + expense.getType() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td><input type='date' name='date' value='" + expense.getDate() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Price</td>");
		out.println("<td><input type='text' name='price'value='" + expense.getPrice() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Number of items</td>");
		out.println("<td><input type='text' name='numberOfItems'value='" + expense.getNumberOfItems() + "' ></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Total</td>");
		out.println("<td><input type='text' name='total' value='" + expense.getTotal() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>By whom</td>");
		out.println("<td><input type='text' name='byWhom' value='" + expense.getByWhom() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align ='center'>");
		out.println("<a href=javascript:submitForm('editExpense')>Submit</a>");
		out.println("</td>");
		out.println("<tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response);

	}

}
