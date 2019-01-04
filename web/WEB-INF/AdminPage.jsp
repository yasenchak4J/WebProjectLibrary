<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Admin panel</title>
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
                 <form action="index" method="post" id="allBooks">
                     <input type="hidden" name="action" value="getAllBookAdmin">
                     <a class="nav-link" href="#" onclick="document.getElementById('allBooks').submit(); return false;">All books<span class="sr-only">(current)</span></a>
                 </form>
             </li>
             <li>
                 <form action="index" method="post" id="toAddNewBook">
                     <input type="hidden" name="action" value="toAddNewBook">
                     <a class="nav-link" href="#" onclick="document.getElementById('toAddNewBook').submit(); return false;">Add new book</a>
                 </form>
             </li>
             <li>
                 <form action="index" method="post" id="toAllUsers">
                     <input type="hidden" name="action" value="toAllUsers">
                     <a class="nav-link" href="#" onclick="document.getElementById('toAllUsers').submit(); return false;">Users</a>
                 </form>
             </li>
             <li>
                 <form action="index" method="post" id="toAllAuthors">
                     <input type="hidden" name="action" value="toAllAuthors">
                     <a class="nav-link" href="#" onclick="document.getElementById('toAllAuthors').submit(); return false;">Authors</a>
                 </form>
             </li>
             <li>
                 <form action="index" method="post" id="toAllGenres">
                     <input type="hidden" name="action" value="toAllGenres">
                     <a class="nav-link" href="#" onclick="document.getElementById('toAllGenres').submit(); return false;">Genres</a>
                 </form>
             </li>
         </ul>
         <form class="form-inline my-2 my-lg-0" action="index">
             <input class="form-control mr-sm-2" type="search" placeholder="Search" name="textSearch" aria-label="Search">
             <input type="hidden" name="action" value="searchAdmin">
             <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search">
         </form>
     </div>
 </nav>

<c:out value="${books.size()}"/>
 <div class="container-fluid">
     <div class="row">
         <div class="col">Все книги</div>
     </div>
     <div class="row">
         <c:forEach var="book" items="${books}">
             <div class="col">
                 <div class="row">
                     <div class="col"><img src="${ book.getImagePath()}" width="100" height="125"></div>
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
                     <div class="cell">
                         <form action="index" method="post">
                             <input type="hidden" name="action" value="getBookById">
                             <input type="hidden" name="id" value="${book.getId()}">
                             <input type="submit" name="submit" value="Изменить">
                         </form>
                     </div>
                     <div class="cell">
                         <form action="index" method="post">
                             <input type="hidden" name="action" value="deleteBook">
                             <input type="hidden" name="id" value="${book.getId()}">
                             <input type="submit" name="submit" value="Удалить">
                         </form>
                     </div>
                 </div>
             </div>
         </c:forEach>
     </div>

 </div>

</body>
</html>
