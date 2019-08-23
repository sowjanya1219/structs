package com.rs.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;
import com.rs.struts.form.LoginForm;

public class LoginAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		FERService ferservice=new FERServiceimpl();
		HttpSession session = request.getSession();

		LoginForm loginForm=(LoginForm) form;
		
		int userId = ferservice.login(loginForm.getUsername(),loginForm.getPassword());
		session.setAttribute("userId",userId);
		 
		return mapping.findForward(userId>0 ? "success" :"failure");
		
	}
	

}
