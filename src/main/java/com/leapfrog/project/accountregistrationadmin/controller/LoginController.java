/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.project.accountregistrationadmin.controller;

import com.leapfrog.project.accountregistrationadmin.dao.UserDAO;
import com.leapfrog.project.accountregistrationadmin.dao.impl.UserDAOImpl;
import com.leapfrog.project.accountregistrationadmin.system.Controller;
import com.leapfrog.project.accountregistrationadmin.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HYOJU
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginController extends Controller {

    private UserDAO userDAO = new UserDAOImpl();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes(), 0, password.length());
            String finalPassword = (new BigInteger(1, m.digest()).toString(16));
            User user=userDAO.login(username, finalPassword);
            if(user!=null)
            {
                response.sendRedirect(request.getContextPath()+"/admin?success");
            }else
            {
                response.sendRedirect(request.getContextPath()+"/?error");
            }
        } catch (NoSuchAlgorithmException | SQLException | ClassNotFoundException|NullPointerException ex) {
            PrintWriter out=response.getWriter();
            out.println(ex.getLocalizedMessage());
        }

    }

}