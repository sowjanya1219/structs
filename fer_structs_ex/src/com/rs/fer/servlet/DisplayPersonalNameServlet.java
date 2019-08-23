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

@WebServlet("/displayPersonalName")
public class DisplayPersonalNameServlet extends HttpServlet {

	FERService ferService = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		ferService = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(session.getAttribute("id").toString());
		User personalInfo = ferService.getPersonalInfo(id);
		session.setAttribute("personalInfo", personalInfo);
		
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		out.println("<table align=\"center\" border=\"1\"  >");
		out.println("<tr>");
		out.println("<td colspan='2' align ='center'>Update Personal Name Information</td>");
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
		out.println("	<td>Last name</td>");
		out.println("	<td><input type='text' name='lastname' value='" + personalInfo.getLastName() + "'></td>");
		out.println("</tr>");
		out.println("<td colspan='2' align ='center'>");
		out.println("<a href=javascript:submitForm('displayPersonalContact')>Next</a>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response);

	}
}
