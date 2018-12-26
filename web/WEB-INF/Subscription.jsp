<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid h-100">
        <div class="row align-items-center justify-content-center h-100">
            <div class="col-md-auto">
                <div class="row">
                    <div class="col"><img src="${book.getImagePath()}" width="100" height="125"></div>
                </div>
                <div class="row">
                    <div class="col">Наименование: <c:out value="${book.getName()}"/></div>
                </div>
                <div class="row">
                    <div class="col">Количество страниц: <c:out value="${book.getPageCount()}"/> </div>
                </div>
                <div class="row">
                    <div class="col">ISBN: <c:out value="${book.getiSBN()}"/> </div>
                </div>
                <div class="row">
                    <div class="col">Издатель: <c:out value="${book.getPublisher()}"/> </div>
                </div>
                <div class="row">
                    <div class="col">Жанр: <c:out value="${book.getGenres().getName()}"/> </div>
                </div>
                <div class="row">
                    <div class="col">Автор: <c:out value="${book.getAuthors().getNameAndSurname()}"/> </div>
                </div>
                <div class="row">
                    <div class="col">
                        <form action="index" id="addToSubsHall" method="post">
                            <input type="hidden" name="action" value="addToSubs">
                            <input type="hidden" name="type" value="inHall">
                            <input type="hidden" name="book" value="${book.getId()}">
                            <a class="nav-link" href="#" onclick="document.getElementById('addToSubs').submit(); return false;">Take in the hall</a>
                        </form>
                    </div>
                    <div class="col">
                        <form action="index" id="addToSubsHome" method="post">
                            <input type="hidden" name="action" value="addToSubs">
                            <input type="hidden" name="type" value="inHome">
                            <input type="hidden" name="book" value="${book.getId()}">
                            <a class="nav-link" href="#" onclick="document.getElementById('addToSubsHome').submit(); return false;">Take a subscription</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
