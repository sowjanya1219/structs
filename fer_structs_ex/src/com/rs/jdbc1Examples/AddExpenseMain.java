package com.rs.jdbc1Examples;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {

		Expense expense = new Expense();

		expense.setType("stationary");
		expense.setDate("2019-04-05");
		expense.setPrice(18.5f);
		expense.setNumberOfItems(10);
		expense.setTotal(185.00f);
		expense.setByWhom("bharath");
		expense.setUserid(3);

		FERService ferService = new FERServiceImpl();
		boolean isAddExpense = ferService.addExpense(expense);

		if (isAddExpense)
			System.out.println("expense added successfully.....");
		else
			System.out.println("expense addition failed....");

	}

}
