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
    <title>Create New Member</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1>Create a Member </h1>
   <form:form action="/member/new" method="POST" modelAttribute="member">
   		<div>
   			<form:label path="firstName">First Name:</form:label>
   			<form:input path="firstName" />
   			<form:errors path="firstName"/>
   		</div>
   		<div>
   			<form:label path="lastName">Last Name:</form:label>
   			<form:input path="lastName" />
   			<form:errors path="lastName"/>
   		</div>
   		<button>Submit</button>
   </form:form>
</body>
</html>

