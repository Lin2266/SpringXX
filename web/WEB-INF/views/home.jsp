<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
<title>Bulletin</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resource/style.css" />'/>
</head>
<body>
	<h1>Welcome to Bulletin</h1>
	<a href="<c:url value="/placards"/>">Messages</a> |
	<a href="<c:url value="/user/register"/>">Register</a>
</body>
</html>