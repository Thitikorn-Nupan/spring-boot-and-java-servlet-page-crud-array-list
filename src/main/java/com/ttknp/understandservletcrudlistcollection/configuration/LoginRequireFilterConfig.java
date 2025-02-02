package com.ttknp.understandservletcrudlistcollection.configuration;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebFilter(urlPatterns = {"/students.table"})
public class LoginRequireFilterConfig implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        logger.debug("filter init");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.debug("filtering uri {}, code {}", req.getRequestURI(), req.getParameter("code"));
        try {
            String emailFromSession = req.getSession().getAttribute("email").toString();
            logger.info(emailFromSession);
            // basic valid
            if (emailFromSession.equals("ttknp@hotmail.com")) {
                chain.doFilter(request, response); // note if you need to do follow your servlet on you /todo  just add
            }
        } catch (NullPointerException e) {
            logger.debug("Null pointer exception means user is not logged in ");
            res.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        logger.debug("filter destroy");
    }
}
