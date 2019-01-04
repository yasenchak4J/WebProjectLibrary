<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Add new book</title>
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
                    <a class="nav-link" href="#" onclick="document.getElementById('allBooks').submit(); return false;">All books</a>
                </form>
            </li>
            <li>
                <form action="index" method="post" id="toAddNewBook">
                    <input type="hidden" name="action" value="toAddNewBook">
                    <a class="nav-link" href="#" onclick="document.getElementById('toAddNewBook').submit(); return false;">Add new book<span class="sr-only">(current)</span></a>
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
    <div class="row align-items-center justify-content-center h-100">
        <div class="col-md-auto">
            <form action="index" method="post" enctype="multipart/form-data">
                <div class="custom-file">
                    <input type="file" name="file" class="custom-file-input" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose book image</label>
                </div>
                <input type="hidden" name="action" value="addNewBook">
                <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Book name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="name" id="inputEmail3" placeholder="Book name">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Pages count</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputPassword3" name="pageCount" placeholder="Pages count">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="firstName" class="col-sm-2 col-form-label">ISBN</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="isbn" id="firstName" placeholder="ISBN">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lastName" class="col-sm-2 col-form-label">Publisher</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Publisher">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">Add new book</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
