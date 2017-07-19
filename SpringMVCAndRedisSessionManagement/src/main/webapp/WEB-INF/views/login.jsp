<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>login</title>
</head>
<body>
	<h1>login</h1>

	<form action="/sample/process" method="post">
		<input type="text" name="username" /><br /> <input type="password"
			name="password" /> <br />
		<input type="submit" value="login" />
	</form>


</body>
</html>
