package com.rs.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class RegistrationForm extends ValidatorForm{
	private String firstname;
	private String middlename;
	private String lastname;
	private String username;
	private String password;
	private String mobile;
	private String email;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.firstname="plese enter first name";
		this.middlename="plese enter middle name";
		this.lastname="plese enter last name";
		this.username="plese enter username";
		this.password="aaaa";
		this.mobile="plese enter mobile number";
		this.email="please enter email";

	}


 }



