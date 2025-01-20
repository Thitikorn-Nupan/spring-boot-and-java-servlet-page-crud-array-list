package com.ttknp.understandservletcrudlistcollection.service;

import com.ttknp.understandservletcrudlistcollection.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> studentList = new ArrayList();

    public StudentService() {
        this.studentList.add(new Student(1, "Peter Parker", 20, 3, "Be real"));
        this.studentList.add(new Student(2, "Mark Sli", 22, 3, "Anything god was build"));
        this.studentList.add(new Student(3, "Don Ryder", 22, 3, "Try to be a good person"));
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public boolean deleteStudent(int id) {
        for(Student student : this.studentList) {
            if (student.getId() == id) {
                this.studentList.remove(student);
                return true;
            }
        }

        return false;
    }

    public Student getStudentById(int id) {
        for(Student student : this.studentList) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public boolean updateStudent(Student studentNew, int id) {
        for(Student studentHold : this.studentList) {
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
        this.studentList.add(studentNew);
        return true;
    }
}