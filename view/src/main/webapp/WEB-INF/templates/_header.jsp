<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>autorent</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>

<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/autorent/index.view">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/autorent/car-list/0.view">Car list</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Select action
          </a>
          <ul class="dropdown-menu">
      <!--      <li><a class="dropdown-item" href="/autorent/add-permission.view">Add description</a></li>   -->
        <!--    <li><a class="dropdown-item" href="/autorent/add-user-information.view">Add user information</a></li>   -->
        <!--    <security:authorize access="hasRole('ADMIN')"><li><a class="dropdown-item" href="/autorent/add-role.view">Add role</a></li></security:authorize>  -->
            <security:authorize access="hasRole('ADMIN')"><li><a class="dropdown-item" href="/autorent/add-car/.view">Add car</a></li></security:authorize>
            <security:authorize access="hasRole('ADMIN')"><li><a class="dropdown-item" href="/autorent/add-brand.view">Add car brand</a></li></security:authorize>
            <security:authorize access="hasRole('ADMIN')"><li><a class="dropdown-item" href="/autorent/add-car-model.view">Add car model</a></li></security:authorize>
            <security:authorize access="hasRole('ADMIN')"><li><a class="dropdown-item" href="/autorent/add-user.view">Add user</a></li></security:authorize>
            <security:authorize access="hasRole('USER')"><li><a class="dropdown-item" href="/autorent/order-list.view">My orders</a></li></security:authorize>
            <security:authorize access="hasRole('USER')"><li><a class="dropdown-item" href="/autorent/update-user-information.view">Update information about me</a></li></security:authorize>
          </ul>
        </li>
                <li class="nav-item">
                <security:authorize access="isAuthenticated()">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                </security:authorize>
                <security:authorize access="!isAuthenticated()">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                </security:authorize>
                </li>
      </ul>
            <security:authorize access="isAuthenticated()">
              <a class="nav-link disabled">Welcome&nbsp;<security:authentication property="name"/>&nbsp;</a>
            </security:authorize>
            <security:authorize access="!isAuthenticated()">
              <a class="nav-link disabled">Welcome&nbsp;anonymous</a>
            </security:authorize>
            <security:authorize access="!isAuthenticated()">
              <a href="/autorent/registration.view">Registration</a>
            </security:authorize>
    </div>
  </div>
</nav>
