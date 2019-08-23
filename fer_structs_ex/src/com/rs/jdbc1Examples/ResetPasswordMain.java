package com.rs.jdbc1Examples;

import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		int id = 7;
		String currentPassword = "bharadwaj1219";
		String newPassword = "karaan1219";

		boolean isResetPassword = ferService.resetPassword(id, currentPassword, newPassword);

		if (isResetPassword)
			System.out.println("reset password successfully.....");
		else
			System.out.println("reset password failed....");

	}

}
