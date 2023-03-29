package com.example.Management.controller;

import com.example.Management.entity.Student;
import com.example.Management.exeptions.CustomNotValidNameExeption;
import com.example.Management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

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
    public String saveNewStudent(@ModelAttribute("student") Student student, Model model, BindingResult result) {
        Student existingUser = studentService.findUserByEmail(student.getEmail());
        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already a student registered with the same email");
        }
        else if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "redirect:/students/new?error";
        }
        else if(student.getFirstName().equals("loh")){
            throw new CustomNotValidNameExeption("you can not use this name");
        }
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/admin/students/edit/{id}")
    public String editStudentsForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/admin/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model, BindingResult result) {
        Student existStudent = studentService.getStudentById(id);
        existStudent.setId(id);
        existStudent.setFirstName(student.getFirstName());
        existStudent.setLastName(student.getLastName());
        existStudent.setEmail(student.getEmail());
//
//        Student testStudent = studentService.findUserByEmail(existStudent.getEmail());
//
//        if (testStudent != null && testStudent.getEmail() != null && !testStudent.getEmail().isEmpty()) {
//            result.rejectValue("email", null,
//                    "There is already a student registered with the same email");
//        }
//        if (result.hasErrors()) {
//            model.addAttribute("student", student);
//            return "redirect:/students/edit/{id}?error";
//        }

        studentService.updateStudent(existStudent);
        return "redirect:/students";
    }

    @GetMapping("/admin/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
