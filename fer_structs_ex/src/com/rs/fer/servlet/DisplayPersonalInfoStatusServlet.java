package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/displayPersonalInfoStatus")
public class DisplayPersonalInfoStatusServlet extends HttpServlet {
	FERService ferService = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferService = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		User personalInfo = (User) session.getAttribute("personalInfo");
		session.setAttribute("personalInfo", personalInfo);

	//	int id = Integer.parseInt(session.getAttribute("id").toString());

		boolean updatePersonal = ferService.updatePersonal(personalInfo);

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		out.println(updatePersonal ? "updated successfully..." : "update failed....");
		HTMLUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;
	}
}
