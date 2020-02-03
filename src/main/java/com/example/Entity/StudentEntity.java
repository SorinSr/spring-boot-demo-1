package com.example.Entity;

public class StudentEntity {
    private int ID;
    private String name;
    private String course;

    public StudentEntity() {
    }

    public StudentEntity(int ID, String name, String course) {
        this.ID = ID;
        this.name = name;
        this.course = course;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
