package com.nelson.springbootwithnelson2.configuration;

import com.nelson.springbootwithnelson2.models.Student;
import com.nelson.springbootwithnelson2.repo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.JANUARY;


@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo){
        return args -> {
            Student ameen = new Student(
                    1,
                    "ameen",
                    "ameen@gmail.com",
                    LocalDate.of(2000, JANUARY, 5));
            Student shanil = new Student(
                    "shani",
                    "shani@gmail.com",
                    LocalDate.of(2006, APRIL, 10));

            studentRepo.saveAll(List.of(ameen, shanil));
        };
    }
}
