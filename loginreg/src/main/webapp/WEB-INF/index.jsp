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
    <title>LoginApp</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container">
        <h1>Welcome to the LoginApp!</h1>
        <div class="row">
            <form:form action="/register" method="POST" modelAttribute="user" class="col">
                <h2>Register Here:</h2>
                <div class="form-group">
                    <form:label path="username">Username:</form:label>
                    <form:input path="username"/>
                    <form:errors path="username"/>
                </div>
                <div class="form-group">
                    <form:label path="email">Email:</form:label>
                    <form:input path="email"/>
                    <form:errors path="email"/>
                </div>
                <div class="form-group">
                    <form:label path="password">Password:</form:label>
                    <form:input path="password" type="password"/>
                    <form:errors path="password"/>
                </div>
                <div class="form-group">
                    <form:label path="confirmPass">Confirm Password:</form:label>
                    <form:input path="confirmPass" type="password"/>
                    <form:errors path="confirmPass"/>
                </div>
                <button>Register</button>
            </form:form>
            <form:form action="/login" method="POST" modelAttribute="loginUser" class="col">
                <h2>Login Here:</h2>
                <div class="form-group">
                    <form:label path="email">Email:</form:label>
                    <form:input path="email"/>
                    <form:errors path="email"/>
                </div>
                <div class="form-group">
                    <form:label path="password">Password:</form:label>
                    <form:input path="password" type="password"/>
                    <form:errors path="password"/>
                </div>
                <button>Log In</button>
            </form:form>
        </div>
    </div>
</body>
</html>

