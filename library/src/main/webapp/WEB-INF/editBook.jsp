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
    <title>Edit Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1>Edit Book</h1>
   <form:form action="/book/${book.id}" method="POST" modelAttribute="book">
   <input type="hidden" name="_method" value="PUT"/>
   	<div>
 		<form:label path="title">Title:</form:label>
 		<form:input path="title"/>
 		<form:errors path="title" class="text-danger"/>
 	</div>
 	<div>
 		<form:label path="author">Author:</form:label>
 		<form:input path="author"/>
 		<form:errors path="author" class="text-danger"/>
 	</div>
 	<div>
 		<form:label path="numOfPages">Number of Pages:</form:label>
 		<form:input path="numOfPages" type="number"/>
 		<form:errors path="numOfPages" class="text-danger"/>
 	</div>
 	<button>Submit</button>
   </form:form>
</body>
</html>

