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
    <title>Update product</title>
</head>
<body>

<form:form method="post" action="/product/update/${product.id}" modelAttribute="product">
    <input type="hidden" name="_method" value="put">
    <form:label path="name">Name:</form:label>
    <form:input type="text" path="name"/>
    <form:errors path="name"/> <br/>
    <form:label path="description">Description:</form:label>
    <form:input type="text" path="description"/>
    <form:errors path="description"/><br/>
    <form:label path="quantity">Quantity:</form:label>
    <form:input type="number" path="quantity"/>
    <form:errors path="quantity"/> <br/>
    <button>Update product</button>

</form:form>

</body>
</html>
