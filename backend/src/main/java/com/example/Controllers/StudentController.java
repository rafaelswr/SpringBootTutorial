package com.example.Controllers;

import com.example.Models.Student;
import com.example.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(List.of(new Student()), HttpStatus.OK);
    }



}
