package com.rs.jdbc1Examples;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {

		User user = new User();
		user.setFirstName("malampati");
		user.setMiddleName("");
		user.setLastName("Bharadwaj");
		user.setMail("bharadwaj@gmail.com");
		user.setUsername("bharadwaj1219");
		user.setPassword("bharath1219");
		user.setMobile("8019202002");

		FERService ferService = new FERServiceImpl();
		boolean isRegister = ferService.registration(user);

		if (isRegister)
			System.out.println("User registered successfully.....");
		else
			System.out.println("user registered failed....");

	}
}
