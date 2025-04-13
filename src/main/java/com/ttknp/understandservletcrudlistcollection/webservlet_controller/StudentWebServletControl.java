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

// *** @WebServlet annotation work same @Controller *** doGet,doPost,doPut,... work same @Get,Post,Put,...Mapping
@WebServlet(
        urlPatterns = {"/students.table","/students"},
        name = "StudentWebServletControl" // name work as bean's name
)
public class StudentWebServletControl extends HttpServlet {

    private final Logger logger;
    private final StudentService studentService;

    public StudentWebServletControl() {
        studentService = new StudentService();
        logger = LoggerFactory.getLogger(StudentWebServletControl.class);
    }

    // Http GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set req/res
        String emailFromSession = request.getSession().getAttribute("email").toString();
        response.setContentType("text/html");
        // set up data to jsp file tru HttpServletRequest class ,
        // you can get data by request.getAttribute("students"), request.getAttribute("email")
        request.setAttribute("email", emailFromSession);
        request.setAttribute("students", studentService.getStudentList());
        request
                // RequestDispatcher object that acts as a wrapper for the resource located at the given path
                // 1 Parameter
                // path : a String specifying the pathname to the resource. If it is relative, it must be relative against the current servlet.
                .getRequestDispatcher("/WEB-INF/views/students_table.jsp")
                // Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
                // This method allows one servlet to do preliminary processing of a request and another resource to generate the response.
                // 2 Parameters
                // request : a ServletRequest object that represents the request the client makes of the servlet (client req)
                // response : object that represents the response the servlet returns to the client (client response)
                .forward(request, response);
    }

    // Http POST ** manage logic
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code.equals("read")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = studentService.getStudentById(id);
            // set up data to jsp file tru HttpServletRequest class ,
            // you can get data by request.getAttribute("students"), request.getAttribute("email")
            request.setAttribute("student", student);
            request
                    // RequestDispatcher object that acts as a wrapper for the resource located at the given path
                    .getRequestDispatcher("/WEB-INF/views/student_form_edit.jsp")
                    // Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
                    .forward(request, response);
        }
        if (code.equals("form")) {
            request.getRequestDispatcher("/WEB-INF/views/student_form_add.jsp").forward(request, response);
        }
        if (code.equals("update")) {
            doPut(request, response);
        }
        if (code.equals("delete")) {
            doDelete(request, response);
        }
        if (code.equals("create")) {
            // it's on http post
            Student studentNew = getStudentFromReq(request);
            studentService.addStudent(studentNew);
            response.sendRedirect("/students.table");
        }
    }

    // Http PUT
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student studentNew = getStudentFromReq(request);
        studentService.updateStudent(studentNew, id);
        response.sendRedirect("/students.table");
    }

    // Http DELETE
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.deleteStudent(id);
        resp.sendRedirect("/students.table");
    }

    private Student getStudentFromReq(HttpServletRequest request) {
        String fullname =  request.getParameter("fullname");
        int age = Integer.parseInt( request.getParameter("age") );
        int year = Integer.parseInt( request.getParameter("year") );
        String description =  request.getParameter("description");
        Student studentNew = new Student(0, fullname, age, year, description);
        return studentNew;
    }
}
