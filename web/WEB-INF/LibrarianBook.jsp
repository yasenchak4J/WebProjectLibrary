<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Title</title>
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
            </div>
        </div>
    </div>
</div>
</body>
</html>
