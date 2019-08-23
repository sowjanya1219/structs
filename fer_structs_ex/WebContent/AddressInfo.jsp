<%@page import="com.rs.fer.serviceimpl.FERServiceImpl"%>
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	FERService ferService = new FERServiceImpl();	
	User personalInfo = (User) session.getAttribute("personalInfo");
		personalInfo.setMail(request.getParameter("email"));
		personalInfo.setMobile(request.getParameter("mobile"));
		session.setAttribute("personalInfo", personalInfo);


		out.println("<table align=\"center\" border=\"1\"  >");
		out.println("<tr>");
		out.println("<td colspan='2' align ='center'>Update Personal Address Information</td>");
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
		out.println("<a href=javascript:submitForm('displayPersonalReview')>Next</a>");
		out.println("</tr>");
		out.println("</table>");
		%>