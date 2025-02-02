<%@ page import="com.ttknp.understandservletcrudlistcollection.entity.Student" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>--%>
    <%--  use bootstrap depenency instead cdn ** now bootstrap variables you can see auto variable --%>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>JSP</title>
</head>
<body>
<%-- Way to add jsp page work as component --%>
<%@ include file="common/navbar.jsp" %>
<%--
  *** Comment in jsp file
  // when you write java code it will work on <%! .... %>
  // but when you call it will work on this <%= .... %>
  // but when you do logic it will work on this <%  .... %>
--%>
<%
    Student student = (Student) request.getAttribute("student");
%>
<div>

    <form class="form-control mt-4 p-2" action="/students.table" method="post" style="max-width: 675px; margin: 0 auto">
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Fullname</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="fullname" value="<%= student.getFullname() %>">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Age</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="age" value="<%= student.getAge() %>" >
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Year</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="year" value="<%= student.getYear() %>">
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="description" value="<%= student.getDescription() %>">
            </div>
        </div>


        <input type="hidden" name="id" value="<%= student.getId() %>">
        <input type="hidden" name="code" value="update">
        <button type="submit" class="btn btn-warning">Edit</button>

    </form>
</div>
</body>
</html>