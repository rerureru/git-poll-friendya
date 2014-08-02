<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>jQuery UI Tabs - Simple manipulation</title>
<script src="resources/scripts/jquery-1.11.1.js"></script>
<script src="resources/scripts/jquery-ui-1.11.0.js"></script>
<link rel="stylesheet" href="resources/stylesheets/jquery-ui.css" />
<link rel="stylesheet" href="resources/stylesheets/style.css" />
<link rel="stylesheet" href="resources/stylesheets/base.css" />
<link rel="stylesheet" href="resources/stylesheets/bootstrap.css" />
<link rel="stylesheet" href="resources/stylesheets/custom.css" />	
</head>
<body>
	<form action="j_spring_security_check" method="post">
	<label for="j_username">Login</label>:
	<input id="j_username" name="j_username" size="20" maxlength="50" type="text"/>
	<br />

	<label for="j_password">Password</label>:
	<input id="j_password" name="j_password" size="20" maxlength="50" type="password"/>
	<br />

	<input type="submit" value="Login"/>
</form>
</body>
</html>





