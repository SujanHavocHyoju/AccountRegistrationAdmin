<%-- 
    Document   : login
    Created on : Dec 23, 2016, 1:34:28 AM
    Author     : HYOJU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="">
            <div>
                <label>Username:</label>
                <input type="text" required="required" name="username"/>
            </div>
            <div>
                <label>Password:</label>
                <input type="password" required="required" name="password"/>
            </div>
            <br>
            <div>
                <button type="submit">Login</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>