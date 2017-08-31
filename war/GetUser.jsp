<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GetUser</title>
</head>
<body>

	<div style="padding-left: 100px; font-family: monospace;">
		<h2>Get Employee</h2>
		<form action="rest/WebService/getuser" method="post">
			<div style="width: 200px; text-align: left;">
				<div style="padding: 10px;">
					Enter User id: <input name="userid" id="userid" />
				</div>
				<div style="padding: 10px;">
					Enter Auth Token : <input name="authtoken" id="authtoken" />
				</div>
				<div style="padding: 10px; text-align: center">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
</body>
</html>