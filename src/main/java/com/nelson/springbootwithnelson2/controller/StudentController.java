package com.nelson.springbootwithnelson2.controller;


import com.nelson.springbootwithnelson2.models.Student;
import com.nelson.springbootwithnelson2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path={"","index"})
    public String index(Model model){
        model.addAttribute("title","List Of Students");
        model.addAttribute("students",studentService.getStudent());
        return "student/index";
    }

    @GetMapping(path="add")
    public String displayAddStudentForm(Model model){
        model.addAttribute("title","Add Students");
        model.addAttribute(new Student());
        return "student/add";
    }
    @PostMapping(path="add")
    public String addNewStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return "student/add";
    }


}
