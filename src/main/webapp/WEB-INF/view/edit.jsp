<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>

<body>

<form:form method="post" action="save" modelAttribute="customer">

<%--<form:input path="id" type="hidden" />--%>
    <form:hidden path="id" />

    <table>
        <tr>
            <td>
                First Name:
            </td>
            <td>
                <form:input path="firstName" type="text" placeholder="First Name" />
            </td>
        </tr>
        <tr>
            <td>
                Last Name:
            </td>
            <td>
                <form:input path="lastName" type="text" placeholder="Last Name" />
            </td>
        </tr>
        <tr>
            <td>
                Email:
            </td>
            <td>
                <form:input path="email" type="email" placeholder="Email" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Save" />
            </td>
        </tr>
    </table>

</form:form>

<p>
    <a href="<c:url value='/customer/list' />">Back to list</a>
</p>

</body>

</html>
