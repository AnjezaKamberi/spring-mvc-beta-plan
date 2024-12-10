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
</body>
</html>
