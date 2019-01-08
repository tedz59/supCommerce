<%@page import="com.supinfo.sun.supcommerce.doa.SupProductDao" %>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product list</title>
</head>
<body>
<%@ include file="/templates/header.jsp" %>
<h1>Product list</h1>

<ul>
    <% for (SupProduct product : SupProductDao.getAllProducts()) { %>
    <li>
        <h2><%= product.getName() %></h2>
        <%= product.getContent() %> - <%= product.getPrice() %> euros
        <a href="showProduct.jsp?id=<%= product.getId() %>">show details</a>
        <a href="<%=request.getContextPath()%>/auth/deleteProduct?id=<%= product.getId() %>">Delete</a>
    </li>
    <% } %>
</ul>

<%@ include file="/templates/footer.jsp" %>
</body>
</html>