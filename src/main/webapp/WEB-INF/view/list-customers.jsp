<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<title>Customers List</title>
</head>

<body>

<a href="<c:url value='/customer/add' />">Add customer</a>

<br><br>

<table border="1">
	<thead>
		<tr>
			<td>ID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Email</td>
			<td>Edit</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${customer_list}" var="cust">
			<tr>
				<td><c:out value="${cust.id}"/></td>
				<td><c:out value="${cust.firstName}"/></td>
				<td><c:out value="${cust.lastName}"/></td>
				<td><c:out value="${cust.email}"/></td>
				<td>
					<a href="<c:url value='/customer/edit?id=${cust.id}' />">Edit</a>|
					<a href="<c:url value='/customer/delete?id=${cust.id}' />">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>

</html>









