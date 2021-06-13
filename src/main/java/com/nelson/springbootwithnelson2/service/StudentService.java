package com.nelson.springbootwithnelson2.service;

import com.nelson.springbootwithnelson2.models.Student;
import com.nelson.springbootwithnelson2.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudent(){
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> optionalStudent = studentRepo.findStudentByEmail(student.getEmail());
        if(optionalStudent.isPresent()){
            throw new IllegalStateException("Email Already Exists");
        }
        studentRepo.save(student);
    }
}
