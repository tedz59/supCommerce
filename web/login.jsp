<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
<%@ include file="/templates/header.jsp" %>
<form method="post" action="login">
    <label for="username">Username : </label>
    <input id="username" name="username"/><br/>
    <input type="submit"/>
</form>
<%@ include file="/templates/footer.jsp" %>
</body>
</html>