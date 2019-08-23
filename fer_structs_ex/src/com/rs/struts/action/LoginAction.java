package com.rs.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.struts.form.LoginForm;
//import com.rs.struts.form.LoginValidatorForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("LoginAction.execute()");
		LoginForm loginForm = (LoginForm) form;

		boolean isValidUser = "admin".equals(loginForm.getUsername()) && "admin".equals(loginForm.getPassword());

		return mapping.findForward(isValidUser ? "success" : "failure");

	}

}
