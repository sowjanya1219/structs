package com.rs.jdbc1Examples;

import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class ExpenseReport {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int userId = 3;
		String expenseType = "stationary";
		String fromDate = "2019-04-05";
		String toDate = "2019-04-06";
		List<Expense> expense = ferService.expenseReport(userId, expenseType, fromDate, toDate);
		if (expense != null)
			System.out.println("expence report fetched ");
		else
			System.out.println("expense report fetching failed");

	}

}
