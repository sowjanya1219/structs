package com.rs.jdbc1Examples;

import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int userId = 3;
		List<Expense> expenses = new ArrayList<Expense>();
		expenses = ferService.getExpenses(userId);
		if (expenses != null)
			System.out.println("expence report fetched ");
		else
			System.out.println("expense report fetching failed");

	}

}
