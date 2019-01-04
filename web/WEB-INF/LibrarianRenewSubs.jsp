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
                <form action="index" method="post" id="goToAllUncSubs">
                    <input type="hidden" name="action" value="goToAllUncSubs">
                    <a class="nav-link" href="#" onclick="document.getElementById('goToAllUncSubs').submit(); return false;">Unconfirmed subscriptions</a>
                </form>
            </li>
            <li>
                <form action="index" method="post" id="goToCurrentSubs">
                    <input type="hidden" name="action" value="goToCurrentSubs">
                    <a class="nav-link" href="#" onclick="document.getElementById('goToCurrentSubs').submit(); return false;">Current subscriptions<span class="sr-only">(current)</span></a>
                </form>
            </li>
            <li>
                <form action="index" method="post" id="goToRenewSubs">
                    <input type="hidden" name="action" value="goToRenewSubs">
                    <a class="nav-link" href="#" onclick="document.getElementById('goToRenewSubs').submit(); return false;">Request for renew subscriptions</a>
                </form>
            </li>
        </ul>
    </div>
</nav>

<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">User name</th>
        <th scope="col">Book name</th>
        <th scope="col">Book ISBN</th>
        <th scope="col">Type</th>
        <th scope="col">DateIn</th>
        <th scope="col">DateOut</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="subs" items="${renewSubs}">
        <c:if test="${subs.equalsDate() == false}">
            <tr>
                <td>${subs.getId()}</td>
                <td>${subs.getUserName()}</td>
                <td>${subs.getBookName()}</td>
                <td>${subs.getIsbn()}</td>
                <td>${subs.getType()}</td>
                <td>${subs.getDateIn()}</td>
                <td>${subs.getDateOut()}</td>
                <td>
                    <div class="btn-group dropright">
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Action
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <form action="index" method="post" id="agreeRenew ${subs.getId()}">
                                <input type="hidden" name="action" value="toAgreeRenew">
                                <input type="hidden" name="id" value="${subs.getId()}">
                                <a class="dropdown-item" href="#" onclick="document.getElementById('agreeRenew ${subs.getId()}').submit(); return false;">Agree renew</a>
                            </form>
                            <form action="index" method="post" id="rejectRenew ${subs.getId()}">
                                <input type="hidden" name="action" value="rejectRenew">
                                <input type="hidden" name="id" value="${subs.getId()}">
                                <a class="dropdown-item" href="#" onclick="document.getElementById('rejectRenew ${subs.getId()}').submit(); return false;">Reject renew</a>
                            </form>
                        </div>
                    </div>
                </td>
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
                <td>
                    <div class="btn-group dropright">
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Action
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <form action="index" method="post" id="agreeRenew ${subs.getId()}">
                                <input type="hidden" name="action" value="toAgreeRenew">
                                <input type="hidden" name="id" value="${subs.getId()}">
                                <a class="dropdown-item" href="#" onclick="document.getElementById('agreeRenew ${subs.getId()}').submit(); return false;">Agree renew</a>
                            </form>
                            <form action="index" method="post" id="rejectRenew ${subs.getId()}">
                                <input type="hidden" name="action" value="rejectRenew">
                                <input type="hidden" name="id" value="${subs.getId()}">
                                <a class="dropdown-item" href="#" onclick="document.getElementById('rejectRenew ${subs.getId()}').submit(); return false;">Reject renew</a>
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
