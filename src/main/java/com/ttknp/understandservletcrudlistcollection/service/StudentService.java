package com.ttknp.understandservletcrudlistcollection.service;

import com.ttknp.understandservletcrudlistcollection.entity.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> studentList;

    public StudentService() {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Peter Parker", 20, 3, "Be real"));
        studentList.add(new Student(2, "Mark Sli", 22, 3, "Anything god was build"));
        studentList.add(new Student(3, "Don Ryder", 22, 3, "Try to be a good person"));
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public boolean deleteStudent(int id) {
        for(Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

    public Student getStudentById(int id) {
        for(Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(Student studentNew, int id) {
        for(Student studentHold : studentList) {
            if (studentHold.getId() == id) {
                studentHold.setFullname(studentNew.getFullname());
                studentHold.setAge(studentNew.getAge());
                studentHold.setYear(studentNew.getYear());
                studentHold.setDescription(studentNew.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean addStudent(Student studentNew) {
        studentList.add(studentNew);
        return true;
    }
}