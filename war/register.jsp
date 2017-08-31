<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Employee</title>
</head>
<body>
	<div style="padding-left: 100px; font-family: monospace;">
		<h2>Create Employee</h2>
		<form action="rest/WebService/add" method="post">
			<div style="width: 200px; text-align: left;">
				<div style="padding: 10px;">
					Name: <input name="name" id="name" />
				</div>
				<div style="padding: 10px;">
					Phone: <input name="phone" id="phone" />
				</div>
				<div style="padding: 10px;">
					Email: <input name="email" email="email" />
				</div>
				<div style="padding: 10px; text-align: center">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>