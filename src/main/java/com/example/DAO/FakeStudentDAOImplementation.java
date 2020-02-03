package com.example.DAO;

import com.example.Entity.StudentEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeStudentDAOImplementation implements StudentDAO {

    private static Map<Integer, StudentEntity> studentsMap;

    static {
        studentsMap = new HashMap<Integer, StudentEntity>() {
            {
                put(1000, new StudentEntity(1000, "Geo", "AI & ML"));
                put(1001, new StudentEntity(1001, "Ion", "Computer science"));
                put(1002, new StudentEntity(1002, "Vasile", "Arts"));
                put(1003, new StudentEntity(1003, "Gigi", "Computer science"));
                put(1004, new StudentEntity(1004, "Vivi", "Computer science"));
                put(1005, new StudentEntity(1005, "Miha", "Geography"));
                put(1006, new StudentEntity(1006, "Nuti", "Cooking"));
            }
        };
    }

    @Override
    public Collection<StudentEntity> getAllStudents() {
        return FakeStudentDAOImplementation.studentsMap.values();
    }

    @Override
    public StudentEntity getStudentByID(int id) {
        return FakeStudentDAOImplementation.studentsMap.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        FakeStudentDAOImplementation.studentsMap.remove(id);
    }

    @Override
    public void removeAllStudents() {
        FakeStudentDAOImplementation.studentsMap.values().clear();
    }

    @Override
    public void updateStudent(StudentEntity entryStudent) {
        StudentEntity newStudentUpdated = new StudentEntity();

        newStudentUpdated = studentsMap.get(entryStudent.getID());
        newStudentUpdated.setName(entryStudent.getName());
        newStudentUpdated.setCourse(entryStudent.getCourse());

        studentsMap.remove(entryStudent.getID());

        studentsMap.put(entryStudent.getID(), newStudentUpdated);
    }

    @Override
    public void insertStudent(StudentEntity newStudent) {
            if (studentsMap.keySet().contains(newStudent.getID())) {
                studentsMap.put(Integer.parseInt("999" + newStudent.getID())
                        , new StudentEntity(Integer.parseInt("999" + newStudent.getID()), newStudent.getName(), newStudent.getCourse()));
            } else {
                studentsMap.put(newStudent.getID(), new StudentEntity(newStudent.getID(), newStudent.getName(), newStudent.getCourse()));
            }

    }
}
