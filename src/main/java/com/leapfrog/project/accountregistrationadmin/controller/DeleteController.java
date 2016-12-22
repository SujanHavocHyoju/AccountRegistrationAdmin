/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.project.accountregistrationadmin.controller;

import com.leapfrog.project.accountregistrationadmin.dao.UserDAO;
import com.leapfrog.project.accountregistrationadmin.dao.impl.UserDAOImpl;
import com.leapfrog.project.accountregistrationadmin.system.Controller;
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
@WebServlet(name = "delete", urlPatterns = {"/delete/*"})
public class DeleteController extends Controller {

    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            if (userDAO.delete(id) > 0) {
                response.sendRedirect(request.getContextPath() + "/admin?success");
            } else {
                response.sendRedirect(request.getContextPath() + "/admin?error");
            }
        }catch (SQLException | ClassNotFoundException ex) {
            PrintWriter out = response.getWriter();
            out.println(ex.getLocalizedMessage());
        }
        request.getRequestDispatcher("/WEB-INF/views/admin/delete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

    }
}
