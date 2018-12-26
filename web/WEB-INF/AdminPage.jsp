<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>AdminPage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

 <form action="index" method = "post">
     <input type="hidden" name="action" value="addNewBook">
     <input type="text" name="name" placeholder="Название книги">
     <input type="text" name="pageCount" placeholder="Количество страниц">
     <input type="text" name="isbn" placeholder="isbn">
     <input type="text" name="publisher" placeholder="Издательство">
     <input type="submit" name="submit" value="Добавить">
 </form>

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
