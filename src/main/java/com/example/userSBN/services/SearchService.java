package com.example.userSBN.services;

import com.example.userSBN.model.User;
import com.example.userSBN.repository.ISearchService;
import com.example.userSBN.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements ISearchService {

    @Autowired
    SearchRepository repository;


    public List<User> findByNameEnding(String ending) {

        List<User> userList;

        User student = new User();
        student.setName(ending);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withMatcher("name", match -> match.endsWith());

        Example<User> userExample = Example.of(student, exampleMatcher);

        userList = repository.findAll(userExample);

        return userList;

    }


    public List<User> findByName(String name) {
        User student = new User();
        student.setName(name);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id");

        Example<User> example = Example.of(student, exampleMatcher);

        return (List<User>) repository.findAll(example);
    }
}
