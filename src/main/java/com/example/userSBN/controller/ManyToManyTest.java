package com.example.userSBN.controller;

import com.example.userSBN.model.Faecher;
import com.example.userSBN.model.User;
import com.example.userSBN.repository.FaecherRepository;
import com.example.userSBN.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class ManyToManyTest {

    @Bean
    public CommandLineRunner mappingDemo(UserRepository userRepository,
                                         FaecherRepository faecherRepository){
        return args -> {

            //Create student
            User student = new User("Test","Student","","","","","","","","");

            userRepository.save(student);

            //Create three courses
            Faecher course1 = new Faecher("Mathe","M","Grundschule");
            Faecher course2 = new Faecher("Deutsch","D","Grundschule");
            Faecher course3 = new Faecher("Biologie","B","Grundschule");

            faecherRepository.saveAll(Arrays.asList(course1,course2,course3));

            student.getCourses().addAll(Arrays.asList(course1,course2,course3));

            userRepository.save(student);

        };
    }

}
