package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/displayPersonalContact")
public class DisplayPersonalContactServlet extends HttpServlet {

	FERService ferService = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		ferService = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		User personalInfo = (User) session.getAttribute("personalInfo");
		personalInfo.setFirstName(request.getParameter("firstname"));
		personalInfo.setMiddleName(request.getParameter("middlename"));
		personalInfo.setLastName(request.getParameter("lastname"));
		session.setAttribute("personalInfo", personalInfo);

		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		out.println("<table align=\"center\" border=\"1\"  >");
		out.println("<tr>");
		out.println("<td colspan='2' align ='center'>Update Personal Contact Information</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Email</td>");
		out.println("<td><input type='text' name='email' value='" + personalInfo.getMail() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Mobile Number</td>");
		out.println("<td><input type='text' name='mobile' value='" + personalInfo.getMobile() + "'></td>");
		out.println("</tr>");
		out.println("<td colspan='2' align ='center'>");
		out.println("<a href=javascript:submitForm('displayPersonalAddress')>Submit</a>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response);

	}
}
