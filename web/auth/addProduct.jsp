<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New product</title>
</head>
<body>
<%@ include file="/templates/header.jsp" %>
<h1>New product</h1>

<form action="<%= application.getContextPath() %>/auth/addProduct" method="POST">
    <label for="name">Name : </label>
    <input type="text" id="name" name="name"/><br/>
    <label for="content">Content : </label> <br/>
    <textarea id="content" name="content"></textarea><br/>
    <label for="price">Price : </label>
    <input type="number" id="price" name="price"/><br/>
    <input type="submit"/>
</form>
<%@ include file="/templates/footer.jsp" %>
</body>
</html>