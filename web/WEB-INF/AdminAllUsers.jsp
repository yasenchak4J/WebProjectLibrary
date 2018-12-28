<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
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
        </ul>
        <form class="form-inline my-2 my-lg-0" action="index">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" name="textSearch" aria-label="Search">
            <input type="hidden" name="action" value="searchAdmin">
            <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search">
        </form>
    </div>
</nav>

<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Login</th>
        <th scope="col">Role</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <c:if test="${user.getRole() == 0}">
            <tr>
                <td>${user.getUserId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getRole()}</td>
                <td></td>
            </tr>
        </c:if>
        <c:if test="${user.getRole() == 1}">

            <tr>
                <td>${user.getUserId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getRole()}</td>
                <td>
                    <div class="btn-group dropright">
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Action
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <form action="index" method="post" id="changeRoleToLibrarian ${user.getUserId()}">
                                <input type="hidden" name="action" value="changeRole">
                                <input type="hidden" name="newRole" value="2">
                                <input type="hidden" name="id" value="${user.getUserId()}">
                                <a class="dropdown-item" href="#" onclick="document.getElementById('changeRoleToLibrarian ${user.getUserId()}').submit(); return false;">Change role to librarian</a>
                            </form>
                            <form action="index" method="post" id="deleteUserRoleUser ${user.getUserId()}">
                                <input type="hidden" name="action" value="deleteUser">
                                <input type="hidden" name="id" value="${user.getUserId()}">
                                <a class="dropdown-item" href="#" onclick="document.getElementById('deleteUserRoleUser ${user.getUserId()}').submit(); return false;">Delete user</a>
                            </form>
                        </div>
                    </div>
                </td>
            </tr>
        </c:if>

        <c:if test="${user.getRole() == 2}">

            <tr>
                <td>${user.getUserId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getRole()}</td>
                <td>
                    <div class="btn-group dropright">
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Action
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <form action="index" method="post" id="changeRoleToUser ${user.getUserId()}">
                                <input type="hidden" name="action" value="changeRole">
                                <input type="hidden" name="newRole" value="1">
                                <input type="hidden" name="id" value="${user.getUserId()}">
                                <a class="dropdown-item" href="#" onclick="document.getElementById('changeRoleToUser ${user.getUserId()}').submit(); return false;">Change role to user</a>
                            </form>
                            <form action="index" method="post" id="deleteUser ${user.getUserId()}">
                                <input type="hidden" name="action" value="deleteUser">
                                <input type="hidden" name="id" value="${user.getUserId()}">
                                <a class="dropdown-item" href="#" onclick="document.getElementById('deleteUser ${user.getUserId()}').submit(); return false;">Delete user</a>
                            </form>
                        </div>
                    </div>
                </td>
            </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
