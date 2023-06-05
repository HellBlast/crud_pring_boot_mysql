package com.crudmysql.crudmysql.service;

import com.crudmysql.crudmysql.entity.Student;
import com.crudmysql.crudmysql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){

        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public void update(Long studentId, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            studentRepository.save(student);
        } else {
            throw new RuntimeException("No se encontró el estudiante con la ID: " + studentId);
        }
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}
