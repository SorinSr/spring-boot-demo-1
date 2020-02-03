package com.example.Controller;

import com.example.Entity.StudentEntity;
import com.example.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<StudentEntity> getAllStudens(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StudentEntity getStudentByID(@PathVariable("id") int id){
        return studentService.getStudentByID(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String removeStudentById(@PathVariable int id){
        studentService.removeStudentById(id);
        return "Student with id "+id+" deleted";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String removeAllStudentaAll(){
        studentService.removeAllStudents();
        return "All students deleted";
    }

   @RequestMapping (method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateStudent(@RequestBody StudentEntity studentEntity){
        studentService.updateStudent(studentEntity);
        return "Student "+studentEntity.getID()+" updated";
   }

   @RequestMapping (method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertStudent(@RequestBody StudentEntity studentEntity){
        studentService.insertStudent(studentEntity);
       return "Student "+studentEntity.getID()+" inserted";
   }

   //https://www.youtube.com/watch?v=Ke7Tr4RgRTs
    //36:43
}
