<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos RULE</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h3>Hello, <c:out value="${user.username}" /></h3>
   <p><a href="/logout">Log Out</a></p>
   <h2>All Song Labs</h2>
   <table class="table">
   		<thead>
   			<tr>
   				<th>Song Name</th>
   				<th>Number of Collaborators</th>
   			</tr>
   		</thead>
   		<tbody>
   			<c:forEach var="song" items="${allSongs}">
   				<tr>
   					<td><a href="/song/${song.id}"><c:out value="${song.title}"/></a><br><c:out value="${song.genre}"/></td>
   					<td><c:out value="${song.numCollaborators}"/></td>
   				</tr>
   			</c:forEach>
   		</tbody>
   </table>
   <a href="/song/new" class="btn btn-success">New Song</a>
</body>
</html>

