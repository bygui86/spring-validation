<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>

<html>

<head>
    <title>Phone Form</title>
    <link rel="stylesheet" href="/css/main.css"/>
</head>

<body>

<div id="container">

    <h2>Phone Number</h2>

    <c:if test="${not empty message}">
        <div class="message green">${message}</div>
    </c:if>

    <form:form action="/addValidatePhone" modelAttribute="validatedPhone">

        <label for="phoneInput">Phone: </label>
        <form:input path="phone" id="phoneInput"/>
        <form:errors path="phone" cssClass="error"/>
        <br/>

        <input type="submit" value="Submit"/>
    </form:form>

</div>

</body>

</html>
