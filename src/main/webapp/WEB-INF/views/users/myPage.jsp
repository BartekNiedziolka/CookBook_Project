<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="body-mypage">

<div class="center container">
    <a href="/recipe/add"><button class="button-home">Dodaj przepis</button></a>
    <%--<a href="/user/login"><button>Moje przepisy</button></a>--%>
    <%--<a href="/user/login"><button>Moje przepisy</button></a>--%>
</div>

<div class="center">
    <div class="table-center form-group font-center">
        <h3>Moje przepisy:</h3>
        <table class="table table-condensed form-group">
            <thead>
            <tr>
                <th>Nazwa</th>
                <th class="font-center">Typ</th>
                <th class="font-center">Zobacz</th>
                <th class="font-center">Usuń</th>
            </tr>
            </thead>
        <c:forEach items="${recipes}" var="recipe">
            <tr>
                <td>${recipe.title}</td>
                <td class="font-center">${recipe.timeOfDay}</td>
                <td class="font-center">
                    <a href = "<c:url value = "/recipe/show/${recipe.getId()}"/>"><button class="edit-button">Zobacz</button></a>
                </td>
                <td class="font-center">
                    <a href = "<c:url value = "/recipe/delete/${recipe.getId()}"/>"><button class="edit-button">Usuń</button></a>
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
