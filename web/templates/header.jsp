<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/listProduct" var="listProductUrl"/>
<c:url value="/cheaperProducts" var="cheaperProductsUrl"/>
<c:url value="/auth/addProduct" var="addProductUrl"/>
<c:url value="/auth/addCategory" var="addCategoryUrl"/>
<c:url value="/logout" var="logoutUrl"/>
<c:url value="/login" var="loginUrl"/>

Bonjour ${sessionScope.username}

<p>
    <a href="${listProductUrl}">Product List</a> |
    <a href="${cheaperProductsUrl}">Cheaper product List</a> |

    <c:choose>
        <c:when test="${not empty sessionScope.get('username')}">
            <a href="${addProductUrl}">New product</a> |
            <a href="${addCategoryUrl}">New category product</a> |
            <a href="${logoutUrl}">Logout</a>
        </c:when>
        <c:otherwise>
            <a href="${loginUrl}">Login</a>
        </c:otherwise>
    </c:choose>
</p>