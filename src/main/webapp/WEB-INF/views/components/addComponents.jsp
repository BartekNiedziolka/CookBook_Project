<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <th scope = "row">
        Składniki:
    </th>
        <c:forEach items="${quantityComponent.recipe.quantityComponents}" var="component">
            <tr>
                <td>${component.component.name}</td>
                <td>${component.getQuantity()}</td>
                <td>${component.getUnitOfMeasurement()}</td>
                <td><a href = "<c:url value = "/component/edit/${component.getId()}"/>">Edytuj</a></td>
                <td><a href = "<c:url value = "/component/delete/${component.getId()}"/>">Usuń</a></td>
            </tr>
        </c:forEach>
    <tr>
</table>
<div>
    <form:form modelAttribute="quantityComponent" method="post">
        <form:hidden path="recipe.id" />
        <form:select path="name">
            <form:option value="" label="wybierz" />
            <form:options items="${nameComponents}"/>
        </form:select>
        <form:input path="quantity"/>
        <form:select path="unitOfMeasurement">
            <form:option value="" label="wybierz" />
            <form:options items="${units}"/>
        </form:select>
        <input type="submit" value="Dodaj"/><br>
    </form:form>
</div>
</body>
</html>
