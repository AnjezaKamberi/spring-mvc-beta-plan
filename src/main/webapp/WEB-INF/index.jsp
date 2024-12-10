<%--
  Created by IntelliJ IDEA.
  User: ankamberi
  Date: 12/2/2024
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>List of Products</title>
</head>
<body>
<a href="/product/new">Add new product</a>
<table border="1">
    <thead>
    <th>NAME</th>
    <th>DESCRIPTION</th>
    <th>QUANTITY</th>
    <th>CATEGORY</th>
    <th>DETAILS</th>
    <th>ACTIONS</th>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><a href="/product/${product.id}"><c:out value="${product.name}"/></a></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.quantity}"/></td>
            <td><c:out value="${product.category.name}"/></td>
            <td>
                <c:if test="${product.productDetails != null}">
                    <strong>Manufacturer:</strong> <c:out value="${product.productDetails.manufacturer}"/><br/>
                    <strong>Warranty:</strong> <c:out value="${product.productDetails.warrantyPeriod}"/><br/>
                </c:if>
            </td>
            <td><a href="/product/edit/${product.id}">Update</a> <a href="/product/delete/${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
