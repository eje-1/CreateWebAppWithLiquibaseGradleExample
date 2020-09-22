package com.example.userSBN.controller;

import com.example.userSBN.model.User;
import com.example.userSBN.repository.ISearchService;
import com.example.userSBN.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.query.Param;
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
    ISearchService iSearchService;


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<User> search(@Param("key") String key) {

        // COUNT Students
        System.out.println("\nGet count of Studnets");
        System.out.println("Number of Students inserted : " + searchRepository.count());


        return iSearchService.findByName(key);

    }

    @RequestMapping(value = "/searchAll", method = RequestMethod.POST)
    public List<User> searchFindAll(@RequestBody final User findStudent) {

        return searchRepository.findAll(Example.of(findStudent,
                ExampleMatcher.matchingAny()
                        .withIgnoreNullValues()
                        .withIgnorePaths("id")
                        .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)));


    }



}