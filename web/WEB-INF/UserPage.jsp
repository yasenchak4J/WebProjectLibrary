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
                <form action="index" method="post" id="goToProfile">
                    <input type="hidden" name="action" value="goToProfile">
                    <a class="nav-link" href="#" onclick="document.getElementById('goToProfile').submit(); return false;">My profile <span class="sr-only">(current)</span></a>
                </form>
            </li>
            <li>
                <form action="index" method="post" id="goToCurrentSubs">
                    <input type="hidden" name="action" value="goToCurrentSubs">
                    <a class="nav-link" href="#" onclick="document.getElementById('goToCurrentSubs').submit(); return false;">Current subscription</a>
                </form>
            </li>
            <li>
                <form action="index" method="post" id="toAllUsers">
                    <input type="hidden" name="action" value="toAllUsers">
                    <a class="nav-link" href="#" onclick="document.getElementById('toAllUsers').submit(); return false;">Users</a>
                </form>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col">Profile photo</div>
        <div class="col">
            <div class="row">
                <div class="col">Login: ${user.getName()}</div>
            </div>
            <div class="row">
                <div class="col">Name: ${user.getFirstName()}</div>
            </div>
            <div class="row">
                <div class="col">Surname: ${user.getLastName()}</div>
            </div>
            <div class="row">
                <div class="col">Gender: ${user.getGender()}</div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <table class="table table-hover table-dark">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Book name</th>
                    <th scope="col">Book ISBN</th>
                    <th scope="col">Type</th>
                    <th scope="col">DateIn</th>
                    <th scope="col">DateOut</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="subs" items="${currentUserSubs}">
                    <c:if test="${subs.equalsDate() == false}">
                        <tr>
                            <td>${subs.getId()}</td>
                            <td>${subs.getBookName()}</td>
                            <td>${subs.getIsbn()}</td>
                            <td>${subs.getType()}</td>
                            <td>${subs.getDateIn()}</td>
                            <td>${subs.getDateOut()}</td>
                        </tr>
                    </c:if>

                    <c:if test="${subs.equalsDate() == true}">
                        <tr class="bg-danger">
                            <td>${subs.getId()}</td>
                            <td>${subs.getUserName()}</td>
                            <td>${subs.getBookName()}</td>
                            <td>${subs.getIsbn()}</td>
                            <td>${subs.getType()}</td>
                            <td>${subs.getDateIn()}</td>
                            <td>${subs.getDateOut()}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
