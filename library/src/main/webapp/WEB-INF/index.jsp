<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
<title>Library</title>

</head>
<body>
	<div class="container">
	<h1 class="text-primary text-center">Welcome to Library</h1>
	<p><a href="/book/new">Add a Book</a></p>
	<p><a href="/member/new">Add a Member</a></p>
		<div class="row">
			<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>Number of Pages</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${allBooks}">
						<tr>
							<td><c:out value="${book.title}" /></td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.numOfPages}" /></td>
							<td><form action="/book/${book.id}" method="POST">
								<input type="hidden" name="_method" value="delete"/>
								<button class="btn btn-danger">Delete</button>
							</form> <a href="/book/${book.id}" class="btn btn-primary">Edit</a></td>				
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "member" items="${allMembers}">
						<tr>
							<td><c:out value="${member.firstName}" /></td>
							<td><c:out value="${member.lastName}" /></td>
							<td><a href="/member/${member.id}" class="btn btn-primary">View</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>