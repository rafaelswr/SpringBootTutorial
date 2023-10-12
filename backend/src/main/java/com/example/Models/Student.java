package com.example.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {


    private Long id;
    private String name;
    private String email;
    private int age;
    private LocalDate dob;


}
