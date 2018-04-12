<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1>Message : ${welcomeMessage}</h1>
<br>

<h1>Get <a href="<c:url value="/adminPage" />">Admin</a>  Page</h1>
<h1>Get <a href="<c:url value="/userPage" />">User</a>  Page</h1>
</body>
</html>