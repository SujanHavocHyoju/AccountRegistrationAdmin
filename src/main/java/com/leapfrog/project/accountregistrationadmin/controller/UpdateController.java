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
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HYOJU
 */
@WebServlet(name = "update", urlPatterns = {"/update"})
public class UpdateController extends Controller {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        if (request.getParameter("id") != null || !request.getParameter("id").isEmpty()) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                User u = userDAO.getById(id);
                request.setAttribute("user", u);
            }catch (SQLException | ClassNotFoundException ex) {
                PrintWriter out = response.getWriter();
                out.println(ex.getLocalizedMessage());
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/?error");
        }

        request.getRequestDispatcher("/WEB-INF/views/admin/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        
        try {
            User u = new User();
            u.setFirstName(firstName);
            u.setLastName(lastName);
            u.setEmail(email);
            u.setUsername(username);
            u.setId(Integer.parseInt(id));
            if (userDAO.update(u) > 0) {
                response.sendRedirect(request.getContextPath() + "/admin?success");
            } else {
                response.sendRedirect(request.getContextPath() + "/admin?error");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            PrintWriter out = response.getWriter();
            out.println(ex.getLocalizedMessage());
        }

    }

}
