package com.begin.deltat.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
        Student mike = new Student(
          "Mike",
          "mike@gmail.com",
          LocalDate.of(2000, 9, 3),
          21
        );

        Student victor = new Student(
          "Victor",
          "victor@gmail.com",
          LocalDate.of(2005, 2, 6),
          19
      );

      repository.saveAll(
        List.of(mike, victor)
      );
    };
  }
}
