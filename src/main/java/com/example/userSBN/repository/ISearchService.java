package com.example.userSBN.repository;

import com.example.userSBN.model.User;

import java.util.List;

public interface ISearchService {

    List<User> findByNameEnding(String ending);
    List<User> findByName(String name);

}
