package com.rs.jdbc1Examples;

import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		String username = "baji1219";
		String password = "bharadwaj1219";
//		boolean isLogin = ferService.login(username, password);

		/*if (isLogin)
			System.out.println("login successfully.....");
		else
			System.out.println("login failed....");*/

	}

}
