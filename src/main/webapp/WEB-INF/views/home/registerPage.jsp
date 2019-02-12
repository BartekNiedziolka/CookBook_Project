<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rejestracja</title>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,300" rel="stylesheet" type="text/css">
</head>
<body class="body-home">
<form:form method="post" modelAttribute="user" class="login" name="f">
    <h1 class="login-title">Rejestracja</h1>
    <form:errors path="userName" cssClass="error"/>
    <c:if test="${not empty badLogin}">
        <div class="error">${badLogin}</div>
    </c:if>
    <form:input class="login-input" path="userName" placeholder="login"/>
    <form:errors path="email" cssClass="error"/>
    <c:if test="${not empty badEmail}">
        <div class="error">${badEmail}</div>
    </c:if>
    <form:input class="login-input" path="email" placeholder="email"/>
    <form:errors path="password" cssClass="error"/>
    <form:password class="login-input" path="password" placeholder="password"/>
    <input type="submit" value="Zarejestruj" class="login-button">
</form:form>
</body>
</html>
