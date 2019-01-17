<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="body-mypage">

<div class="center container">
    <a href="/recipe/add"><button class="button-home">Dodaj przepis</button></a>
    <%--<a href="/user/login"><button>Moje przepisy</button></a>--%>
    <%--<a href="/user/login"><button>Moje przepisy</button></a>--%>
</div>

<div class="center">
    <h3>Moje przepisy:</h3>
    <div class="table-center">
        <table class="table table-condensed">
            <thead>
            <tr>
                <th>Nazwa</th>
                <th>Typ</th>
                <th>Zobacz</th>
                <th>Usuń</th>
            </tr>
            </thead>
        <c:forEach items="${recipes}" var="recipe">
            <tr>
                <td>${recipe.title}</td>
                <td>${recipe.timeOfDay}</td>
                <td>
                    <a href = "<c:url value = "/recipe/show/${recipe.getId()}"/>">Zobacz</a>
                </td>
                <td>
                    <a href = "<c:url value = "/recipe/delete/${recipe.getId()}"/>">Usuń</a>
                </td>
            </tr>
        </c:forEach>
        </table>
    </div>
</div>
</div>
<div class="bacground-div">

</div>
</body>
</html>
