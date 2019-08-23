package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/displayPersonalReview")
public class DisplayPersonalInfoReviewServlet extends HttpServlet {
	FERService ferService = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferService = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		ferService = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		User personalInfo = (User) session.getAttribute("personalInfo");
		
		personalInfo.getAddress().setLineOne(request.getParameter("lineOne"));
		personalInfo.getAddress().setLineTwo(request.getParameter("lineTwo"));
		personalInfo.getAddress().setStreet(request.getParameter("street"));
		personalInfo.getAddress().setCity(request.getParameter("city"));
		personalInfo.getAddress().setState(request.getParameter("state"));
		personalInfo.getAddress().setZip(request.getParameter("zip"));
		
		session.setAttribute("personalInfo", personalInfo);
	
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		out.println("<table align=\"center\" border=\"1\"  >");
		out.println("<tr>");
		out.println("<td colspan='2' align ='center'>Update Personal Review</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>First name</td>");
		out.println("<td><input type='text' name='firstname' value='" + personalInfo.getFirstName() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Middle name</td>");
		out.println("<td><input type='text' name='middlename'value='" + personalInfo.getMiddleName() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Last name</td>");
		out.println("<td><input type='text' name='lastname' value='" + personalInfo.getLastName() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Email</td>");
		out.println("<td><input type='text' name='email' value='" + personalInfo.getMail() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Mobile Number</td>");
		out.println("<td><input type='text' name='mobilenumber' value='" + personalInfo.getMobile() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>LineOne</td>");
		out.println(
				"<td><input type='text' name='lineOne' value='" + personalInfo.getAddress().getLineOne() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>LineTwo</td>");
		out.println(
				"<td><input type='text' name='lineTwo' value='" + personalInfo.getAddress().getLineTwo() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Street</td>");
		out.println("<td><input type='text' name='street' value='" + personalInfo.getAddress().getStreet() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='text' name='city' value='" + personalInfo.getAddress().getCity() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='text' name='state' value='" + personalInfo.getAddress().getState() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>ZIP</td>");
		out.println("<td><input type='text' name='zip' value='" + personalInfo.getAddress().getZip() + "'></td>");
		out.println("</tr>");
		out.println("<td colspan='2' align ='center'>");
		out.println("<a href=javascript:submitForm('displayPersonalInfoStatus')>Next</a>");
		out.println("</tr>");
		out.println("</table>");
		HTMLUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;
	}
}