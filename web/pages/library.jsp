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
