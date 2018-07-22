<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dgrabchak
  Date: 25.06.18
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signup</title>
</head>
<body>


    <h1>Please enter information: </h1>

    <form action="<c:url value="/servlet/signup"/>" method="post">
        <label for="firstName">First Name</label>
        <input type="text" name="firstName" id="firstName">

        <label for="lastName">Last Name</label>
        <input type="text" name="lastName" id="lastName">

        <label for="email">Email</label>
        <input type="email" name="email" id="email">

        <label for="password">Password</label>
        <input type="password" name="password" id="password">

        <label for="password2">Confirm Password</label>
        <input type="password" name="password" id="password2">

        <button type="submit">Sign Up</button>
    </form>


</body>
</html>
