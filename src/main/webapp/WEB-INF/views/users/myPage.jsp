<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="buttons">
    <a href="/recipe/add"><button>Dodaj przepis</button></a>
    <%--<a href="/user/login"><button>Moje przepisy</button></a>--%>
    <%--<a href="/user/login"><button>Moje przepisy</button></a>--%>
</div>

<div class="container">
    <h3>Moje przepisy:</h3>
    <table class="table table-striped">
        <c:forEach items="${recipes}" var="recipe">
            <tr>
                <td>${recipe.title}</td>
                <td>${recipe.description}</td>
                <td>
                    <a href = "<c:url value = "/recipe/show/${recipe.getId()}"/>">Zobacz</a>
                    <a href = "<c:url value = "/recipe/delete/${recipe.getId()}"/>">Usuń</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
    </table>
</div>
</body>
</html>
