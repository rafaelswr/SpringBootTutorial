package com.example;


import com.example.Models.Student;
import com.example.Repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository studentRepository){
        return args -> {
            Student alex = new Student( "Alex", "alex@gmail.com",LocalDate.of(2000,DECEMBER, 5));
            Student mariam = new Student("Mariam", "mariam@gmail.com",LocalDate.of(2004,MARCH, 11));

            studentRepository.saveAll(
                    List.of(alex,mariam)
            );
        };
    }

}


