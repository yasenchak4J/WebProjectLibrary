<%--
  Created by IntelliJ IDEA.
  User: Yasenchak
  Date: 07.12.2018
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    This locate all books
    <jsp:useBean id="user" scope="request" type="by.yasenchak.library_epam.entity.User"/>
    <c:out value="${user.name}" />
</body>
</html>
