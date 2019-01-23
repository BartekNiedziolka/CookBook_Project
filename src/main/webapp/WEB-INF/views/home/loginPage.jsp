<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,300" rel="stylesheet" type="text/css">
</head>
<body class="body-home">
<div class="login">
<form:form modelAttribute="user" method="post" name="f">

    <h1 class="login-title">Logowanie</h1>
    <div style="margin-bottom: 1px" class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        <input type="text" name="userName" placeholder="login" class="login-input">
    </div>

    <div style="margin-bottom: 1px" class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    <input type="password" name="password" placeholder="password" class="login-input">
    </div>

    <div style="margin-top: 10px" class="form-group">
        <div class="col-sm-6 controls">
            <button type="submit" class="login-button">Zaloguj się</button>
        </div>
    </div>
</form:form>
</div>
</body>
</html>
