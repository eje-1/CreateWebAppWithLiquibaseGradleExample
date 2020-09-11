package com.example.userSBN.controller;

import com.example.userSBN.model.User;
import com.example.userSBN.repository.FaecherRepository;
import com.example.userSBN.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableAutoConfiguration
@RestController
public class SearchController {

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    FaecherRepository repository;


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<User> search(@RequestBody final User student) {

        // COUNT Students
        System.out.println("\nGet count of Studnets");
        System.out.println("Number of Students inserted : " + searchRepository.count());

        // RETRIEVE ALL 'Biologie' students - Using QueryByExample
        System.out.println("\nRetreving all 'Biologie' students - Using QueryByExample(QBE)");

        searchRepository.findAll();

        //Filter
        User findStudent1 = new User();
        findStudent1.setOrt("Berlin");
        Example<User> example = Example.of(findStudent1);

        List<User> result = searchRepository.findAll(example);
        for (User studnetBremen : result) {

            System.out.println(studnetBremen);
        }

        return searchRepository.findAll(Example.of(findStudent1,
                ExampleMatcher.matchingAll()
                        .withIgnoreNullValues()
                        .withIgnorePaths("id")
                        .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)));
    }


}