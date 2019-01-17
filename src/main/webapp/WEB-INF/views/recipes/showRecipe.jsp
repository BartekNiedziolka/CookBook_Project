
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <p>
        Składniki:
    </p>
    <table class="table table-bordered">
        <c:forEach items="${quantityComponents}" var="component">
            <tr>
                <td>${component.component.name}</td>
                <td>${component.getQuantity()} ${component.getUnitOfMeasurement()}</td>
            </tr>
        </c:forEach>
        <tr>
    </table>
    <a href = "<c:url value = "/component/add/${recipe.getId()}"/>">Edytuj</a>
</div>
<div class="container">
    <h2>
        <c:out value="${recipe.title}"/>
    </h2>
    <ul>
        <li><c:out value="${recipe.mealType}"/></li>
        <li><c:out value="${recipe.timeOfDay}"/></li>
        <li><c:out value="${recipe.country}"/></li>
        <li><c:out value="${recipe.diet}"/></li>
    </ul><br>
    <p>
        <c:out value="${recipe.description}"/>
    </p><br>
    <c:out value="${recipe.signature}"/>
    <a href = "<c:url value = "/recipe/edit/${recipe.getId()}"/>">Edytuj</a>
</div>
</body>
</html>
