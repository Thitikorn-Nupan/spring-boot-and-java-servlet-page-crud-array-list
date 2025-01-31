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

@Controller
public class StudentControl {
    private Logger logger;
    private StudentService studentService;

    public StudentControl() {
        studentService = new StudentService();
        logger = LoggerFactory.getLogger(StudentControl.class);
    }

    @GetMapping({"", "/"})
    private ModelAndView getStudentsTableJSP(ModelAndView modelAndView) {
        modelAndView.setViewName("students_table");
        modelAndView.addObject("students", this.studentService.getStudentList());
        return modelAndView;
    }

    @GetMapping("/form")
    private ModelAndView getForm(ModelAndView modelAndView, @RequestParam Map<String, String> body) {
        this.logger.info("{}", body);
        int id = Integer.parseInt((String)body.get("id"));
        if (((String)body.get("code")).equals("edit")) {
            Student student = this.studentService.getStudentById(id);
            modelAndView.addObject("student", student);
            modelAndView.setViewName("student_form_edit");
        } else if (((String)body.get("code")).equals("add")) {
            modelAndView.setViewName("student_form_add");
        }

        return modelAndView;
    }

    @PostMapping("/remove")
    private ModelAndView removeStudent(ModelAndView modelAndView, @RequestParam Map<String, String> body) {
        int id = Integer.parseInt((String)body.get("id"));
        this.logger.info("{}", this.studentService.getStudentList().size());
        if (this.studentService.getStudentList().size() == 1) {
            modelAndView.setViewName("redirect:/");
        } else if (this.studentService.deleteStudent(id)) {
            this.logger.info("Removed student with id {}", id);
        } else {
            this.logger.info("Failed to remove student with id {}", id);
        }

        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @PostMapping({"/edit"})
    private ModelAndView editStudent(ModelAndView modelAndView, @RequestParam Map<String, String> body) {
        int id = Integer.parseInt((String)body.get("id"));
        Student studentNew = getStudent(body);
        if (this.studentService.updateStudent(studentNew, id)) {
            this.logger.info("Edited student with id {}", id);
        } else {
            this.logger.info("Failed to edit student with id {}", id);
        }

        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @PostMapping({"/add"})
    private ModelAndView addStudent(ModelAndView modelAndView, @RequestParam Map<String, String> body) {
        Student studentNew = getStudent(body);
        List<Student> studentList = this.studentService.getStudentList();
        int size = studentList.size();
        int lastId = ((Student)studentList.get(size - 1)).getId();
        studentNew.setId(lastId + 1);
        if (this.studentService.addStudent(studentNew)) {
            this.logger.info("Added student");
        } else {
            this.logger.info("Failed to added student ");
        }

        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    private static Student getStudent(Map<String, String> body) {
        String fullname = (String)body.get("fullname");
        int age = Integer.parseInt((String)body.get("age"));
        int year = Integer.parseInt((String)body.get("year"));
        String description = (String)body.get("description");
        Student studentNew = new Student(0, fullname, age, year, description);
        return studentNew;
    }
}
