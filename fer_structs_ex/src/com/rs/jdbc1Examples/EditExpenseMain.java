package com.rs.jdbc1Examples;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {

		Expense expense = new Expense();

		expense.setType("stationary");
		expense.setDate("2019-04-05");
		expense.setPrice(19.5f);
		expense.setNumberOfItems(10);
		expense.setTotal(195.00f);
		expense.setByWhom("vikas");
		expense.setId(7);

		FERService ferService = new FERServiceImpl();
		boolean isEditExpense = ferService.editExpense(expense);

		if (isEditExpense)
			System.out.println("expense updated successfully.....");
		else
			System.out.println("expense updation failed....");

	}
}