package com.rs.jdbc1Examples;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class UpdatePersonalMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();

		User user = new User();

		user.setFirstName("malampati");
		user.setMiddleName("bharadwaj");
		user.setLastName("chowdary");
		user.setMail("bharath1219@gmail.com");
		user.setUsername("chowdary");
		user.setPassword("123456");
		user.setMobile("999999999");
		user.setId(5);

		Address address = new Address();
		address.setLineOne("ayyappa society");
		address.setLineTwo("road no 11");
		address.setStreet("nagarjuna nagar");
		address.setCity("hyderabad");
		address.setState("telangana");
		address.setZip("500081");
		address.setId(1);

		user.setAddress(address);
		boolean updatePersonal = ferService.updatePersonal(user);
		if (updatePersonal)
			System.out.println("successfully");

		else
			System.out.println("failed");

	}

}
