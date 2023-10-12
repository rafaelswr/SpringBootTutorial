package com.example.Services;

import com.example.Models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return List.of(new Student(), new Student());
    }

}
