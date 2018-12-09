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
</head>
<body>
<form action="index" method = "post">
    <h1>Форма входа</h1>
    <input type="hidden" name="action" value="signin">
    <input type="text" name="login" placeholder="Логин">
    </p>
    <p>
        <input type="password" name='password' placeholder="Пароль">
    </p>

    <p>
        <input type="submit" name="submit" value="Продолжить">
    </p>
</form>

<form  method = "post">
    <h1>Форма регистрации</h1>
    <input type="hidden" name="action" value="registration">
    <input type="text" name="login" placeholder="Логин">
    </p>
    <p>
        <input type="password" name='password' placeholder="Пароль">
    </p>

    <p>
        <input type="submit" name="submit" value="Продолжить">
    </p>
</form>
</body>
</html>
