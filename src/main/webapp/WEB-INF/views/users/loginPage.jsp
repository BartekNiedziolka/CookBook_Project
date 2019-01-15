<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="user" method="post">

    <form:hidden path="id"></form:hidden>
    <label>Email:</label><br>
    <form:input path="email"/><br>
    <form:errors path="email"/><br>

    <label>Hasło:</label><br>
    <form:password path="password"/><br>
    <form:errors path="password"/><br>

    <input type="submit" value="Zaloguj się"/>
</form:form>
</body>
</html>
