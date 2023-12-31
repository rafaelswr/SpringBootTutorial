package com.example.Controllers;

import com.example.Models.Student;
import com.example.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @PostMapping("/send")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping( "/{studentID}")
    public void deleteStudent(@PathVariable Long studentID){
        studentService.deleteStudent(studentID);
    }

    @GetMapping("/list/{studentId}")
    public ResponseEntity<Optional<Student>> studentById(@PathVariable Long studentId){
        return new ResponseEntity<>(studentService.getStudentById(studentId),HttpStatus.OK);
    }

    @PutMapping("/list/{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody Student studentUpdated){
        studentService.updateStudent(studentId, studentUpdated);
    }



}