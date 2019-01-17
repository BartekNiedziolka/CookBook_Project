<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet" type="text/css">--%>
    <link href="<c:url value="/resources/css/form.css" />" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,300" rel="stylesheet" type="text/css">
</head>
<body class="">
<div>
        <form:form modelAttribute="recipe" method="post">

            <h1 class="login-title">Dodaj przepis</h1>

            <form:hidden path="id"></form:hidden>
            <form:hidden path="user.id"></form:hidden>
            <label>Nazwa dania:</label><br>
            <div>
            <form:input path="title" placeholder ="Nazwa dania"/><br>
            <form:errors path="title"/><br>
            </div>

            <label>Sposób przygotowania:</label><br>
            <div>
            <form:textarea path="description" placeholder ="Sposób przygotowania" style="height:200px"/><br>
            </div>
            <form:errors path="description"/><br>

            <label>Rodzaj posiłku:</label><br>
            <div>
                <form:select path="mealType">
                    <form:option value="" label="--Wybierz--"/>
                    <form:options items="${mealtypes}"/>
                </form:select><br>
            </div>
            <form:errors path="mealType"/><br>

            <label>Pora dnia:</label><br>
            <form:select path="timeOfDay">
                <form:option value="" label="--Wybierz--"/>
                <form:options items="${timeofdays}"/>
            </form:select><br>
            <form:errors path="timeOfDay"/><br>

            <label>Dieta:</label><br>
            <div>
                <form:checkboxes items="${diets}" path="diet" delimiter="<br />" />
            </div>

            <button type="submit">Dodaj</button>
        </form:form>
    </div>
</body>
</html>
