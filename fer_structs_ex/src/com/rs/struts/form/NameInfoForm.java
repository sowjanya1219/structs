package com.rs.struts.form;

import org.apache.struts.action.ActionForm;

public class NameInfoForm extends ActionForm{
	private String firstname;
	private String middlename;
	private String lastname;
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
	

}
