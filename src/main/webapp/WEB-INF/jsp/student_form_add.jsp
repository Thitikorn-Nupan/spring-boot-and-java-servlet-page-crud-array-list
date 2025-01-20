<%@ page import="com.ttknp.understandservletcrudlistcollection.entity.Student" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>JSP</title>
</head>
<body>
<%--
  *** Comment in jsp file
  // when you write java code it will work on <%! .... %>
  // but when you call it will work on this <%= .... %>
  // but when you do logic it will work on this <%  .... %>
--%>

<div class="container" style="max-width: 700px; background: bisque; padding: 15px" >

    <form action="/add" enctype="multipart/form-data" method="post">
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Fullname</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="fullname">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Age</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="age" >
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Year</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="year" >
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="description" >
            </div>
        </div>



        <button type="submit" class="btn btn-success">Add</button>

    </form>
</div>
</body>
</html>