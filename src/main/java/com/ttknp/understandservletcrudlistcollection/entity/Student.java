package com.ttknp.understandservletcrudlistcollection.entity;

public class Student {

    private int id;
    private String fullname;
    private int age;
    private int year;
    private String description;

    public Student(int id, String fullname, int age, int year, String description) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.year = year;
        this.description = description;
    }

    public Student() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Student{id=" + this.id + ", fullname='" + this.fullname + "', age=" + this.age + ", year=" + this.year + ", description='" + this.description + "'}";
    }
}