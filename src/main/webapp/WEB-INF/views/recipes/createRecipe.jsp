<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/form.css" />" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,300" rel="stylesheet" type="text/css">
</head>
<body class="body-form">
        <form:form modelAttribute="recipe" method="post" cssClass="form">

            <h1>Dodaj przepis</h1>

            <form:hidden path="id"></form:hidden>
            <form:hidden path="user.id"></form:hidden>
            <form:errors path="title" cssClass="error"/><br>
            <label>Nazwa dania:</label><br>
            <form:input path="title" placeholder ="Nazwa dania"/><br>

            <form:errors path="description" cssClass="error"/><br>
            <label>Sposób przygotowania:</label><br>
            <form:textarea path="description" placeholder ="Sposób przygotowania" style="height:150px"/><br>

            <form:errors path="mealType" cssClass="error"/><br>
            <label>Rodzaj posiłku:</label><br>
                <form:select path="mealType">
                    <form:option value="" label="--Wybierz--"/>
                    <form:options items="${mealtypes}"/>
                </form:select><br>

            <form:errors path="timeOfDay" cssClass="error"/><br>
            <label>Pora dnia:</label><br>
            <form:select path="timeOfDay">
                <form:option value="" label="--Wybierz--"/>
                <form:options items="${timeofdays}"/>
            </form:select><br>

            <label>Dieta:</label><br>
            <div class="text-left">
                <form:checkboxes items="${diets}" path="diet" delimiter="<br />" />
            </div>

            <button type="submit">Dodaj</button>
        </form:form>
        <div class="div-button-mypage">
            <a href = "<c:url value = "/user/main"/>"><button class="button-mypage">Strona główna</button></a>
        </div>
</body>
</html>
