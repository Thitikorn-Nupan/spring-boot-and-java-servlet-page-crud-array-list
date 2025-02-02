package com.ttknp.understandservletcrudlistcollection.webservlet_controller;

import com.ttknp.understandservletcrudlistcollection.entity.Student;
import com.ttknp.understandservletcrudlistcollection.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

// *** @WebServlet annotation work same @Controller
// *** doGet,Post,Put,... work same @Get,Post,Put,...Mapping
@WebServlet(
        urlPatterns = {"/students.table"},
        name = "StudentWebServletControl" // name work as bean's name
)
public class StudentWebServletControl extends HttpServlet {

    private Logger logger;
    private StudentService studentService;

    public StudentWebServletControl() {
        studentService = new StudentService();
        logger = LoggerFactory.getLogger(StudentWebServletControl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String emailFromSession = req.getSession().getAttribute("email").toString();
        req.setAttribute("email", emailFromSession);
        req.setAttribute("students", studentService.getStudentList());
        req.getRequestDispatcher("/WEB-INF/views/students_table.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        // logger.debug(code);
        if (code.equals("read")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Student student = studentService.getStudentById(id);
            req.setAttribute("student", student);
            req.getRequestDispatcher("/WEB-INF/views/student_form_edit.jsp").forward(req, resp);
        }
        if (code.equals("form")) {
            req.getRequestDispatcher("/WEB-INF/views/student_form_add.jsp").forward(req, resp);
        }
        if (code.equals("update")) {
            doPut(req, resp);
        }
        if (code.equals("delete")) {
            doDelete(req, resp);
        }
        if (code.equals("create")) {
            String fullname = (String) req.getParameter("fullname");
            int age = Integer.parseInt((String) req.getParameter("age"));
            int year = Integer.parseInt((String) req.getParameter("year"));
            String description = (String) req.getParameter("description");
            Student studentNew = new Student(0, fullname, age, year, description);
            studentService.addStudent(studentNew);
            resp.sendRedirect("/students.table");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String fullname = (String) req.getParameter("fullname");
        int age = Integer.parseInt((String) req.getParameter("age"));
        int year = Integer.parseInt((String) req.getParameter("year"));
        String description = (String) req.getParameter("description");
        Student studentNew = new Student(0, fullname, age, year, description);
        studentService.updateStudent(studentNew, id);
        resp.sendRedirect("/students.table");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.deleteStudent(id);
        resp.sendRedirect("/students.table");
    }
}
