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
    <title>Contribute to a Song</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1>Contribute to <c:out value="${song.title}"/></h1>
   <form:form action="/song/${song.id}/edit" method="POST" modelAttribute="song">
   		<input type="hidden" name="_method" value="PUT"/>
   		<form:hidden path="id"/>
   		<form:hidden path="submittedBy"/>
   		<form:hidden path="collaborators"/>
   	   <div>
	   	   	<form:label path="title">Title:</form:label>
	   	   	<form:input path="title"/>
	   	   	<form:errors path="title" />
   	   </div>
   	   <div>
	   	   	<form:label path="genre">Genre:</form:label>
	   	   	<form:input path="genre"/>
	   	   	<form:errors path="genre" />
   	   </div>
   	   <div>
	   	   	<label>Lyrics</label>
	   	   	<p><c:out value="${song.lyrics}"/></p>
	   	   	<form:hidden path="lyrics" />
   	   </div>
   	   <div>
   	   		<textarea name="newLyrics" placeholder="Enter your new lyrics here..."></textarea>
   	   </div>
   	   <button class="btn btn-success">Submit</button>
   	   <a href="/home" class="btn btn-primary">Home</a>
   </form:form>
   <form action="/song/${song.id}" method="POST">
   		<input type="hidden" name="_method" value="DELETE"/>
   		<button class="btn btn-danger">Delete</button>
   </form>
</body>
</html>

