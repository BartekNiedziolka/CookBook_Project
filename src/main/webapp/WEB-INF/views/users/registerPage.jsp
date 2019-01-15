<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
<form:form modelAttribute="user" method="post">

    <form:hidden path="id"></form:hidden>
    <label>Imię:</label><br>
    <form:input path="firstName"/><br>
    <form:errors path="firstName"/><br>

    <label>Nazwisko:</label><br>
    <form:input path="lastName"/><br>
    <form:errors path="lastName"/><br>

    <label>Email:</label><br>
    <form:input path="email"/><br>
    <form:errors path="email"/><br>

    <label>Hasło:</label><br>
    <form:password path="password"/><br>
    <form:errors path="password"/><br>

    <input type="submit" value="Zarejestruj się"/>
</form:form>
</body>
</html>
