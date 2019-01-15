<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form:form modelAttribute="recipe" method="post">

            <form:hidden path="id"></form:hidden>
            <label>Nazwa dania:</label><br>
            <form:input path="title"/><br>
            <form:errors path="title"/><br>

            <label>Rodzaj posiłku:</label><br>
            <form:select path="mealType">
                <form:option value="" label="--Wybierz--"/>
                <form:options items="${mealtypes}"/>
            </form:select><br>
            <form:errors path="mealType"/><br>

            <label>Sposób przygotowania:</label><br>
            <form:textarea path="description"/><br>
            <form:errors path="description"/><br>

            <label>Pora dnia:</label><br>
            <form:select path="timeOfDay">
                <form:option value="" label="--Wybierz--"/>
                <form:options items="${timeofdays}"/>
            </form:select><br>
            <form:errors path="timeOfDay"/><br>

            <label>Dieta:</label><br>
            <form:checkboxes items="${diets}" path="diet" /><br>

            <input type="submit" value="Dodaj składniki"/>
        </form:form>
    </div>
</body>
</html>
