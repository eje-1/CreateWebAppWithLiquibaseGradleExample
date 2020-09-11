package com.example.userSBN.services;

import com.example.userSBN.model.User;
import com.example.userSBN.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements IStudentService{

    @Autowired
    SearchRepository repository;



    @Override
    public List<User> findByNameEnding(String ending) {

        User student = new User();
        student.setName(ending);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id");

        Example<User> example = Example.of(student, exampleMatcher);

        return (List<User>) repository.findAll(example);
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }
}
