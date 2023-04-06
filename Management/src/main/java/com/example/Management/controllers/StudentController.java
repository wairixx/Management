package com.example.Management.controllers;

import com.example.Management.entities.Student;
import com.example.Management.services.StudentService;
import com.example.Management.services.StudentValidatorService;
import com.example.Management.validators.studentValidators.ValidateEmailIsAlreadyUsed;
import com.example.Management.validators.studentValidators.ValidateNotAllowedWord;
import com.example.Management.validators.studentValidators.ValidateNullStudent;
import com.example.Management.validators.studentValidators.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentValidatorService studentValidatorService;

    @GetMapping("/students")
    public String listOfStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/admin/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/admin/students/add")
    public String saveNewStudent(@ModelAttribute("student") Student student) {
       studentValidatorService.executeStudent(student);
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/admin/students/edit/{id}")
    public String editStudentsForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/admin/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        Student existStudent = studentService.getStudentById(id);
        existStudent.setId(id);
        existStudent.setFirstName(student.getFirstName());
        existStudent.setLastName(student.getLastName());
        existStudent.setEmail(student.getEmail());
        studentService.updateStudent(existStudent);
        return "redirect:/students";
    }

    @GetMapping("/admin/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
