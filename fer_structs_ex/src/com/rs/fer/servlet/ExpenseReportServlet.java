package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/expenseReport")
public class ExpenseReportServlet extends HttpServlet {
	FERService ferService = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferService = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int id = Integer.parseInt(session.getAttribute("id").toString());

		String expenseType = request.getParameter("expenseType");
		String toDate = request.getParameter("toDate");
		String fromDate = request.getParameter("fromDate");

		List<Expense> expenses = ferService.expenseReport(id, expenseType, fromDate, toDate);

		PrintWriter out = response.getWriter();

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		if (expenses != null && !expenses.isEmpty()) {

			out.println("<table align='center' border='1'>");
			out.println("<tr> Expense Report ");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>type</th>");
			out.println("<th>Date</th>	");
			out.println("<th>Price</th>");
			out.println("<th>Number of items</th>");
			out.println("<th>Total</th>");
			out.println("<th>By whom</th>");
			out.println("</tr>");

			for (Expense expense : expenses) {
				out.println("<tr>");
				out.println("<td><input type='text' name='type' value='" + expense.getType() + "'></td>");
				out.println("<td><input type='date' name='date' value='" + expense.getDate() + "'></td>");
				out.println("<td><input type='text' name='price'value='" + expense.getPrice() + "' ></td>");
				out.println(
						"<td><input type='text' name='numberOfItems'value='" + expense.getNumberOfItems() + "'></td>");
				out.println("<td><input type='text' name='total' value='" + expense.getTotal() + "'></td>");
				out.println("<td><input type='text' name='byWhom' value='" + expense.getByWhom() + "'></td>");
				out.println("</tr>");
			}
			out.println("</table>");

		}
		HTMLUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;
	}
}