package com.example.Service;

import com.example.DAO.StudentDAO;
import com.example.Entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier("fakeData")
    private StudentDAO studentDAO;

    public Collection<StudentEntity> getAllStudents(){
        System.out.println("~~~~~~ All "+ studentDAO.getAllStudents().size()+" student returned");
        return studentDAO.getAllStudents();
    }

    public StudentEntity getStudentByID(int id){
        if (studentDAO.getStudentByID(id) != null){
            System.out.println("~~~~~~ Student with id "+id+" returned");
            return studentDAO.getStudentByID(id);
        }else{
            System.out.println("~~~~~~ Student with id "+id+" doesn't exist");
            return new StudentEntity();
        }
    }

    public void removeStudentById(int id){
        System.out.println("~~~~~~ Student with id "+id+" deleted");
        studentDAO.removeStudentById(id);
    }

    public void removeAllStudents(){
        studentDAO.removeAllStudents();
        System.out.println("~~~~~~ Students removed");
    }

    public void updateStudent(StudentEntity studentEntity){
        studentDAO.updateStudent(studentEntity);
        System.out.println("~~~~~~ Student "+ studentEntity.getID()+" updated");
    }

    public void insertStudent(StudentEntity studentEntity){
        studentDAO.insertStudent(studentEntity);
        System.out.println("~~~~~~ Student "+ studentEntity.getID()+" inserted");
    }

}
