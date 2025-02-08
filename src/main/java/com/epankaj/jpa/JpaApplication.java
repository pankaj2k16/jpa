package com.epankaj.jpa;

import com.epankaj.jpa.models.Author;
import com.epankaj.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository authorRepository
    ) {
        return args -> {
            System.out.println("Hello World");
            var author = Author.builder()
                    .firstName("Pankaj")
                    .lastName("Kumar")
                    .email("pankajsoe44@gmail.com")
                    .createdAt(java.time.LocalDateTime.now())
                    .age(25)
                    .build();
            authorRepository.save(author);

        };
    }

}
