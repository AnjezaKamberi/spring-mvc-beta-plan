<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login/Register</title>
</head>
<body>

<!-- Register Form -->
<form:form method="post" action="/register" modelAttribute="newUser">
    <form:label path="username">Username:</form:label>
    <form:input path="username" />
    <form:errors path="username" />
    <br/>

    <form:label path="email">Email:</form:label>
    <form:input path="email" />
    <form:errors path="email" />
    <br/>

    <form:label path="password">Password:</form:label>
    <form:input type="password" path="password" />
    <form:errors path="password" />
    <br/>

    <form:label path="confirm">Confirm Password:</form:label>
    <form:input type="password" path="confirm" />
    <form:errors path="confirm" />
    <br/>

    <button type="submit">Register</button>
</form:form>

<!-- Login Form -->
<form:form method="post" action="/login" modelAttribute="newLogin">
    <form:label path="email">Email:</form:label>
    <form:input path="email" />
    <form:errors path="email" />
    <br/>

    <form:label path="password">Password:</form:label>
    <form:input type="password" path="password" />
    <form:errors path="password" />
    <br/>

    <button type="submit">Login</button>
</form:form>

</body>
</html>
