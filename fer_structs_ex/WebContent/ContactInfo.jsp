<%@page import="com.rs.fer.serviceimpl.FERServiceImpl"%>
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	FERService ferService = new FERServiceImpl();
	User personalInfo = (User) session.getAttribute("personalInfo");
	personalInfo.setFirstName(request.getParameter("firstname"));
	personalInfo.setMiddleName(request.getParameter("middlename"));
	personalInfo.setLastName(request.getParameter("lastname"));
	session.setAttribute("personalInfo", personalInfo);

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
%>