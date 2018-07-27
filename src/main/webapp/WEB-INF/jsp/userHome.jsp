<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>

<html>

<head>
    <title>User Form</title>
    <link rel="stylesheet" href="/css/main.css"/>
</head>

<body>

<div id="container">

    <h2>User</h2>

    <c:if test="${not empty message}">
        <div class="message green">${message}</div>
    </c:if>

    <form:form action="/user" modelAttribute="newUserForm">

        <label for="emailInput">Email: </label>
        <form:input path="email" id="emailInput"/>
        <form:errors path="email" cssClass="error"/>
        <br/>

        <label for="verifyEmailInput">Verify email: </label>
        <form:input path="verifyEmail" id="verifyEmailInput"/>
        <form:errors path="verifyEmail" cssClass="error"/>
        <br/>

        <label for="passwordInput">Password: </label>
        <form:input path="password" id="passwordInput"/>
        <form:errors path="password" cssClass="error"/>
        <br/>

        <label for="verifyPasswordInput">Verify password: </label>
        <form:input path="verifyPassword" id="verifyPasswordInput"/>
        <form:errors path="verifyPassword" cssClass="error"/>
        <br/>

        <input type="submit" value="Submit"/>
    </form:form>

</div>

</body>

</html>
