package com.rs.jdbc1Examples;

import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {

		int expenseId = 7;
		FERService ferService = new FERServiceImpl();
		boolean isDeleteExpense = ferService.deleteExpense(expenseId);

		if (isDeleteExpense)
			System.out.println("expense deleted successfully.....");
		else
			System.out.println("expense Deletion failed....");
	}
}
