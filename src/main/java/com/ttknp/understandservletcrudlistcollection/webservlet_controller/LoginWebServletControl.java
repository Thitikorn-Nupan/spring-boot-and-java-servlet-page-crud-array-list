package com.ttknp.understandservletcrudlistcollection.webservlet_controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

// *** @WebServlet annotation work same @Controller *** doGet,doPost,doPut,... work same @Get,Post,Put,...Mapping
@WebServlet(
        urlPatterns = {"/login"},
        name = "LoginWebServletControl" // name work as bean's name
)
public class LoginWebServletControl extends HttpServlet {

    private final Logger logger;

    public LoginWebServletControl() {
        logger = LoggerFactory.getLogger(LoginWebServletControl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailAsParam = (String) req.getParameter("email");
        String passwordParam = (String) req.getParameter("password");
        if (emailAsParam.equals("ttknp@hotmail.com") && passwordParam.equals("12345")) {
            req.getSession().setAttribute("email", emailAsParam);
            resp.sendRedirect("/students.table");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
