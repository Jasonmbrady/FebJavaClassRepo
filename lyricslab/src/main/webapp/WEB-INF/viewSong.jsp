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
    <title>View Song</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1><c:out value="${song.title}"/></h1>
   <h3>(started by <c:out value="${song.submittedBy.username}"/>)</h3>
   <h3>Genre: <c:out value="${song.genre}"/></h3>
   <h3>Lyrics:</h3>
   <p><c:out value="${song.lyrics}"/></p>
   <a href="/song/${song.id}/edit" class="btn btn-success">Contribute</a>
   <a href="/home" class="btn btn-primary">home</a>
   <h2>Collaborators:</h2>
   <ul>
   	<c:forEach var="user" items="${collabList}">
   		<li><c:out value="${user.username}"/></li>
   	</c:forEach>
   </ul>
</body>
</html>

