<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>EditBook</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <form action="index" method="post" id="allBooks">
                <input type="hidden" name="action" value="getAllBookAdmin">
                <a class="nav-link" href="#" onclick="document.getElementById('allBooks').submit(); return false;">All books<span class="sr-only">(current)</span></a>
            </form>
        </li>
        <li>
            <form action="index" method="post" id="toAddNewBook">
                <input type="hidden" name="action" value="toAddNewBook">
                <a class="nav-link" href="#" onclick="document.getElementById('toAddNewBook').submit(); return false;">Add new book</a>
            </form>
        </li>
        <li>
            <form action="index" method="post" id="toAllUsers">
                <input type="hidden" name="action" value="toAllUsers">
                <a class="nav-link" href="#" onclick="document.getElementById('toAllUsers').submit(); return false;">Users</a>
            </form>
        </li>
        <li>
            <form action="index" method="post" id="toAllAuthors">
                <input type="hidden" name="action" value="toAllAuthors">
                <a class="nav-link" href="#" onclick="document.getElementById('toAllAuthors').submit(); return false;">Authors</a>
            </form>
        </li>
        <li>
            <form action="index" method="post" id="toAllGenres">
                <input type="hidden" name="action" value="toAllGenres">
                <a class="nav-link" href="#" onclick="document.getElementById('toAllGenres').submit(); return false;">Genres</a>
            </form>
        </li>
    </ul>
</div>
</nav>

    <div class="container-fluid h-100">
        <div class="row  align-items-center justify-content-center h-100">
        <div class="row align-items-center justify-content-center">
            <div class="col">
                <div class="row align-items-center justify-content-center">
                    <div class="col">
                        <img src="${book.getImagePath()}">
                    </div>
                </div>
                <form action="index" method="post" enctype="multipart/form-data">
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="file" name="file">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="hidden" name="action" value="editBook">
                            <input type="hidden" name="id" value="${book.getId()}">
                            <input type="text" name="name" value="${book.getName()}">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="text" name="pageCount" value="${book.getPageCount()}">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="text" name="isbn" value="${book.getiSBN()}">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="text" name="publisher" value="${book.getPublisher()}">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="submit" name="Изменить">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
</body>
</html>
