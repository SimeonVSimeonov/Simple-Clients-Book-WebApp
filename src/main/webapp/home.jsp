<%--
  Created by IntelliJ IDEA.
  User: simeonoff
  Date: 26/10/2019
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@page import="models.view.ClientViewModel"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>ClientsBook</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #86cfda">
        <a class="navbar-brand" href="/home">ClientsBook</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/add">Add Client</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Sort By
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/last">Last Name</a>
                        <a class="dropdown-item" href="/date">Birth Date</a>
                    </div>
                </li>
            </ul>
            <form method="post" class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" name="searchData" placeholder="Search Clients" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>

<section>
<main>
    <hr>
    <div class="container-fluid">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Date of Birth</th>
                <th scope="col">Phone Number</th>
                <th scope="col">eMail</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <% for (ClientViewModel client : ((List<ClientViewModel>)request.getAttribute("viewModel"))) {%>
            <tr>
                <td><%= client.getFirstName()%></td>
                <td><%= client.getLastName()%></td>
                <td><%= client.getDateBirth()%></td>
                <td><%= client.getPhoneNumber()%></td>
                <td><%= client.getEmail()%></td>
                <td><a href="/edit/<%=client.getId()%>"><strong class="text-warning">Edit</strong></a></td>
                <td><a href="/delete/<%=client.getId()%>"><strong class="text-danger">Delete</strong></a></td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <hr>
    </div>
    <hr>
</main>
</section>

<footer class="fixed-bottom text-center">
    <div class="container-fluid">
        <p style="background-color: darkcyan"><strong>CopyRight© Simeonoff Design Studios. All rights reserved</strong></p>
    </div>
</footer>

</body>
</html>
