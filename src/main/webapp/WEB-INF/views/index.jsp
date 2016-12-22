<%-- 
    Document   : index
    Created on : Dec 23, 2016, 1:14:11 AM
    Author     : HYOJU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Register account or Login as Admin</h1>
        
        <div>
            <a href="${pageContext.request.contextPath}/register"><button>Register</button></a>
            <a href="${pageContext.request.contextPath}/login"><button>Login</button></a>
        </div>
            
        <div>
            <p> Please Register an account and experience the features </p>
        </div>
        
   </body>
</html>
