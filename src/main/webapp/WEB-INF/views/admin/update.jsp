<%-- 
    Document   : update
    Created on : Dec 23, 2016, 2:11:05 AM
    Author     : HYOJU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Update Data:</h1>
        <form method="post" action="">
            <div>
                <label>First Name:</label>
                <input type="text" name="firstName" required="required" value="${requestScope.user.firstName}"/>
            </div>
            <div>
                <label>Last Name:</label>
                <input type="text" name="lastName" required="required" value="${requestScope.user.lastName}"/>
            </div>
            <div>
                <label>Email:</label>
                <input type="email" name="email" required="required" value="${requestScope.user.email}"/>
            </div>
            <div>
                <label>Username:</label>
                <input type="text" name="username" required="required" value="${requestScope.user.username}"/>
            </div>
            <div>
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
            </div>

        </form>
    </body>
</html>
