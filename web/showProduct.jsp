<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product details</title>
</head>
<body>
<%@ include file="/templates/header.jsp" %>
<h1>
    ${product.name}
</h1>
<p>
    Content : ${product.content} <br/>
    price : ${product.price} <br />
    Category : ${product.category.name}
</p>
<%@ include file="/templates/footer.jsp" %>
</body>
</html>