package com.rs.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.bean.User;
import com.rs.struts.form.RegistrationForm;

public class RegistrationAction  extends Action {
	
	FERService ferservice = new FERServiceimpl();
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		RegistrationForm registrationForm=(RegistrationForm) form;
		User user = new User();

		user.setFirstname(registrationForm.getFirstname());
		user.setMiddlename(registrationForm.getMiddlename());
		user.setLastname(registrationForm.getLastname());
		user.setUsername(registrationForm.getUsername());
		user.setPassword(registrationForm.getPassword());
		user.setEmail(registrationForm.getEmail());
		user.setMobile(registrationForm.getMobile());

		boolean isRegister = ferservice.registration(user);
		return mapping.findForward(isRegister ? "success" :"failure");
	}

}
