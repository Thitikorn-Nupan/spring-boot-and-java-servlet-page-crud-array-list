<%@ page import="com.ttknp.understandservletcrudlistcollection.entity.Student" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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

<form class="form-control mt-4 p-2" action="/login" enctype="application/x-www-form-urlencoded" method="post" style="max-width: 675px; margin: 0 auto">
    <!-- Email input -->
    <div data-mdb-input-init class="form-outline mb-4">
        <input type="email" name="email" id="form1Example1" class="form-control" />
        <label class="form-label" for="form1Example1">Email address</label>
    </div>

    <!-- Password input -->
    <div data-mdb-input-init class="form-outline mb-4">
        <input type="password" name="password" id="form1Example2" class="form-control" />
        <label class="form-label" for="form1Example2">Password</label>
    </div>

    <!-- Submit button -->
    <button data-mdb-ripple-init type="submit" class="btn btn-primary btn-block">Sign in</button>
</form>

</div>
</body>
</html>