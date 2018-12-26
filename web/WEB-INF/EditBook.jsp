<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>EditBook</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid h-100">
        <div class="row  align-items-center justify-content-center h-100">
        <div class="row align-items-center justify-content-center">
            <div class="col">
                <div class="row align-items-center justify-content-center">
                    <div class="col">
                        <img src="${book.getImagePath()}">
                    </div>
                </div>
                <form action="index" method="post" enctype="multipart/form-data">
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="file" name="file">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="hidden" name="action" value="editBook">
                            <input type="hidden" name="id" value="${book.getId()}">
                            <input type="text" name="name" value="${book.getName()}">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="text" name="pageCount" value="${book.getPageCount()}">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="text" name="isbn" value="${book.getiSBN()}">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="text" name="publisher" value="${book.getPublisher()}">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="submit" name="Изменить">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
</body>
</html>
