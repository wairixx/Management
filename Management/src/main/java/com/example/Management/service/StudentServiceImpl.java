package com.example.Management.service;

import com.example.Management.entity.Student;
import com.example.Management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findUserByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Boolean isUsed(Student student) {
        Student studentFromBD = studentRepository.findByEmail(student.getEmail());
        if (studentFromBD != null && (studentFromBD.getEmail().equals(student.getEmail()))) {
            return true;
        }
        return false;
    }
}

