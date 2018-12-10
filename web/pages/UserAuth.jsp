<%--
  Created by IntelliJ IDEA.
  User: Yasenchak
  Date: 04.12.2018
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid h-100">
    <div class="row align-items-center justify-content-center h-100">
        <div class="col-md-auto">
            <form action="index" method = "post">
                <h1>Форма входа</h1>
                <input type="hidden" name="action" value="signin">
                <input type="text" name="login" placeholder="Логин">
                <p>
                    <input type="password" name='password' placeholder="Пароль">
                </p>

                <p>
                    <input type="submit" name="submit" value="Продолжить">
                </p>
            </form>
        </div>
        <div class="col-md-auto">
            <form  method = "post">
                <h1>Форма регистрации</h1>
                <input type="hidden" name="action" value="registration">
                <input type="text" name="login" placeholder="Логин">
                <p>
                    <input type="password" name='password' placeholder="Пароль">
                </p>

                <p>
                    <input type="submit" name="submit" value="Продолжить">
                </p>
            </form>
        </div>
    </div>
</div>




</body>
</html>
