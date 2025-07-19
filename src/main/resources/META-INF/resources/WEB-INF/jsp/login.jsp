<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <h1>Login</h1>
        <pre>${errorMessage}</pre> 
        <form method="post">
            Name: <input type="text" name="name" />
            Password: <input type="password" name="password" />
            <input type="submit" />
        </form>
    </body>
</html>