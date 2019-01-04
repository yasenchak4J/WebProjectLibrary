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
                        <c:out value="${subs.getId()}"/>
                    </div>
                </div>
                <div class="row align-items-center justify-content-center">
                    <div class="col">
                        <c:out value="${subs.getBookName()}"/>
                    </div>
                </div>
                <div class="row align-items-center justify-content-center">
                    <div class="col">
                        <c:out value="${subs.getIsbn()}"/>
                    </div>
                </div>
                <div class="row align-items-center justify-content-center">
                    <div class="col">
                        <c:out value="${subs.getUserName()}"/>
                    </div>
                </div>
                <div class="row align-items-center justify-content-center">
                    <div class="col">
                        <c:out value="${subs.getType()}"/>
                    </div>
                </div>

                <form action="index" method="post">
                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            Select date out
                        </div>
                        <div class="col">
                            <input type="date" name="dateOut">
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center">
                        <div class="col">
                            <input type="hidden" name="action" value="agreeRenew">
                            <input type="hidden" name="id" value="${subs.getId()}">
                            <input type="submit" name="submit" value="submit">
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>
