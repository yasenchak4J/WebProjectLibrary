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
            <form action="index" method = "post">
                <h1><fmt:message key="label.signin"/> </h1>
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
            <form  action="index" method = "post">
                <h1><fmt:message key="label.registration"/></h1>
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
