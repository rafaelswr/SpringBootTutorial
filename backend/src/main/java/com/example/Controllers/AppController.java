package com.example.Controllers;

import com.example.Models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class AppController {

    @GetMapping("/")
    public ResponseEntity<String> greetings() {
        return new ResponseEntity<>("Ola", HttpStatus.OK);
    }

    @GetMapping("/error")
    public ResponseEntity<String> error(){
        return new ResponseEntity<>("Error", HttpStatus.OK);
    }

}
