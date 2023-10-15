package com.example.Services;

import com.example.Models.Student;
import com.example.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save((student));
    }

    public void addNewStudent(Student student) {
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new IllegalStateException("email taken");
        }else{
            studentRepository.save(student);
        }
    }
}
