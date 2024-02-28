package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfic {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args ->
        {
            Student niloy = new Student("niloy", LocalDate.of(2000, JANUARY, 1),
                    "mehrabniloy1909@gmail.com"
            );

            Student aziza = new Student(
                     "aziza", LocalDate.of(2002, JANUARY, 1),
                    "mirzaaziza1909@gmail.com"
            );
            repository.saveAll(
                    List.of(niloy,aziza)
            );
        };
    }
}
