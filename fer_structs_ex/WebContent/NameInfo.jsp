<%@page import="com.rs.fer.serviceimpl.FERServiceImpl"%>
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%
	FERService ferService = new FERServiceImpl();
	
int id = Integer.parseInt(session.getAttribute("id").toString());
User personalInfo = ferService.getPersonalInfo(id);
session.setAttribute("personalInfo", personalInfo);
%>
<html:form action="/updatePersonal?method=contactInfo">
	<table align='center' border='1'>
		<tr>
			<td colspan='2' align='center'>NameInfo</td>
		</tr>
		<tr id="errorTRId" style="display: none;">
			<td colspan='2' id="errorTdId"></td>
		</tr>
		<tr>
			<td>FirstName <font color="red">*</font></td>
			<td><input type='text' name='firstname'
				value='<%=personalInfo.getFirstName()%>'></td>
		</tr>
		<tr>
			<td>MiddleName <font color="red">*</font></td>
			<td><input type='text' name='middlename'
				value='<%= personalInfo.getMiddleName()%>'></td>
		</tr>
		<tr>
			<td>LastName <font color="red">*</font></td>
			<td><input type='text' name='lastname'
				value='<%= personalInfo.getLastName()%>'></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><html:submit value="save" />
		</tr>
	</table>
</html:form>

