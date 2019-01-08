<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product list</title>
</head>
<body>
<%@ include file="/templates/header.jsp" %>
<h1>Product list</h1>

<c:forEach items="${products}" var="product">
    <c:url var="showDetailUrl" value="showProduct">
        <c:param name="id" value="${product.id}"/>
    </c:url>
    <c:url var="deleteProductUrl" value="/auth/deleteProduct">
        <c:param name="id" value="${product.id}"/>
    </c:url>
    <ul>
        <li>
            <h2>${product.name}</h2>
                ${product.content} - ${product.price} euros
            <a href="${showDetailUrl}">show details</a>
            <c:if test="${not empty sessionScope.get('username')}">
                <a href="${deleteProductUrl}">Delete</a>
            </c:if>
        </li>
    </ul>
</c:forEach>

<%@ include file="/templates/footer.jsp" %>
</body>
</html>