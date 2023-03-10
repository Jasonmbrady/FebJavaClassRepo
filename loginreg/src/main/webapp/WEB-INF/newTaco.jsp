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
   <h1>Create a new taco!</h1>
   <form:form action="/taco/new" method="POST" modelAttribute="taco">
   	<div>
   		<form:label path="name">Name:</form:label>
   		<form:input path="name" />
   		<form:errors path="name" />
   	</div>
   	<div>
   		<form:label path="isSoftTaco">Shell:</form:label>
   		<form:select path="isSoftTaco">
   			<form:option value="${true}">Soft Shell</form:option>
   			<form:option value="${false}">Hard Shell</form:option>
   		</form:select>
   		<form:errors path="isSoftTaco" />
   	</div>
   	<div>
   		<form:label path="salsaType">Salsa:</form:label>
   		<form:input path="salsaType" />
   		<form:errors path="salsaType" />
   	</div>
   	<button>Submit</button>
   
   </form:form>
</body>
</html>

