
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="body-mypage">
<div class="center">
    <h2>
        Składniki:
    </h2>
    <div class="center text-left">
    <ul>
        <c:forEach items="${quantityComponents}" var="component">
            <li>
                    ${component.component.name}
                    ${component.getQuantity()} ${component.getUnitOfMeasurement()}
            </li>
        </c:forEach>
    </ul>
    </div>
    <a href = "<c:url value = "/component/add/${recipe.getId()}"/>"><button class="edit-button">Edytuj</button></a>
</div>
<div class="center ">
    <h2>
        <c:out value="${recipe.title}"/>
    </h2>
    <div class="center text-left">
    <ul>
        <c:if test="${not empty recipe.mealType}">
            <li><c:out value="${recipe.mealType}"/></li>
        </c:if>
        <c:if test="${not empty recipe.timeOfDay}">
            <li><c:out value="${recipe.timeOfDay}"/></li>
        </c:if>
        <c:if test="${not empty recipe.country}">
            <li><c:out value="${recipe.country}"/></li>
        </c:if>
        <c:if test="${not empty recipe.diet}">
            <li><c:out value="${recipe.diet}"/></li>
        </c:if>
    </ul>
    </div>
    <div class="margin-left-right">
    <p class="">
        <c:out value="${recipe.description}"/>
    </p>
    </div>
    <c:if test="${not empty recipe.signature}">
        <c:out value="${recipe.signature}"/>
    </c:if>
    <a href = "<c:url value = "/recipe/edit/${recipe.getId()}"/>"><button class="edit-button">Edytuj</button></a>
</div>
<div class="div-button-mypage">
<a href = "<c:url value = "/user/main"/>"><button class="button-mypage">Strona główna</button></a>
</div>
<div class="bacground-div"></div>
</body>
</html>
