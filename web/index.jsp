<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>
<html lang="${param.lang}">
  <head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  </head>
  <body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Library</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Profile</a>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0" action="index">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" name="textSearch" aria-label="Search">
        <input type="hidden" name="action" value="search">
        <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search">
      </form>
    </div>
  </nav>

  <a href="pages/UserAuth.jsp">SignIn</a>

  <a href="?sessionLocale=en"> <fmt:message key="label.lang.en" /></a>

  <a href="?sessionLocale=ru"><fmt:message key="label.lang.ru" /> </a>


  <div class="container-fluid">
    <div class="row">
      <div class="col col-lg-1">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="#">Active</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
        </ul>
      </div>
      <div class="col">
        <div class="row">
          <c:forEach var="book" items="${books}">
            <div class="col">
              <div class="row">
                <div class="col"><img src="${book.getImagePath()}" width="100" height="125"></div>
              </div>
              <div class="row">
                <div class="col">Наименование: <c:out value="${book.getName()}"/></div>
              </div>
              <div class="row">
                <div class="col">Количество страниц: <c:out value="${book.getPageCount()}"/> </div>
              </div>
              <div class="row">
                <div class="col">ISBN: <c:out value="${book.getiSBN()}"/> </div>
              </div>
              <div class="row">
                <div class="col">Издатель: <c:out value="${book.getPublisher()}"/> </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>