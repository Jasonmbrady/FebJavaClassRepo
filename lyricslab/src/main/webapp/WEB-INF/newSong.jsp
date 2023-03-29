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
    <title>Create a Song</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1>Start a New Song!</h1>
   <form:form action="/song/new" method="POST" modelAttribute="song">
   	   <div>
   	   	   <form:label path="title">Title</form:label>
   	   	   <form:input path="title"/>
   	   	   <form:errors path="title"/>
   	   </div>
   	   <div>
   	   	   <form:label path="genre">Genre</form:label>
   	   	   <form:input path="genre"/>
   	   	   <form:errors path="genre"/>
   	   </div>
   	   <div>
   	   	   <form:label path="lyrics">Lyrics</form:label>
   	   	   <form:input path="lyrics"/>
   	   	   <form:errors path="lyrics"/>
   	   </div>
   	   <button class="btn btn-success">Submit</button>
   	   <a href="/home" class="btn btn-primary">Home</a>
   </form:form>
</body>
</html>

