package com.example.userSBN.services;

import com.example.userSBN.model.User;

import java.util.List;

public interface IStudentService {

    List<User> findByNameEnding(String ending);
    List<User> findByName(String name);

}
