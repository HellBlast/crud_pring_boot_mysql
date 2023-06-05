package com.crudmysql.crudmysql.controller;

import com.crudmysql.crudmysql.entity.Student;
import com.crudmysql.crudmysql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")
    public Optional <Student> getBId(@PathVariable("studentId") Long studentId){
        return studentService.getStudent(studentId);
    }

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @PutMapping("/{studentId}")
    public void update(@PathVariable("studentId") Long studentId, @RequestBody Student student) {
        studentService.update(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    public void saveUpdate(@PathVariable("studentId") Long studentID){
        studentService.delete(studentID);
    }
}
