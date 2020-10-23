<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<title>Customers List</title>

	<script>
		function confDelete() {
			return confirm('Are you sure about that?');
		}
	</script>
</head>

<body>

<input type="button" value="Add Customer" onclick="window.location.href='add'">

<br><br>

<%--<a href="<c:url value='/customer/add' />">Add customer</a>--%>

<table border="1">
	<thead>
		<tr>
			<td>ID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Email</td>
			<td>Action</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${customer_list}" var="cust">

			<c:url var="editLink" value="/customer/edit">
				<c:param name="id" value="${cust.id}" />
			</c:url>

			<tr>
				<td><c:out value="${cust.id}"/></td>
				<td><c:out value="${cust.firstName}"/></td>
				<td><c:out value="${cust.lastName}"/></td>
				<td><c:out value="${cust.email}"/></td>
				<td>
<%--				<a href="<c:url value='/customer/edit?id=${cust.id}' />">Edit</a> |--%>
					<a href="${editLink}">Edit</a> |
					<a href="<c:url value='/customer/delete?id=${cust.id}' />"
					   onclick="if(!confDelete()) return false">
						Delete
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>

</html>









