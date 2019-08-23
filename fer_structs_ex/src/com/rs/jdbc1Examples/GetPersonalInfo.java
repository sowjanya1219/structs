package com.rs.jdbc1Examples;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class GetPersonalInfo {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int userId = 5;
		User personalInfo = ferService.getPersonalInfo(userId);
		if (personalInfo != null)
			System.out.println("successfully.....");
		else
			System.out.println("failed....");
	}

}
