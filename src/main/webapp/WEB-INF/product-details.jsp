<%--
  Created by IntelliJ IDEA.
  User: ankamberi
  Date: 12/3/2024
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>

name:<c:out value="${product.name}"/>
description:<c:out value="${product.description}"/>
quantity:<c:out value="${product.quantity}"/>
<a href="/all-products">Go Back</a>

<form:form method="post" action="/product/update/${product.id}" modelAttribute="product">
    <input type="hidden" name="_method" value="put">
    <form:hidden path="name" />
    <form:hidden path="description" />
    <form:hidden path="quantity" />
    <form:hidden path="category" />
    <div>
        <label for="reviews[${product.reviews.size()}].star">Star Rating:</label>
        <form:input path="reviews[${product.reviews.size()}].star" type="number" min="1" max="5" id="star"/>
    </div>
    <div>
        <label for="reviews[${product.reviews.size()}].comment">Comment:</label>
        <form:textarea path="reviews[${product.reviews.size()}].comment" id="comment" rows="4" cols="50"></form:textarea>
    </div>
    <div>
        <button type="submit">Submit Review</button>
    </div>
</form:form>

<form:form modelAttribute="review" method="post" action="/product/${product.id}/review/add">
    <div>
        <label for="star">Star Rating:</label>
        <form:input path="star" type="number" min="1" max="5" id="star"/>
    </div>
    <div>
        <label for="comment">Comment:</label>
        <form:textarea path="comment" id="comment" rows="4" cols="50"></form:textarea>
    </div>
    <div>
        <button type="submit">Submit Review</button>
    </div>
</form:form>
<%--<form:form method="post" action="/product/update/${product.id}" modelAttribute="product">--%>
<%--    <input type="hidden" name="_method" value="put">--%>
<%--    <form:hidden path="name" />--%>
<%--    <form:hidden path="description" />--%>
<%--    <form:hidden path="quantity" />--%>
<%--    <form:hidden path="category" />--%>
<%--    <div>--%>
<%--        <label for="reviews[${product.reviews.size()}].star">Star Rating:</label>--%>
<%--        <form:input path="reviews[${product.reviews.size()}].star" type="number" min="1" max="5" id="star"/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <label for="reviews[${product.reviews.size()}].comment">Comment:</label>--%>
<%--        <form:textarea path="reviews[${product.reviews.size()}].comment" id="comment" rows="4" cols="50"></form:textarea>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <button type="submit">Submit Review</button>--%>
<%--    </div>--%>
<%--</form:form>--%>
</body>
</html>
