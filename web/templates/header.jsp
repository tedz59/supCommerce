<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="listProduct" var="listProductUrl"/>
<c:url value="/auth/addProduct.jsp" var="addProductUrl"/>
<c:url value="logout" var="logoutUrl"/>
<c:url value="login.html" var="loginUrl"/>
<p>
    <a href="${listProductUrl}">Product List</a> |

    <c:choose>
        <c:when test="${not empty sessionScope.get('username')}">
            <a href="${addProductUrl}">New product</a> |
            <a href="${logoutUrl}">Logout</a>
        </c:when>
        <c:otherwise>
            <a href="${loginUrl}">Login</a>
        </c:otherwise>
    </c:choose>
</p>