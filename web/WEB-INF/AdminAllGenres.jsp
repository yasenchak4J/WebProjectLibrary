<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <form action="index" method="post" id="goToMainPage">
        <input type="hidden" name="action" value="getAllBook">
        <a class="navbar-brand" href="#" onclick="document.getElementById('goToMainPage').submit(); return false;">Library</a>
    </form>

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
        <form class="form-inline my-2 my-lg-0" action="index">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" name="textSearch" aria-label="Search">
            <input type="hidden" name="action" value="searchAdmin">
            <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search">
        </form>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col">
            <table class="table table-hover table-dark">
                <thead>
                <tr>
                    <th scope="col">Genre name</th>
                    <th scope="col">
                        <form action="index" method="post">
                            <input type="hidden" name="action" value="toAddNewGenre">
                            <button type="submit" class="btn btn-primary">Add new genre</button>
                        </form>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="genre" items="${genres}">
                    <tr>
                        <td>${genre.getName()}</td>
                        <td>
                            <div class="btn-group dropright">
                                <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Action
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                    <form action="index" method="post" id="changeRoleToLibrarian ${genre.getId()}">
                                        <input type="hidden" name="action" value="toChangeGenre">
                                        <input type="hidden" name="id" value="${genre.getId()}">
                                        <a class="dropdown-item" href="#" onclick="document.getElementById('changeRoleToLibrarian ${genre.getId()}').submit(); return false;">Change</a>
                                    </form>
                                    <form action="index" method="post" id="deleteUserRoleUser ${genre.getId()}">
                                        <input type="hidden" name="action" value="deleteGenre">
                                        <input type="hidden" name="id" value="${genre.getId()}">
                                        <a class="dropdown-item" href="#" onclick="document.getElementById('deleteUserRoleUser ${genre.getId()}').submit(); return false;">Delete</a>
                                    </form>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <c:if test="${changeGenre != null}">
            <div class="col">
                <form action="index" method="post">
                    <input type="hidden" name="action" value="changeGenre">
                    <input type="hidden" name="id" value="${changeGenre.getId()}">
                    <div class="form-group row">
                        <label for="inputlogin" class="col-sm-2 col-form-label">Genre name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="name" id="inputlogin" placeholder="Name" value="${changeGenre.getName()}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </c:if>

        <c:if test="${addNewGenre != null}">
            <div class="col">
                <form action="index" method="post">
                    <input type="hidden" name="action" value="addNewGenre">
                    <div class="form-group row">
                        <label for="inputlogin2" class="col-sm-2 col-form-label">Name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="name" id="inputlogin2" placeholder="Name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <button type="submit" class="btn btn-primary">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </c:if>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
