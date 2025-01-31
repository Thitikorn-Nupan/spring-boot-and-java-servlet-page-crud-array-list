<%@ page import="com.ttknp.understandservletcrudlistcollection.entity.Student" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
<%
    List<Student> studentList = (List<Student>) request.getAttribute("students");
%>
<div class="container" style="max-width: 700px">
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Fullname</th>
            <th scope="col">Age</th>
            <th scope="col">Year</th>
            <th scope="col">Description</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < studentList.size(); i++) {
        %>
        <tr>
            <th scope="row"><%= i + 1 %>
            </th>
            <td><%= studentList.get(i).getFullname() %>
            </td>
            <td><%= studentList.get(i).getAge() %>
            </td>
            <td><%= studentList.get(i).getYear() %>
            </td>
            <td><%= studentList.get(i).getDescription() %>
            </td>
            <td style="display: flex">
                <form action="/students.table" method="post">
                    <input type="hidden" name="code" value="delete">
                    <input type="hidden" name="id" value="<%= studentList.get(i).getId() %>">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
                <form action="/students.table" method="post">
                    <input type="hidden" name="id" value="<%= studentList.get(i).getId() %>">
                    <input type="hidden" name="code" value="read">
                    <button type="submit" class="btn btn-warning">Edit</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <form action="/students.table" method="post">
        <input type="hidden" name="code" value="form">
        <button type="submit" class="btn btn-success">Add</button>
    </form>

</div>
</body>
</html>