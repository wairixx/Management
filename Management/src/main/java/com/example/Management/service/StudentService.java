package com.example.Management.service;


import com.example.Management.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void save(Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student);

    Student findUserByEmail(String email);

    void deleteStudent(Long id);

    Boolean isUsed(Student student);
}

