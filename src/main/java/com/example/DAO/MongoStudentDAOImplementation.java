package com.example.DAO;

import com.example.Entity.StudentEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@Repository
@Qualifier("mongoData")
public class MongoStudentDAOImplementation implements StudentDAO {

    @Override
    public Collection<StudentEntity> getAllStudents() {
        return null;
    }

    @Override
    public StudentEntity getStudentByID(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void removeAllStudents() {

    }

    @Override
    public void updateStudent(StudentEntity entryStudent) {

    }

    @Override
    public void insertStudent(StudentEntity newStudent) {

    }
}
