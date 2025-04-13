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
        urlPatterns = {"/logout"},
        name = "LogoutWebServletControl" // name work as bean's name
)
public class LogoutWebServletControl extends HttpServlet {

    private Logger logger;

    public LogoutWebServletControl() {
        logger = LoggerFactory.getLogger(LogoutWebServletControl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getSession().invalidate(); // clear session why this session can't see on inspect browser ?
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }



}
