<%--
  Created by IntelliJ IDEA.
  User: simeonoff
  Date: 27/10/2019
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="models.view.ClientViewModel"%>
<%ClientViewModel client = ((ClientViewModel)request.getAttribute("viewModel"));%>
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
        <a class="navbar-brand" href="/home">ClientsBook Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
</div>

<section>
<main>
    <div class="container-fluid">
        <hr>
        <form method="post" action="/edit/<%=client.getId()%>">
            <div class="form-row">
                <div class="form-group col-md-1"></div>
                <div class="form-group col-md-5">
                    <label for="inputFirstName">First Name</label>
                    <input type="text" value="<%=client.getFirstName()%>" class="form-control" name="firstName" id="inputFirstName" placeholder="First Name">
                </div>
                <div class="form-group col-md-5">
                    <label for="inputLastName">Last Name</label>
                    <input type="text" value="<%=client.getLastName()%>" class="form-control" name="lastName" id="inputLastName" placeholder="Last Name">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-1"></div>
                <div class="form-group col-md-5">
                    <label for="inputDateBirth">Date of Birth</label>
                    <input type="date" value="<%=client.getDateBirth()%>" class="form-control" name="dateBirth" id="inputDateBirth">
                </div>
                <div class="form-group col-md-5">
                    <label for="inputPhoneNumber">Phone Number</label>
                    <input type="text" value="<%=client.getPhoneNumber()%>" class="form-control" name="phoneNumber" id="inputPhoneNumber" placeholder="Phone Number">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-3"></div>
                <div class="form-group col-md-6">
                    <label for="inputEmail">E-mail Address</label>
                    <input type="email" value="<%=client.getEmail()%>" class="form-control" name="email" id="inputEmail">
                </div>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-outline-success">Edit Client</button>
            </div>
        </form>
    </div>
</main>
</section>

<footer class="fixed-bottom text-center">
    <div class="container-fluid">
        <p style="background-color: darkcyan"><strong>CopyRight© Simeonoff Design Studios. All rights reserved</strong></p>
    </div>
</footer>

</body>
</body>
</html>
