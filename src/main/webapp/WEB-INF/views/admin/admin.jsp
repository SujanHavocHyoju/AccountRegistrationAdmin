<%-- 
    Document   : admin
    Created on : Dec 23, 2016, 1:57:14 AM
    Author     : HYOJU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userDAO" class="com.leapfrog.project.accountregistrationadmin.dao.impl.UserDAOImpl"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Admin Page</title>
        </head>
        <body>
            <h1>Records</h1>
            <table border="2px">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Username</td>
                        <td>Email</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <c:forEach var="user" items="${userDAO.all}">
                        <td>${user.firstName} ${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>${user.username}</td>
                        <td><a href="${pageContext.request.contextPath}/update?id=${user.id}"><button>Update</button></a></td>
                        <td><a href="${pageContext.request.contextPath}/delete?id=${user.id}"><button>Delete</button></a></td>
                    </tr>
                    </c:forEach>
                </tbody>
        </table>
    </body>
</html>
