<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <form action="controller" method = "post">
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

  <form action="controller" method = "post">
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