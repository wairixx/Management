package com.example.Management.servicesImpl;

import com.example.Management.entities.Student;
import com.example.Management.repositories.StudentRepository;
import com.example.Management.services.StudentService;
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
    public Student findStudentByEmail(String email) {
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

    @Override
    public Boolean isNull(Student student) {
        if (student.getFirstName().contains(" ")
                || student.getLastName().contains(" ")
                || student.getEmail().contains(" ")) {
            return true;
        }
        return false;
    }

}

