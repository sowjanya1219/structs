<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>
 
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="color: red">
		<html:errors />
	</div>
<html:form action="/register">
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center">Registration</td>
			</tr>
			<tr>
				<td>First name</td>
				<td><html:text name="RegistrationForm" property="firstname"/></td>
			</tr>
			<tr>
				<td>Middle name</td>
				<td><html:text name="RegistrationForm" property="middlename"/></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><html:text name="RegistrationForm" property="lastname"/></td>
			</tr>
			<tr>
				<td>User name</td>
				<td><html:text name="RegistrationForm" property="username"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><html:text name="RegistrationForm" property="password"/></td>
			</tr>
			<tr>
				<td>Mobile number</td>
				<td><html:text name="RegistrationForm" property="mobile"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><html:text name="RegistrationForm" property="email"/></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</html:form>

</body>