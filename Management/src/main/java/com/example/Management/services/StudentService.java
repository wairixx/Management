package com.example.Management.services;


import com.example.Management.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void save(Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student);

    Student findStudentByEmail(String email);

    void deleteStudent(Long id);

    Boolean isUsed(Student student);
    Boolean isNull(Student student);
}

