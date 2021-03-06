<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
          <a class="nav-link" href="?sessionLocale=en"><fmt:message key="label.lang.en" /></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="?sessionLocale=ru"><fmt:message key="label.lang.ru" /> </a>
        </li>
        <c:if test="${user != null}">
          <li class="nav-item">
            <form action="index" id="profile" method="post">
              <input type="hidden" name="action" value="goToProfile">
              <a class="nav-link" href="#" onclick="document.getElementById('profile').submit(); return false;">Profile</a>
            </form>
          </li>
        </c:if>
      </ul>
      <ul class="nav justify-content-end">
        <li class="nav-item">
          <c:if test="${user != null}">
            <form action="index" method="post" id="signOut">
              <input type="hidden" name="action" value="signOut">
                ${user.getName()}, <a class="nav-link" href="#" onclick="document.getElementById('signOut').submit(); return false;">SignOut</a>
            </form>
          </c:if>
          <c:if test="${user == null}">
          <form action="index" method="post" id="goToAuthPage">
            <input type="hidden" name="action" value="goToAuthPage">
            <a class="nav-link" href="#"  onclick="document.getElementById('goToAuthPage').submit(); return false;">SignIn</a>
          </form>
          </c:if>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0" action="index">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" name="textSearch" aria-label="Search">
        <input type="hidden" name="action" value="search">
        <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search">
      </form>
    </div>
  </nav>

  <div class="container-fluid">
    <div class="row">
      <div class="col col-lg-1">
        <ul class="nav flex-column">
            <c:forEach var="genre" items="${genres}">
              <form action="index" id="${genre.getId()}">
                <input type="hidden" name="action" value="getBookByGenre">
                <li class="nav-item">
                  <input type="hidden" name="genre" value="${genre.getName()}">
                  <a class="nav-link" href="#" onclick="document.getElementById('${genre.getId()}').submit(); return false;">${genre.getName()}</a>
                </li>
              </form>
            </c:forEach>
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
              <div class="row">
                <div class="col">Жанр: <c:out value="${book.getGenres().getName()}"/> </div>
              </div>
              <div class="row">
                <div class="col">Автор: <c:out value="${book.getAuthors().getNameAndSurname()}"/> </div>
              </div>
              <div class="row">
                <div class="col">
                  <form action="index" id="book ${book.getId()}" method="post">
                    <input type="hidden" name="action" value="subscriptionBook">
                    <input type="hidden" name="book" value="${book.getId()}">
                    <a class="nav-link" href="#" onclick="document.getElementById('book ${book.getId()}').submit(); return false;">Take book</a>
                  </form>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>