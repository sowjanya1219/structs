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

@WebServlet("/editExpense")
public class EditExpenseServlet extends HttpServlet {
	FERService ferService = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferService = new FERServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
	//	session.getAttribute("expenseobject");
		
		Expense expense =new Expense();
						
		expense.setType(request.getParameter("type"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(Float.parseFloat(request.getParameter("price")));
		expense.setNumberOfItems(Integer.parseInt(request.getParameter("numberOfItems")));
		expense.setTotal(Float.parseFloat(request.getParameter("total")));
		expense.setByWhom(request.getParameter("byWhom"));
		expense.setId(Integer.parseInt(session.getAttribute("expenseid").toString()));
		
		boolean isEditExpense = ferService.editExpense(expense);
		
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		
		out.println(isEditExpense ? "Expense edited successfully..." : "No expenses to edit");
		
		HTMLUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;
	}
}
