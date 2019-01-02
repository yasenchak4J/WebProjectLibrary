<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="messages" />

<html lang="${sessionScope.lang}">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<c:out value="${registration}"></c:out>
<c:out value="${error}"></c:out>
<div class="container-fluid h-100">
    <div class="row align-items-center justify-content-center h-100">
        <div class="col-md-auto">
            <h1><fmt:message key="label.signin"/> </h1>
            <form action="index" method="post">
                <input type="hidden" name="action" value="signin">
                <div class="form-group row">
                    <label for="inputlogin" class="col-sm-2 col-form-label">Login</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="login" id="inputlogin" placeholder="Login">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword1" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword1" name="password" placeholder="Password">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">Sign In</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-auto">
            <h1><fmt:message key="label.registration"/> </h1>
            <form action="index" method="post">
                <input type="hidden" name="action" value="registration">
                <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Login</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="login" id="inputEmail3" placeholder="Login">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword3" name="password" placeholder="Password">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="firstName" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Name">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lastName" class="col-sm-2 col-form-label">Surname</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Surname">
                    </div>
                </div>
                <fieldset class="form-group">
                    <div class="row">
                        <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
                        <div class="col-sm-10">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" id="gridRadios1" value="male" checked>
                                <label class="form-check-label" for="gridRadios1">
                                    Male
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" id="gridRadios2" value="female">
                                <label class="form-check-label" for="gridRadios2">
                                    Female
                                </label>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">Registration</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
