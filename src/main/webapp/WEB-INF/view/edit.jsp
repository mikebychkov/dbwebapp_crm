<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>

<body>

<form:form method="post" action="save" modelAttribute="customer">

    <form:input path="id" type="hidden" />

    First Name: <form:input path="firstName" type="text" placeholder="First Name" />

    <br><br>

    Last Name: <form:input path="lastName" type="text" placeholder="Last Name" />

    <br><br>

    Email: <form:input path="email" type="email" placeholder="Email" />

    <br><br>

    <input type="submit" value="Save" />

</form:form>

</body>

</html>
