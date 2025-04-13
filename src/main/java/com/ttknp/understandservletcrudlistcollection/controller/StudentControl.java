package com.ttknp.understandservletcrudlistcollection.controller;

import com.ttknp.understandservletcrudlistcollection.entity.Student;
import com.ttknp.understandservletcrudlistcollection.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

// Note, this @Controller isn't same thing with @WebServlet
// So when you req on @Controller it's not go ahead to @WebServlet
// *** @WebServlet it has basic security you can't straight get students_table.jsp , have to do login first
@Controller
public class StudentControl {
    private final Logger logger;
    private final StudentService studentService;

    public StudentControl() {
        studentService = new StudentService();
        logger = LoggerFactory.getLogger(StudentControl.class);
    }

    @GetMapping({"", "/"})
    private ModelAndView getStudentsTableJSP(ModelAndView modelAndView) {
        modelAndView.setViewName("students_table");
        modelAndView.addObject("students", studentService.getStudentList());
        return modelAndView;
    }

    @GetMapping("/form")
    private ModelAndView getForm(ModelAndView modelAndView, @RequestParam Map<String, String> body) {
        logger.info("{}", body);
        int id = Integer.parseInt(body.get("id"));
        if ((body.get("code")).equals("edit")) {
            Student student = studentService.getStudentById(id);
            modelAndView.addObject("student", student);
            modelAndView.setViewName("student_form_edit");
        } else if ((body.get("code")).equals("add")) {
            modelAndView.setViewName("student_form_add");
        }

        return modelAndView;
    }

    @PostMapping("/remove")
    private ModelAndView removeStudent(ModelAndView modelAndView, @RequestParam Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        this.logger.info("{}", studentService.getStudentList().size());
        if (studentService.getStudentList().size() == 1) {
            modelAndView.setViewName("redirect:/");
        } else if (studentService.deleteStudent(id)) {
            logger.info("Removed student with id {}", id);
        } else {
            logger.info("Failed to remove student with id {}", id);
        }
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @PostMapping({"/edit"})
    private ModelAndView editStudent(ModelAndView modelAndView, @RequestParam Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        Student studentNew = getStudent(body);
        if (studentService.updateStudent(studentNew, id)) {
            logger.info("Edited student with id {}", id);
        } else {
            logger.info("Failed to edit student with id {}", id);
        }

        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @PostMapping({"/add"})
    private ModelAndView addStudent(ModelAndView modelAndView, @RequestParam Map<String, String> body) {
        Student studentNew = getStudent(body);
        List<Student> studentList = studentService.getStudentList();
        int size = studentList.size();
        int lastId = (studentList.get(size - 1)).getId();
        studentNew.setId(lastId + 1);
        if (studentService.addStudent(studentNew)) {
            logger.info("Added student");
        } else {
            logger.info("Failed to added student ");
        }

        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    private Student getStudent(Map<String, String> body) {
        String fullname = body.get("fullname");
        int age = Integer.parseInt(body.get("age"));
        int year = Integer.parseInt(body.get("year"));
        String description = body.get("description");
        Student studentNew = new Student(0, fullname, age, year, description);
        return studentNew;
    }
}
