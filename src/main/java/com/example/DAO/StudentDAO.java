package com.example.DAO;

import com.example.Entity.StudentEntity;

import java.util.Collection;

public interface StudentDAO {
    Collection<StudentEntity> getAllStudents();

    StudentEntity getStudentByID(int id);

    void removeStudentById(int id);

    void removeAllStudents();

    void updateStudent(StudentEntity entryStudent);

    void insertStudent(StudentEntity newStudent);
}
