package com.example.Management;

import com.example.Management.entities.Student;
import com.example.Management.repositories.StudentRepository;
import com.example.Management.servicesImpl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;

    private final Long ID = 1l;
    private final String FIRST_NAME = "Sasha";
    private final String LAST_NAME = "Mekhanicheva";
    private final String EMAIL = "sasha@gmail.com";
    Student student;
    @BeforeEach
    private void init(){
        student = new Student(ID, FIRST_NAME, LAST_NAME, EMAIL);
    }

    @Test
    public void getAllStudentsTest() {
        List<Student> students = getAllStudents();
        when(studentRepository.findAll()).thenReturn(students);
        studentService.getAllStudents();
        assertEquals(students.size(), studentService.getAllStudents().size());
    }
    private List<Student> getAllStudents(){
        List<Student> allStudents = new ArrayList<>();
        Student student = new Student(1l, "Sasha", "Mekhanicheva", "sasha@gmail.com");
        Student student1 = new Student(2l, "Sasha", "Mekhanicheva", "sasha@gmail.com");
        allStudents.add(student1);
        allStudents.add(student);
        return allStudents;
    }
    @Test
    public void getStudentByIdTest(){
        when(studentRepository.findById(ID)).thenReturn(Optional.ofNullable(student));
        Student student1 = studentService.getStudentById(ID);
        assertEquals(student.getId(), student1.getId());
    }
    @Test
    public void getStudentByEmailTest(){
        when(studentRepository.findByEmail(EMAIL)).thenReturn(student);
        Student student1 = studentService.findStudentByEmail(EMAIL);
        assertEquals(student.getEmail(), student1.getEmail());
    }
    @Test
    public void isUsedTest(){
        when(studentRepository.findByEmail(EMAIL)).thenReturn(student);
        Boolean test = studentService.isUsed(student);
        assertEquals(true, test);
    }
    @Test
    public void isUsedTest2(){
        when(studentRepository.findByEmail(EMAIL)).thenReturn(null);
        Boolean test = studentService.isUsed(student);
        assertEquals(false, test);
    }
    @Test
    public void isNullTest(){
       Boolean test = studentService.isNull(student);
       assertEquals(false, test);
    }
    @Test
    public void isNullTest2(){
        Student student1 = new Student(ID, " ", LAST_NAME, EMAIL);
        Boolean test = studentService.isNull(student1);
        assertEquals(true, test);
    }
    @Test
    public void isNullTest3(){
        Student student1 = new Student(ID, FIRST_NAME, " ", EMAIL);
        Boolean test = studentService.isNull(student1);
        assertEquals(true, test);
    }
    @Test
    public void isNullTest4(){
        Student student1 = new Student(ID, FIRST_NAME, LAST_NAME, " ");
        Boolean test = studentService.isNull(student1);
        assertEquals(true, test);
    }
}
