<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,300" rel="stylesheet" type="text/css">

    <link href="<c:url value="/resources/css/form.css" />" rel="stylesheet" type="text/css">

<body class="body-form">
<ul id="list" class="text-left">
    <h4>Składniki:</h4>
            <c:forEach items="${quantityComponent.recipe.quantityComponents}" var="component">
                <li>
                    ${component.component.name}
                    ${component.getQuantity()}
                    ${component.getUnitOfMeasurement()}
                    <a href = "<c:url value = "/component/delete/${component.getId()}/${component.recipe.getId()}"/>"><button class="delete-button">x</button></a>
                </li>
            </c:forEach>
</ul>
    <form:form modelAttribute="quantityComponent" method="post" cssClass="form">
        <h1 class="login-title">Dodaj składnik</h1>
        <form:hidden path="recipe.id" />
        <label>Produkt:</label><br>
        <form:select path="name">
            <form:option value="" label="--Wybierz--" />
            <form:options items="${nameComponents}"/>
        </form:select><br>
        <form:errors path="name"/>
        <label>Ilość:</label><br>
        <form:input path="quantity" placeholder ="Wprowadź liczbę"/>
        <form:errors path="quantity"/>
        <label>Jednostka:</label><br>
        <form:select path="unitOfMeasurement">
            <form:option value="" label="--Wybierz--" />
            <form:options items="${units}"/>
        </form:select><br>
        <form:errors path="unitOfMeasurement"/>
        <button type="submit">Dodaj</button>
    </form:form>
<div class="center">
    <div class="center">
    <a href="/user/main"><button class="buttons">Zakończ</button></a>
    </div>
</div>
</body>
</html>
