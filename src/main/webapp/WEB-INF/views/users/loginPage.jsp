<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,300" rel="stylesheet" type="text/css">
</head>
<body>
<form:form modelAttribute="user" method="post" class="login" name="f">

    <h1 class="login-title">Logowanie</h1>
    <div class="form-group">
        <div class="col-xs-15">
            <div>
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                        Invalid username or password
                    </div>
                </c:if>
            </div>
        </div>
    </div>
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
</body>
</html>
