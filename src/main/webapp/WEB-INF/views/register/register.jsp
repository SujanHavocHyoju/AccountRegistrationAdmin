<%-- 
    Document   : register
    Created on : Dec 23, 2016, 1:02:00 AM
    Author     : HYOJU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Now</title>
    </head>
    <body>
        <h1>Register your Account</h1>
        <h2><u>Sign Up</u></h2>
        <form method="post" action="">
            <div>
                <label>First Name:</label>
                <input type="text" required="required" name="firstName"/>
            </div>
            <div>
                <label>Last Name:</label>
                <input type="text" required="required" name="lastName"/>
            </div>
            <div>
                <label>Email:</label>
                <input type="email" required="required" name="email" />
            </div>
            <div>
                <label>Username:</label>
                <input type="text" required="required" name="username" />
            </div>
            <div>
                <label>Password:</label>
                <input type="password" required="required" name="password"/>
            </div>
            <div>
                <button type="submit">Register</button>
                <button type="reset">Reset</button>
            </div>
            <hr/>
            <div>
                <a href="${pageContext.request.contextPath}/login"><button>Login</button></a>
            </div>

        </form>
    </body>
</html>
