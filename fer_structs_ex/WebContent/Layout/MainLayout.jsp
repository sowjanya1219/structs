<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>

<head>
<title></title>
<script type="text/javascript">
	function submitForm(urlaction) {
		var form = document.form[0];
		form.action = urlaction;
		form.submit();
	}
</script>
</head>
<body>
	<table width='600px' height='600px' border='2' align='center'>
		<tr height='100px'>
			<td colspan="2"><tiles:insert attribute="header" /></td>
		</tr>

		<tr height='200px'>
			<td width="200px"><tiles:insert attribute="leftFrame" /></td>
			<td width='600px' align='center'><tiles:insert attribute="body" /></td>
		</tr>

		
		<tr height='100px' align='center'>
			<td colspan="2"><tiles:insert attribute="Footer" /></td>
			
		</tr>



	</table>

</body>
</html>