package com.rs.jdbc1Examples;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		int expenseId = 15;
		Expense expense = ferService.getExpense(expenseId);
		if (expense != null)
			System.out.println("expence report fetched ");
		else
			System.out.println("expense report fetching failed");

	}

}
