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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>

<form:form method="post" action="/product/create" modelAttribute="product">
    <form:label path="name">Name:</form:label>
    <form:input type="text" path="name"/>
    <form:errors path="name"/> <br/>
    <form:label path="description">Description:</form:label>
    <form:input type="text" path="description"/>
    <form:errors path="description"/><br/>
    <form:label path="quantity">Quantity:</form:label>
    <form:input type="number" path="quantity"/>
    <form:errors path="quantity"/> <br/>

    <!-- Category Selection -->
    <form:label path="category.id">Category:</form:label>
    <form:select path="category.id">
        <form:option value="" label="Select Category"/>
        <c:forEach var="category" items="${categories}">
            <form:option value="${category.id}" label="${category.name}"/>
        </c:forEach>
    </form:select>
    <form:errors path="category.id"/> <br/>

    <!-- Product Details: Description -->
    <h2>Product Details</h2>
    <form:label path="productDetails.description">DEscription:</form:label>
    <form:input type="text" path="productDetails.description"/>
    <form:errors path="productDetails.description"/> <br/>

    <!-- Product Details: Manufacturer -->
    <form:label path="productDetails.manufacturer">Manufacturer:</form:label>
    <form:input type="text" path="productDetails.manufacturer"/>
    <form:errors path="productDetails.manufacturer"/> <br/>

    <!-- Product Details: Warranty Period -->
    <form:label path="productDetails.warrantyPeriod">Warranty Period:</form:label>
    <form:input type="text" path="productDetails.warrantyPeriod"/>
    <form:errors path="productDetails.warrantyPeriod"/> <br/>
    <button>Add new product</button>

</form:form>

</body>
</html>
