package com.example.userSBN;

import com.example.userSBN.controller.ManyToManyTest;
import com.example.userSBN.model.Faecher;
import com.example.userSBN.model.User;
import com.example.userSBN.repository.FaecherRepository;
import com.example.userSBN.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


/*Die Annotation @SpringBootApplication ist eine Sammel-Annotation, die @Configuration, @EnableAutoConfiguration und @ComponentScan bündelt.*/
@SpringBootApplication
public class UserSbnApplication {


	public static void main(String[] args) {
		SpringApplication.run(UserSbnApplication.class, args);

	}

}
