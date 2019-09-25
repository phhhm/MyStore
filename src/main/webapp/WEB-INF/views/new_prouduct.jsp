<%@ page  isELIgnored="false" %>
<%@taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>new product</title>
</head>
<body>
<h1 class="display-1  bg-info text-center">Add product!</h1>

<div class="container">
    <div class="row">
        <div class="col">
            <sf:form modelAttribute="prouduct" action="/prouduct" cssClass="form-group" method="post" enctype="multipart/form-data">
                <label for="name">Name</label>
                <sf:input path="name" placeholder = "enter name" name = "name" cssClass="form-control" id="name"/><br>
                <label for="desc">Description</label>
                <sf:input path="description" placeholder = "enter description" name = "desc" cssClass="form-control" id="desc"/><br>
                <label for="image">image</label>
                <sf:input type="file" cssClass="form-control" id="customFile" path="image" name = "image"/><br>
                <button class="btn btn-primary">Add</button>
            </sf:form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>